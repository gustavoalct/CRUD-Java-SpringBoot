package com.projetoGustavo.DTO;

import com.projetoGustavo.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "Campo obrigatorio")
    @Length(min = 3, max =80, message="Tamanho Errado")
    private String nome;

    public  CategoriaDTO(){
    }

    // convertendo valores do categoria para categoriaDTO
    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        nome = obj.getNome();

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
        nome = nome;
    }
}
