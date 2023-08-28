package com.desafio.contato.repository;

import com.desafio.contato.basicas.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
    Contato findByCelular(String celular);
}
