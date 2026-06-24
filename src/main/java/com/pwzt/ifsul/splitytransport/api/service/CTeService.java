package com.pwzt.ifsul.splitytransport.api.service;

import com.pwzt.ifsul.splitytransport.api.dto.response.ResponseMensagem;
import com.pwzt.ifsul.splitytransport.api.dto.response.cte.ResponseCTe;
import com.pwzt.ifsul.splitytransport.api.dto.response.cte.ResponseCTeEmissao;
import com.pwzt.ifsul.splitytransport.api.repository.InjectionProvider;
import com.pwzt.ifsul.splitytransport.core.complextype.cte.TcCTE;
import com.pwzt.ifsul.splitytransport.core.exception.ComunicationException;
import com.pwzt.ifsul.splitytransport.core.exception.DocumentoValidationException;
import com.pwzt.ifsul.splitytransport.core.factory.ResponseFactory;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.model.document.CTe;
import com.pwzt.ifsul.splitytransport.core.model.enumerator.TipoDocumento;
import com.pwzt.ifsul.splitytransport.core.xmljsonbean.XmlJsonBean;
import com.pwzt.ifsul.splitytransport.core.xmljsonbean.XmlJsonBeanResolver;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class CTeService implements DocumentoService<TcCTE, ResponseCTe>{

    private RestClient restClient = RestClient.builder().baseUrl("https://localhost:8085/api").build();

    @Autowired
    private XmlJsonBeanResolver xmlJsonBeanResolver;

    @Override
    public ResponseCTe emitir(TcCTE tcCte, Long transportId) {

        Transporte transporte = InjectionProvider.getTransporteRepository().findById(transportId)
                .orElseThrow(() -> new DocumentoValidationException("Código do transporte não cadastrado para vinculo CTe"));

        CTe cteBd = transporte.getCte();
        cteBd.getStatus().emitir(cteBd);

        XmlJsonBean<TcCTE, CTe> xmlJsonBean = xmlJsonBeanResolver.resolve(TipoDocumento.CTE);
        xmlJsonBean.updateDocumentAndTc(tcCte, cteBd);

        try{
            String xmlEnvio = xmlJsonBean.tcToXmlConverter(tcCte);

            ResponseCTeEmissao response = restClient.post()
                    .uri("/sefaz/cte/emitir")
                    .contentType(MediaType.APPLICATION_XML)
                    .body(xmlEnvio)
                    .retrieve()
                    .body(ResponseCTeEmissao.class);

            if(!response.getCodigo().equals("200")){
                ResponseMensagem erro = new ResponseMensagem.Builder()
                        .descricao(response.getMotivo())
                        .codigo(response.getCodigo())
                        .erro()
                        .build();

                throw new DocumentoValidationException("CTe não autorizado pela sefaz", erro);
            }


            cteBd.setChaveCte(response.getChaveCte());
            cteBd.setProtocolo(response.getProtocolo());
            cteBd.setXmlEnvio(xmlEnvio);

            transporte.setCte(cteBd);

            InjectionProvider.getCteReposotory().save(cteBd);
            InjectionProvider.getTransporteRepository().save(transporte);

            return ResponseFactory.emissaoCTeSucesso(cteBd.getChaveCte());

        }catch (HttpStatusCodeException e){
            ResponseMensagem erro = new ResponseMensagem.Builder()
                    .descricao("Comunicação com a sefaz retornou erro")
                    .codigo(e.getStatusCode().toString())
                    .erro()
                    .build();

            throw new ComunicationException(erro);
        }catch (RestClientException e){
            ResponseMensagem erro = new ResponseMensagem.Builder()
                    .descricao("Não foi possivel conectar com a sefaz")
                    .codigo("400")
                    .erro()
                    .build();

            throw new ComunicationException(erro);
        }
    }

    @Override
    public ResponseCTe consultar(String chave) {
        // consultar ciot -> mock, consultar situação fila rabit -> direta
        throw new NotImplementedException("Não implementado");
    }

    @Override
    public ResponseCTe cancelar(String chave, String motivo) {
        // receber json, cadastrar log de evento, mandar para rabbit {chave, motivo}
        // Rabbit: enviar para moc antt, processar resposta, atualizar dados no banco (cte Cancelado ou log de Evento {acessado pelo listener do cliente para retorno})
        throw new NotImplementedException("Não implementado");
    }

}
