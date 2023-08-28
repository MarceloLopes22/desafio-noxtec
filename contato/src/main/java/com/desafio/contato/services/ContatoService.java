package com.desafio.contato.services;

import com.desafio.contato.basicas.Contato;
import com.desafio.contato.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public ResponseEntity salvarContato(Contato contato) {
        Contato contatoResponse = repository.findByCelular(contato.getCelular());

        if (contatoResponse != null) {
            throw new RuntimeException("Contato já cadastrado.");
        }
        contato.setDataHora(LocalDateTime.now());
        contato = repository.save(contato);

        return new ResponseEntity(contato, HttpStatus.CREATED);
    }

    public ResponseEntity consultarContatos(String celular) {
        Contato contato = repository.findByCelular(celular);
        return new ResponseEntity(contato, HttpStatus.OK);
    }

    public ResponseEntity atualizarContato(Contato contato) {
        Optional<Contato> contatoResponse = repository.findById(contato.getId());
        Contato contatoConsultado = null;
        if (contatoResponse.isPresent()) {
            contatoConsultado = contatoResponse.get();
            contatoConsultado = contato;
        }

        contatoConsultado = repository.save(contatoConsultado);

        return new ResponseEntity(contatoConsultado, HttpStatus.OK);
    }

    public void deletarContato(Integer id) {
        Optional<Contato> contatoResponse = repository.findById(id);
        if (contatoResponse.isPresent()) {
            repository.deleteById(id);
        }
    }

    public ResponseEntity listarContatos() {
        List<Contato> all = repository.findAll();
        return new ResponseEntity(all, HttpStatus.OK);
    }
}
