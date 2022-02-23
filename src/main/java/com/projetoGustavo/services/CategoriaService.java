package com.projetoGustavo.services;


import com.projetoGustavo.DTO.CategoriaDTO;
import com.projetoGustavo.domain.Categoria;
import com.projetoGustavo.repositories.CategoriaRepository;
import com.projetoGustavo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.CachedExpressionEvaluator;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired // Instancia a dependencia
    private CategoriaRepository repo; // declara a dependencia ao repositorio, repo serve para buscar no banco de dados com certo Id

    // buscar uma categoria por codigo
    public Optional<Categoria> find(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        // verifica se o retorno é nulo

        return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id + "tipo" + Categoria.class.getName())));
    }

    public Categoria insert (Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update (Categoria obj){
        find(obj.getId()); // verifica se ha um id para update do valor, se nao houver ele nem retorna  a linha abaixo
        return repo.save(obj);
    }

    public void delete(Integer id){
        find(id);
        try{
            repo.deleteById(id); // Tenta excluir, caso há um valor referenciado no outro nao delatar e mostrar mensagem de exceção
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possível excluir uma categoria que possui produtos.");
        }
    }

    public List<Categoria> findAll(){
        return repo.findAll();
    }

    // paginacao por categoria
    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){  // linhas por pagina, orderBy ordenacao dos atributos, direction descendende ou ascendente
        PageRequest pageRequest = PageRequest.of(page,linesPerPage,   Sort.Direction.valueOf(direction) , orderBy);
        return repo.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDTO objDTO ){
        return new Categoria(objDTO.getId(), objDTO.getNome());
    }

}
