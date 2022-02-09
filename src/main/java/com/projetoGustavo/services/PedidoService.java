package com.projetoGustavo.services;

import com.projetoGustavo.domain.Pedido;
import com.projetoGustavo.repositories.PedidoRepository;
import com.projetoGustavo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// procura no banco de dados
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Optional<Pedido> find(Integer id){
        Optional<Pedido> obj = repo.findById(id);

        return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id + "tipo" + Pedido.class.getName())));
    }

}
