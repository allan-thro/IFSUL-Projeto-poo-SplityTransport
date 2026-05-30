package com.pwzt.ifsul.splitytransport.core.complextype.cte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TcIde {

    @JsonProperty("uf")
    private String cUf;

    @JsonProperty("cod_cte")
    private String cCT;

    @JsonProperty("cfop")
    private String CFOP;

    @JsonProperty("natureza_operacao")
    private String natOp;

    @JsonProperty("modelo")
    private String mod;

    @JsonProperty("serie")
    private String serie;

    @JsonProperty("numeracao_cte")
    private String nCT;

    @JsonProperty("dh_emissao")
    private String dhEmi;

    @JsonProperty("tipo_impressao")
    private String tpImp;

    @JsonProperty("tipo_emissao")
    private String tpEmis;

    @JsonProperty("tipo_ambiente")
    private String tpAmb;

    @JsonProperty("tipo_cte")
    private String tpCTe;

    @JsonProperty("aplicatico_emissor")
    private String procEmi;

    @JsonProperty("versao_sistema")
    private String verProc;

    @JsonProperty("codigo_municipio_envio")
    private String cMunEnv;

    @JsonProperty("nome_municipio_envio")
    private String xMunEnv;

    @JsonProperty("uf_envio")
    private String UFEnv;

    @JsonProperty("modal")
    private String modal;

    @JsonProperty("tipo_servico")
    private String tpServ;

    @JsonProperty("codigo_municipio_inicio")
    private String cMunIni;

    @JsonProperty("nome_municipio_inicio")
    private String xMunIni;

    @JsonProperty("uf_inicio")
    private String UFIni;

    @JsonProperty("codigo_municipio_fim")
    private String cMunFim;

    @JsonProperty("nome_municipio_fim")
    private String xMunFim;

    @JsonProperty("uf_fim")
    private String UFFim;

}
