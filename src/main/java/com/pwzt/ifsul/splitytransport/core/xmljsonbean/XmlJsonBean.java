package com.pwzt.ifsul.splitytransport.core.xmljsonbean;

import com.pwzt.ifsul.splitytransport.core.model.document.Documento;

public interface XmlJsonBean<T, R extends Documento> {

    void updateDocumentAndTc(T tcDoc, R doc);
    String tcToJsonConverter(T tcDoc);
    String tcToXmlConverter(T tcDoc);

}
