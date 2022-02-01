package com.projetoGustavo.domain;

import com.projetoGustavo.domain.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento{

    private Integer numeroDeParcelas;

    public PagamentoCartao(){

    }

    public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    // nao precisa de equals hash code --> pois como sendo uma classe extends nao necessita
}
