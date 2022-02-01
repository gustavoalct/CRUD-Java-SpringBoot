package com.projetoGustavo.repositories;


import com.projetoGustavo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
//    Acessando os dados, basta somente fazer isso , Aceso a dados


}
