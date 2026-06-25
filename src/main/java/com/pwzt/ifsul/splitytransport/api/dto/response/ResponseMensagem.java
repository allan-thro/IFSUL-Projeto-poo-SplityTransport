package com.pwzt.ifsul.splitytransport.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data

public class ResponseMensagem {

    private String descricao;
    private String tipo;
    private String codigo;

    private ResponseMensagem(Builder builder){
        this.descricao = builder.descricao;
        this.tipo = builder.tipo;
        this.codigo = builder.codigo;
    }

    public static class Builder {
        private String descricao;
        private String tipo;
        private String codigo;

        public Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder erro() {
            this.tipo = "ERRO";
            return this;
        }

        public Builder sucesso(){
            this.tipo = "SUCESSO";
            return this;
        }

        public Builder tipoResolver(String status){
            if(List.of("200", "201", "204", "100", "101").contains(status)){
                this.tipo = "SUCESSO";
            }
            else this.tipo = "ERRO";

            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public ResponseMensagem build() {
            return new ResponseMensagem(this);
        }
    }

    @JsonIgnore
    public boolean isSucesso(){
        return tipo.equals("SUCESSO");
    }

    @JsonIgnore
    public boolean isErro(){
        return tipo.equals("ERRO");
    }

}
