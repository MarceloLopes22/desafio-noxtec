package com.desafio.contato.controller;

import com.desafio.contato.basicas.Contato;
import com.desafio.contato.services.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    @Autowired
    private ContatoService service;

    @PostMapping
    public ResponseEntity salvarContatos(@RequestBody Contato contato) {
        return service.salvarContato(contato);
    }

    @GetMapping(value = "/contato/{celular}")
    public ResponseEntity consultarContatos(@PathVariable("celular") String celular) {
        return service.consultarContatos(celular);
    }

    @PutMapping
    public ResponseEntity atualizarContato(@RequestBody Contato contato) {
        return service.atualizarContato(contato);
    }

    @DeleteMapping("{id}")
    public void deletarContato(@PathVariable Integer id) {
        service.deletarContato(id);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity listarContatos() {
         return service.listarContatos();
    }
}
