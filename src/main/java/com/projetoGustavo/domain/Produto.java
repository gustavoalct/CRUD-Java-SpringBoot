package com.projetoGustavo.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Nome;
    private double preco;

    @JsonBackReference // outra parte do JsonReference
    // mapeamento das tabelas produtos e categoriass
    @ManyToMany // as tabelas sao muitos para muitos, ou seja, cria uma terceira tabela que liga
    @JoinTable(name="PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name="produto_id"),
             inverseJoinColumns = @JoinColumn(name="categoria_id")
    ) // tabela que faz as relacoes

    // ligando categoria com produto
    private List<Categoria> categorias = new ArrayList<>();


    // Associacao inversa
    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    // A classe tem que ter o construtor vazio
    public Produto(){
    }

    // Colocar todos menos oq eu for colecao, ou seja categoria, pois já foi criado em outro lugar


    public Produto(Integer id, String nome, double preco) {
        this.id = id;
        Nome = nome;
        this.preco = preco;
    }

    // associando uma lista de itens em pedido
    @JsonIgnore
    public List<Pedido> pedidos(){
        List<Pedido> lista = new ArrayList<>();
        // vou percorrer todos os pedidos, para cada produto x de um item , vou adicionar a uma lista seprara
        for(ItemPedido x : itens){
            lista.add(x.getPedido());
        }
        return lista;
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

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    // hash code e equals pelo id

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
