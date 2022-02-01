package com.projetoGustavo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetoGustavo.domain.enums.EstadoPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)  // para mapeamento de heranca  , há duas strategia tabelao (unica tabela) ou gerar uma tabela para cada uma, tabela com muitos elementos divide com pouco tabelao
// joined é tabelao
public abstract class Pagamento  implements Serializable { // o abstract nao deixa instanciar pagamento direto, ou seja, tem q instanciar com cartao ou boleto

    @Id
    private Integer id; // id do pagamento tem que ser o mesmo do pedido
    private Integer estado;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId // garante o mesmo id
    // associacao entre pagamento e pedido
    private Pedido pedido;


    // MAPEAMENTO DE HERANÇA

     public Pagamento (){

     }

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado.getCod();
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstado() throws IllegalAccessException {
        return EstadoPagamento.toEnum(estado);
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado.getCod();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagamento)) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
