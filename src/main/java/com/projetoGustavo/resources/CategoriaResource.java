package com.projetoGustavo.resources;

import com.projetoGustavo.domain.Categoria;
import com.projetoGustavo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RequestMapping(value="/categorias") // endereca o end point do serviço
@RestController // controlador  Anotacao --> ctrl + shift + o Atalho de importacao

// aqui é o controler da operacao
public class CategoriaResource {

    // Pegando a categoria service
    @Autowired
    private CategoriaService service; // chama o service

    @RequestMapping(value="/{id}",method=RequestMethod.GET) //id entra apos categorias, busca o elemento
    public ResponseEntity<?> find(@PathVariable Integer id){ // muda o nome do metodo para find, pathVariable taca o valor para method request acima
        Optional<Categoria> obj = service.buscar(id);

        return ResponseEntity.ok().body(obj); // retorna somente caso de certo
    }
}






