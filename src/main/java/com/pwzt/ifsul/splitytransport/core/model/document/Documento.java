package com.pwzt.ifsul.splitytransport.core.model.document;

import com.pwzt.ifsul.splitytransport.core.model.states.DocStatus;
import com.pwzt.ifsul.splitytransport.core.model.converter.DocStatusConverter;
import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data

public class Documento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOC_ID")
    private Long id;

    @Convert(converter = DocStatusConverter.class)
    @Column(name = "DOC_STATUS")
    private DocStatus status;

    @Column(name = "DOC_XML", length = 5000)
    private String xmlEnvio;

    @Column(name = "DOC_CHAVE")
    private String chave;

}
