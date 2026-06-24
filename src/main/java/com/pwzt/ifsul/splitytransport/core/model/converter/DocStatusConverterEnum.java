package com.pwzt.ifsul.splitytransport.core.model.converter;

import com.pwzt.ifsul.splitytransport.core.model.enumerator.DocStatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class DocStatusConverterEnum implements AttributeConverter<DocStatusEnum, String>{
    @Override
    public String convertToDatabaseColumn(DocStatusEnum attribute) {
        return "";
    }

    @Override
    public DocStatusEnum convertToEntityAttribute(String dbData) {
        return null;
    }
}
