package com.projetoGustavo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// classe da categoria -- aqui onde define a classe, oq tem nela

@Entity //informa que uma classe é uma entidade
public class Categoria implements Serializable {
    //serializable os objetos dela poderao ser convertidos em sequencia de bites
    // isso serve para que os objetos podem ser salvos em arquivos, trafegar em rede etc, EXIGENCIA DO JAVA

    // atributos basicos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Definindo a geracao automatica do banco de dados  para o banco h2
    private Integer id;
    private String nome;

    //@JsonManagedReference // referencia gerenciada pelo json, faz isso onde vc quer q venha os objetos associados
    // @JsonIgnore// ligando tabelas
    @ManyToMany(mappedBy = "categorias")// Instanciando o produto, que sera ligado posteriormente, ou seja importando os dados
    private List<Produto> produtos = new ArrayList<>();

    // construtor vazio --> instancio o objeto sem jogar nada para os atributos
    public Categoria(){

    }

    // construtor com os atributos, para povoar os atributos
    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters --> metodos de acesso aos atributos -- get pega informacao set altera informacao
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

    // Get e setter no produto
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    // hash code equals -- operacoes para comparar com o valor

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) && Objects.equals(nome, categoria.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }


}

