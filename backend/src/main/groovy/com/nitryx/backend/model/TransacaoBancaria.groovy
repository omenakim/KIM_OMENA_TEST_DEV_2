package com.nitryx.backend.model

import groovy.transform.CompileStatic

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.LocalDateTime

@Entity
@CompileStatic
class TransacaoBancaria  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    LocalDateTime dataHora
    BigDecimal valor

    TransacaoBancaria(BigDecimal valor) {
        this.dataHora = LocalDateTime.now()
        this.valor = valor
    }

    TransacaoBancaria(){}

}