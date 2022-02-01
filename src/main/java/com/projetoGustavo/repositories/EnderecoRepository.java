package com.projetoGustavo.repositories;


import com.projetoGustavo.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
//    Acessando os dados, basta somente fazer isso , Aceso a dados


}
