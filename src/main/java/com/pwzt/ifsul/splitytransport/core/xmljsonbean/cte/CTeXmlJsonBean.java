package com.pwzt.ifsul.splitytransport.core.xmljsonbean.cte;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pwzt.ifsul.splitytransport.core.complextype.cte.TcCTE;
import com.pwzt.ifsul.splitytransport.core.model.document.CTe;
import com.pwzt.ifsul.splitytransport.core.xmljsonbean.XmlJsonBean;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Data

public class CTeXmlJsonBean implements XmlJsonBean<TcCTE, CTe> {

    @Override
    public void updateDocumentAndTc(TcCTE tcCte, CTe cte) {
        CTeMapper.updateDocuments(tcCte, cte);
    }

    @Override
    public String tcToJsonConverter(TcCTE tcInf) {
        return "";
    }

    @Override
    public String tcToXmlConverter(TcCTE tcCte) {
        return CTeXmlMapper.convertCteToXml(tcCte);
    }

}
