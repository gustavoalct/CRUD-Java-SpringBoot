package com.projetoGustavo.repositories;


import com.projetoGustavo.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
//    Acessando os dados, basta somente fazer isso , Aceso a dados


}
