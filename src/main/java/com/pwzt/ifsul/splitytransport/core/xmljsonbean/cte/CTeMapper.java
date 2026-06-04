package com.pwzt.ifsul.splitytransport.core.xmljsonbean.cte;

import com.pwzt.ifsul.splitytransport.api.repository.InjectionProvider;
import com.pwzt.ifsul.splitytransport.api.repository.TransporteRepository;
import com.pwzt.ifsul.splitytransport.core.complextype.cte.*;
import com.pwzt.ifsul.splitytransport.core.exception.DocumentoValidationException;
import com.pwzt.ifsul.splitytransport.core.model.base.Cliente;
import com.pwzt.ifsul.splitytransport.core.model.document.CTe;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@Data

public class CTeMapper {

    public static void updateDocuments(TcCTE cte, CTe _returnValue){

        if(cte == null) throw new DocumentoValidationException("Dados de informação do cte nulos");

        _returnValue.setChaveCte(geradorChaveCTe(cte.getInfCTE()));
        _returnValue.setChave(_returnValue.getChaveCte());

        _returnValue.setChaveNfe(cte.getInfCTE().getTcInfCTeNorm().getTcInfDoc().getTcInfNfe().getChave());
        _returnValue.setCodigoOperacao(cte.getInfCTE().getTcIde().getCFOP());
        _returnValue.setDataHoraEmissao(LocalDateTime.parse(cte.getInfCTE().getTcIde().getDhEmi()));

        _returnValue.setMunicipioOrigem(cte.getInfCTE().getTcIde().getXMunIni());
        _returnValue.setMunicipioDestino(cte.getInfCTE().getTcIde().getCMunFim());
        _returnValue.setMunicipioEmissor(cte.getInfCTE().getTcIde().getXMunEnv());

        _returnValue.setValorLiquido(new BigDecimal(cte.getInfCTE().getTcVPrest().getVRec()));
        _returnValue.setValorMercadoria(new BigDecimal(cte.getInfCTE().getTcInfCTeNorm().getTcInfCarga().getVCarga()));

        _returnValue.setDestinatario(createDestinatario(cte.getInfCTE().getTcDest()));
        _returnValue.setEmitente(createEmitente(cte.getInfCTE().getTcEmit()));
        _returnValue.setRemetente(createRemetente(cte.getInfCTE().getTcRem()));

        cte.getInfCTE().setId("CTe" + _returnValue.getChaveCte());
    }

    private static Cliente createDestinatario(TcDest dest){
        Cliente _returnValue = InjectionProvider.getClienteRepository().findByCpfCnpj(dest.getCNPJ()).orElse(null);
        if(_returnValue != null) return _returnValue;

        _returnValue = new Cliente();

        _returnValue.setCpfCnpj(dest.getCNPJ());
        _returnValue.setInscricaoEstadual(dest.getXNome());

        return _returnValue;
    }

    private static Cliente createEmitente(TcEmit emit){
        Cliente _returnValue = InjectionProvider.getClienteRepository().findByCpfCnpj(emit.getCNPJ()).orElse(null);
        if(_returnValue != null) return _returnValue;

        _returnValue = new Cliente();

        _returnValue.setCpfCnpj(emit.getCNPJ());
        _returnValue.setRazaoSocial(emit.getXNome());
        _returnValue.setInscricaoEstadual(emit.getIE());

        return _returnValue;
    }

    private static Cliente createRemetente(TcRem rem){
        Cliente _returnValue = InjectionProvider.getClienteRepository().findByCpfCnpj(rem.getCNPJ()).orElse(null);
        if(_returnValue != null) return _returnValue;

        _returnValue = new Cliente();

        _returnValue.setCpfCnpj(rem.getCNPJ());
        _returnValue.setRazaoSocial(rem.getXNome());
        _returnValue.setInscricaoEstadual(rem.getIE());

        return _returnValue;
    }

    private static String geradorChaveCTe(TcInfCTE infCte){
        String chave = "";

        chave.concat(infCte.getTcIde().getCUf());
        chave.concat(infCte.getTcIde().getDhEmi().substring(2, 3));
        chave.concat(infCte.getTcIde().getDhEmi().substring(5, 6));
        chave.concat(infCte.getTcEmit().getCNPJ());
        chave.concat(infCte.getTcIde().getMod());
        chave.concat(infCte.getTcIde().getSerie());
        chave.concat(infCte.getTcIde().getCCT());
        chave.concat(infCte.getTcInfCTeNorm().getTcInfDoc().getTcInfNfe().getChave().substring(0, 8));
        chave.concat("7");

        return chave;
    }

}
