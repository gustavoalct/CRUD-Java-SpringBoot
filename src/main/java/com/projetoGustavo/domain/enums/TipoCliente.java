package com.projetoGustavo.domain.enums;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa fisica"),
    PESSOAJURIDICA(2, "Pessoa juridica");

    private int cod;
    private String descricao;

    private  TipoCliente(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer cod) throws IllegalAccessException {
        if(cod == null){
            return null;
        }

        for(TipoCliente x : TipoCliente.values()){
            if(cod.equals(x.getCod())){  // se o codigo for 1 retorna pessoa fisica, se 2 pessoa juridica
                return x;
            }
        }

        throw new IllegalAccessException("id Invalido" + cod);
    }
}
