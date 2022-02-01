package com.projetoGustavo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ItemPedido implements Serializable {
    @JsonIgnore // nao sera serializa
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();  // atributo composto

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido () {

    }

    // os ids tem que associar das tabelas pedido e produto
    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // fazendo get de pedido e produto
    @JsonIgnore  //evita redundancias na saida do codigo,
    public  Pedido getPedido(){
        return id.getPedido();
    }


    public Produto getProduto () {
        return id.getProduto();
    }



    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
