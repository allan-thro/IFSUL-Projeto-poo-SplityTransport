package com.pwzt.ifsul.splitytransport.core.model.document;

import com.pwzt.ifsul.splitytransport.core.model.states.DocStatus;
import com.pwzt.ifsul.splitytransport.core.model.states.DocStatusConverter;
import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "DOC_BASE")
@Entity

public class Documento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOC_ID")
    private Long id;

    @Convert(converter = DocStatusConverter.class)
    @Column(name = "DOC_STATUS")
    private DocStatus status;

    @Column(name = "DOC_XML64")
    private String xmlCompactado;

    @Column(name = "DOC_CHAVE")
    private String chave;

}
