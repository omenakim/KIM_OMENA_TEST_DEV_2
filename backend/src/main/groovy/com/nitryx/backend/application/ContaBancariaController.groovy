package com.nitryx.backend.application

import com.nitryx.backend.model.ContaBancaria
import com.nitryx.backend.repository.ClienteRepository
import com.nitryx.backend.repository.ContaBancariaRepository
import com.nitryx.backend.service.ContaBancariaService
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = "/contas", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
class ContaBancariaController {

    @Autowired
    ContaBancariaRepository contas

    @Autowired
    ContaBancariaService criacaoDeContaService

    @Autowired
    ClienteRepository clienteRepository

    @Override
    @GetMapping
    ContaBancaria buscar(@PathVariable Long contaBancariaId) {
        ContaBancaria = contaId.buscarOuFalhar(contaId);

        return ContaBancaria = ContaBancariaRepository.findAll(contaBancariaId)


//    @GetMapping
//    ContaBancaria findAll(ContaBancariaRepository contaBancariaRepository) {
//        ContaBancaria contaBancariaId = contaBancariaRepository.findById(contaBancariaId).get()
//    }
    }
