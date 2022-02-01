package com.projetoGustavo.repositories;


import com.projetoGustavo.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
//    Acessando os dados, basta somente fazer isso , Aceso a dados


}
