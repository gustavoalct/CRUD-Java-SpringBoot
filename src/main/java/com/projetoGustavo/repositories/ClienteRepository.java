package com.projetoGustavo.repositories;


import com.projetoGustavo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
//    Acessando os dados, basta somente fazer isso , Aceso a dados


}
