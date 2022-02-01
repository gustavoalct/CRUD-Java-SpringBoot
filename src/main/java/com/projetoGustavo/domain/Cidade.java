package com.projetoGustavo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    // CIDADE POSSUI APENAS UM ESTADO nao é lista como antes, 1:n vc faz a indexacao aqui
    @JsonIgnore// cada cidade serializa um estado, desta forma o estado nao renderiza, mas a cidade busca o estado e o mostra
    @ManyToOne
    @JoinColumn(name="estado_id")  // CHAVE ESTRANGEIRA -- faz a relacao lá na tabala do banco de dados, CHA
    private  Estado estado;

    public Cidade(){
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade(Integer id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }
}
