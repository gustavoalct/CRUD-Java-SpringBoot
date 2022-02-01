package com.projetoGustavo.repositories;


import com.projetoGustavo.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
//    Acessando os dados, basta somente fazer isso , Aceso a dados


}
