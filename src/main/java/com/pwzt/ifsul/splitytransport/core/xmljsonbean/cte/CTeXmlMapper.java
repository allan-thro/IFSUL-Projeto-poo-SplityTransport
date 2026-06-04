package com.pwzt.ifsul.splitytransport.core.xmljsonbean.cte;

import com.pwzt.ifsul.splitytransport.core.complextype.cte.TcCTE;
import com.pwzt.ifsul.splitytransport.core.exception.DocumentoValidationException;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Component
@Data

public class CTeXmlMapper {

    public static String convertCteToXml(TcCTE cte){
        try{
            JAXBContext context = JAXBContext.newInstance(TcCTE.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            StringWriter writer = new StringWriter();

            marshaller.marshal(cte, writer);

            return writer.toString();
        } catch (JAXBException e) {
            throw new DocumentoValidationException("Não foi possivel realizar o parse do CTe para xml, chegar dados inválidos");
        }
    }

}
