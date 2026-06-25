package com.pwzt.ifsul.splitytransport.core.model.document;

import com.pwzt.ifsul.splitytransport.core.model.converter.DocStatusConverterEnum;
import com.pwzt.ifsul.splitytransport.core.model.enumerator.DocStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data

public class Documento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOC_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOC_STATUS")
    private DocStatusEnum status;

    @Column(name = "DOC_XML", length = 5000)
    private String xmlEnvio;

    @Column(name = "DOC_CHAVE")
    private String chave;

}
