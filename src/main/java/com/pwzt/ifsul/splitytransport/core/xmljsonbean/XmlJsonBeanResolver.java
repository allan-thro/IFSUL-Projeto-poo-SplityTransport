package com.pwzt.ifsul.splitytransport.core.xmljsonbean;

import com.pwzt.ifsul.splitytransport.core.model.document.Documento;
import com.pwzt.ifsul.splitytransport.core.model.enumerator.TipoDocumento;
import com.pwzt.ifsul.splitytransport.core.xmljsonbean.cte.CTeXmlJsonBean;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class XmlJsonBeanResolver {

    private final ApplicationContext context;

    @SuppressWarnings("unchecked")
    public <T, R extends Documento> XmlJsonBean<T, R> resolve(TipoDocumento tipo) {
        return (XmlJsonBean<T, R>) context.getBean(tipo.getXmlJsonBeanClass());
    }

}
