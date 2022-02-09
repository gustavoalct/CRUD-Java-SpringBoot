package com.projetoGustavo.resources;

import com.projetoGustavo.DTO.CategoriaDTO;
import com.projetoGustavo.domain.Categoria;
import com.projetoGustavo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequestMapping(value="/categorias") // endereca o end point do serviço
@RestController // controlador  Anotacao --> ctrl + shift + o Atalho de importacao

// aqui é o controler da operacao
public class CategoriaResource {

    // Pegando a categoria service
    @Autowired
    private CategoriaService service; // chama o service

    @RequestMapping(value="/{id}",method=RequestMethod.GET) //id entra apos categorias, busca o elemento
    public ResponseEntity<?> find(@PathVariable Integer id){ // muda o nome do metodo para find, pathVariable taca o valor para method request acima
        Optional<Categoria> obj = service.find(id);
        return ResponseEntity.ok().body(obj); // retorna somente caso de certo
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Categoria obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }

    // Listando tudo
    @RequestMapping(method=RequestMethod.GET) //id entra apos categorias, busca o elemento
    public ResponseEntity<List<CategoriaDTO>> findAll(){ // muda o nome do metodo para find, pathVariable taca o valor para method request acima
        List<Categoria> list = service.findAll();
        // converte uma lista para outra lista
        List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto); // retorna somente caso de certo
    }


    // exemplo requisicao http:/localhost:8000/categorias/page?linesPerPage=38&page=1&direction=DESC
    @RequestMapping(value = "/page" , method=RequestMethod.GET) //id entra apos categorias, busca o elemento
    public ResponseEntity<Page<CategoriaDTO>> findPage( // muda o nome do metodo para find, pathVariable taca o valor para method request acima
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "nome")String orderBy,
            @RequestParam(value="direction", defaultValue = "ASC") String direction){

        Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
        // converte uma lista para outra lista
        Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
        return ResponseEntity.ok().body(listDto); // retorna somente caso de certo'
    }

}







