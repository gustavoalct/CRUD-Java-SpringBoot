package com.projetoGustavo.domain;

import com.projetoGustavo.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;

// Classe que é uma extensao de pagamento, por isso o extends, ou seja, ela vai ter tudo oq o pagamento tem
@Entity
public class PagamentoBoleto extends Pagamento{

    private Date dataVencimento;
    private Date dataPagamento;


    public PagamentoBoleto (){

    }

    public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    // nao precisa de equals hash code --> pois como sendo uma classe extends nao necessita
}
