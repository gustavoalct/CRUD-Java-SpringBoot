package com.projetoGustavo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm") // formatando a data que tava em milisegundo para tempo correto
    private Date instante;

    // Criando associacoes entre pedido e pagamento
    @JsonIgnore
    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "pedido") // é necessario por causa de erro transiente -- peculiaridade do JPA
    private Pagamento pagamento;


    // associacao pedido e cliente
    @JsonManagedReference // trata o end point, para que puxe os dados so de um lado
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // associacao pedido e endereco  -- associaco é direcionada o endereco nao tem que saber do pedido
    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id") // chave estrangeira
    private Endereco enderecoDeEntrega;

    // set faz que o java nao possibilita pegar itens repetidos
    @OneToMany(mappedBy = "id.pedido")
     private Set<ItemPedido> itens = new HashSet<>();

    // constructor
    public Pedido () {

    }

    // constructor com argumentos

    public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
        this.id = id;
        this.instante = instante;

        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }
    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
