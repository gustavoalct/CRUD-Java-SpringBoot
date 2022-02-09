package com.projetoGustavo.services;


import com.projetoGustavo.domain.Cliente;
import com.projetoGustavo.repositories.ClienteRepository;
import com.projetoGustavo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired // Instancia a dependencia
    private ClienteRepository repo; // declara a dependencia ao repositorio, repo serve para buscar no banco de dados com certo Id

    // buscar uma categoria por codigo
    public Optional<Cliente> find(Integer id){

        Optional<Cliente> obj = repo.findById(id);

        // verifica se o retorno é nulo

        return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id + "tipo" + Cliente.class.getName())));
    }

}
