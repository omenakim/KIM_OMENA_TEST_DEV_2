package com.nitryx.backend.service

import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.nitryx.backend.model.ContaBancaria
import com.nitryx.backend.repository.ClienteRepository
import com.nitryx.backend.repository.ContaBancariaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContaBancariaService extends ContaBancaria {

    @Autowired
    ContaBancariaRepository contaBancariaRepository

    void transferir(Long contaOrigemId, Long contaDestinoId, BigDecimal valor) {
        ContaBancaria contaOrigem = contaBancariaRepository.findById(contaOrigemId).get()
        ContaBancaria contaDestino = contaBancariaRepository.findById(contaDestinoId).get()

        contaOrigem.debitar(valor)
        contaDestino.creditar(valor)

        contaBancariaRepository.save(contaOrigem)
        contaBancariaRepository.save(contaDestino)

    }
}
