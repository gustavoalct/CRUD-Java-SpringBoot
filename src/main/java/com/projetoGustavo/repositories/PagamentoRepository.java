package com.projetoGustavo.repositories;


import com.projetoGustavo.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
//    Acessando os dados, basta somente fazer isso , Aceso a dados

    // NAO PRECISA CRIAR REPOSITORY DAS SUBCLASSES, A SUPERCLASSE JA ATENDE TODAS
}
