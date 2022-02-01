package com.projetoGustavo.repositories;


import com.projetoGustavo.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
//    Acessando os dados, basta somente fazer isso , Aceso a dados


}
