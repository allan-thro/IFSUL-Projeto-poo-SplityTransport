package com.pwzt.ifsul.splitytransport.core.model.enumerator;

import com.pwzt.ifsul.splitytransport.core.model.document.CTe;
import com.pwzt.ifsul.splitytransport.core.model.document.Documento;
import com.pwzt.ifsul.splitytransport.core.xmljsonbean.XmlJsonBean;
import com.pwzt.ifsul.splitytransport.core.xmljsonbean.cte.CTeMapper;
import com.pwzt.ifsul.splitytransport.core.xmljsonbean.cte.CTeXmlJsonBean;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum TipoDocumento {

    CTE("cte", CTeXmlJsonBean.class),
    CIOT("ciot", CTeXmlJsonBean.class),
    MDFE("mdfe", CTeXmlJsonBean.class);

    private final String path;
    private final Class<? extends XmlJsonBean> xmlJsonBeanClass;

    public static TipoDocumento fromPath(String path) {
        for(TipoDocumento dtc : TipoDocumento.values()) {
            if(dtc.path.equalsIgnoreCase(path)) return dtc;
        }

        throw new IllegalArgumentException("Tipo do documento inválido");
    }

}


