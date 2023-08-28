package com.desafio.contato.basicas;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contato_id")
    private Integer id;
    @Column(name = "contato_nome")
    private String nome;
    @Column(name = "contato_email")
    private String email;
    @Column(name = "contato_celular")
    private String celular;
    @Column(name = "contato_telefone")
    private String telefone;
    @Column(name = "contato_sn_favorito")
    private Boolean favorito;
    @Column(name = "contato_sn_ativo")
    private Boolean ativo;
    @Column(name = "contato_dh_cad")
    private LocalDateTime dataHora;
}
