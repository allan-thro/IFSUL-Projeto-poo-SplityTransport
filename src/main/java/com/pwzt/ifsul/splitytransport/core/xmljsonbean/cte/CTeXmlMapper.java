package com.pwzt.ifsul.splitytransport.core.xmljsonbean.cte;

import com.pwzt.ifsul.splitytransport.core.complextype.cte.TcCTE;
import com.pwzt.ifsul.splitytransport.core.exception.DocumentoValidationException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.StringWriter;

@Component
@Data

public class CTeXmlMapper {

    public static String convertCteToXml(TcCTE cte){
        try{
            JAXBContext context = JAXBContext.newInstance(
                    new Class<?>[]{ cte.getClass() },
                    java.util.Collections.emptyMap()
            );
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            StringWriter writer = new StringWriter();

            marshaller.marshal(cte, writer);

            return writer.toString();
        } catch (JAXBException e) {
            throw new DocumentoValidationException("Não foi possivel realizar o parse do CTe para xml, chegar dados inválidos: " + e.getCause().getMessage());
        }
    }

}
