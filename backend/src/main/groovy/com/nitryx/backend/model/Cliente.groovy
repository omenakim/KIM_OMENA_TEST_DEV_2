package com.nitryx.backend.model

import groovy.transform.CompileStatic

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@CompileStatic
class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String cpf
    String nome

    Cliente(String cpf, String nome) {
        this.cpf = cpf
        this.nome = nome
    }

    Cliente() {}
}
