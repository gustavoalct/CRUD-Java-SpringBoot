package com.projetoGustavo.domain.enums;

import java.util.Objects;

public enum EstadoPagamento {

    PENDENTE(1,"Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    private  EstadoPagamento(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer cod) throws IllegalAccessException {
        if(cod == null){
            return null;
        }

        for(EstadoPagamento x : EstadoPagamento.values()){
            if(cod.equals(x.getCod())){  // se o codigo for 1 retorna pessoa fisica, se 2 pessoa juridica
                return x;
            }
        }

        throw new IllegalAccessException("id Invalido" + cod);
    }
}
