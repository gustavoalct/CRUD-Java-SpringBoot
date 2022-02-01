package com.projetoGustavo.services;


import com.projetoGustavo.domain.Categoria;
import com.projetoGustavo.repositories.CategoriaRepository;
import com.projetoGustavo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired // Instancia a dependencia
    private CategoriaRepository repo; // declara a dependencia ao repositorio, repo serve para buscar no banco de dados com certo Id

    // buscar uma categoria por codigo
    public Optional<Categoria> buscar(Integer id){

        Optional<Categoria> obj = repo.findById(id);

        // verifica se o retorno é nulo

        return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id + "tipo" + Categoria.class.getName())));
    }

}
