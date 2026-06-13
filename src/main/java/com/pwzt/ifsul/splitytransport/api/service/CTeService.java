package com.pwzt.ifsul.splitytransport.api.service;

import com.pwzt.ifsul.splitytransport.api.dto.base.CTeRabbitMessage;
import com.pwzt.ifsul.splitytransport.core.factory.ResponseFactory;
import com.pwzt.ifsul.splitytransport.api.dto.response.cte.ResponseCTe;
import com.pwzt.ifsul.splitytransport.api.repository.InjectionProvider;
import com.pwzt.ifsul.splitytransport.core.complextype.cte.TcCTE;
import com.pwzt.ifsul.splitytransport.core.exception.DocumentoValidationException;
import com.pwzt.ifsul.splitytransport.core.model.base.Transporte;
import com.pwzt.ifsul.splitytransport.core.model.document.CTe;
import com.pwzt.ifsul.splitytransport.core.model.enumerator.TipoDocumento;
import com.pwzt.ifsul.splitytransport.core.xmljsonbean.XmlJsonBean;
import com.pwzt.ifsul.splitytransport.core.xmljsonbean.XmlJsonBeanResolver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CTeService implements DocumentoService<TcCTE, ResponseCTe>{

    @Value("${rabbit.cte.queue}")
    private String CTE_QUEUE_NAME;

    @Autowired
    private RabbitTemplate rabbitTemplate;

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

        String xmlEnvio = xmlJsonBean.tcToXmlConverter(tcCte);
        cteBd.setXmlEnvio(xmlEnvio);

        InjectionProvider.getCteReposotory().save(cteBd);
        CTeRabbitMessage mensagem = new CTeRabbitMessage(xmlEnvio, cteBd.getChave(), transportId);

        rabbitTemplate.convertAndSend(CTE_QUEUE_NAME, mensagem);

        return ResponseFactory.emissaoCTeSucesso(cteBd.getChaveCte());

        // service: chamar state para atualizar cte do transporte -> parser tcToCte, atualizar banco e status para pendente
        // service: gerar xml e mandar mensagem para rabbit {xml, chave, transportId}

        // Rabbit: enviar para mock antt, processar resposta, atualizar dados no banco,  {setar status cte para aprovado/rejeitado}

        // service: retorna chave cte para consultar situação fila

    }

    @Override
    public ResponseCTe consultar(String chave) {
        // consultar ciot -> mock, consultar situação fila rabit -> direta

        return null;
    }

    @Override
    public ResponseCTe cancelar(String chave, String motivo) {

        // receber json, cadastrar log de evento, mandar para rabbit {chave, motivo}
        // Rabbit: enviar para moc antt, processar resposta, atualizar dados no banco (cte Cancelado ou log de Evento {acessado pelo listener do cliente para retorno})


        return null;
    }
}
