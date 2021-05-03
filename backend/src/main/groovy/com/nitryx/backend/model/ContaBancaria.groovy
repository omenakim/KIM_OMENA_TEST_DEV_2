package com.nitryx.backend.model

import com.nitryx.backend.repository.ContaBancariaRepository

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String numeroAgencia
    String numeroConta
    BigDecimal saldo

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    Cliente cliente

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_bancaria_id")
    List<TransacaoBancaria> transacoes

    ContaBancaria(String numeroAgencia, String numeroConta, Cliente cliente) {
        this.numeroAgencia = numeroAgencia
        this.numeroConta = numeroConta
        this.cliente = cliente
        this.saldo = 0.0
        this.transacoes = new ArrayList<>()
    }

    void debitar(BigDecimal valor) {
        if (valor > this.saldo)
            throw new RuntimeException("Saldo não pode ser negativo")
        this.saldo = this.saldo - valor
        this.transacoes.add(new TransacaoBancaria(valor * -1))

    }

    void creditar(BigDecimal valor) {
        this.saldo = this.saldo + valor
        this.transacoes.add(new TransacaoBancaria(valor))
    }

    ContaBancaria() {}

}
