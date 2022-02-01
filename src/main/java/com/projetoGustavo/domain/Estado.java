package com.projetoGustavo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Estado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    // estado possui uma lista de cidades 1:n IMPORTANDO CIDADES - Relacionamento reverso
    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>(); // list pq é um array de cidades

    // Criando construtor vazio é padrao pois serve para corrigir problema
    public Estado(){
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

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado)) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Estado(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
        // NAO COLOCAR O LIST NO CONSTRUTOR
    }
}