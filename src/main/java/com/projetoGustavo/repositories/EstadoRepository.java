package com.projetoGustavo.repositories;


import com.projetoGustavo.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
//    Acessando os dados, basta somente fazer isso , Aceso a dados


}
