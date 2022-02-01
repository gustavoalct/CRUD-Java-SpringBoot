package com.projetoGustavo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projetoGustavo.domain.enums.TipoCliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nome;
    private String email;
    private String cpfOUcnpj;
    // private TipoCliente tipo;  // isso é relacionado ao arquivos enuns  jeito antigo
    private Integer tipo; // macete para armazenar um integer no tipo cliente


    // cliente tem varios endereco n:1
    @JsonIgnore// SERIALIZA a referencia ciclica, REFERENCIA AQUI COM ENDERECOS
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    // olhar no PDF, telefones entidade totalmente dependente de clientes, ou seja, uma entidade fraca
    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();


    // mapea os pedidos
    @JsonBackReference // toda vez que pedir pedido, o cliente vai mandar
    @OneToMany(mappedBy = "cliente")
    // associacao entre pedido e cliente -- criando uma lista de pedidos
    private List<Pedido> pedidos = new ArrayList<>();  // lista nao coloca no constructor

    public Cliente(){
    }

    // NAO COLOQUE LIST NO CONSTRUCTOR
    public Cliente(Integer id, String nome, String email, String cpfOUcnpj, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOUcnpj = cpfOUcnpj;
        this.tipo = tipo.getCod();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOUcnpj() {
        return cpfOUcnpj;
    }

    public void setCpfOUcnpj(String cpfOUcnpj) {
        this.cpfOUcnpj = cpfOUcnpj;
    }

    public TipoCliente getTipo() throws IllegalAccessException {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
