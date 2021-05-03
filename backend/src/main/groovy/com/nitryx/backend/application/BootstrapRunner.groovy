package com.nitryx.backend.application

import com.nitryx.backend.model.Cliente
import com.nitryx.backend.model.ContaBancaria
import com.nitryx.backend.repository.ContaBancariaRepository
import com.nitryx.backend.service.ContaBancariaService
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@CompileStatic
@Component
@Slf4j
class BootstrapRunner implements ApplicationRunner {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository

    @Autowired
    private ContaBancariaService contaBancariaService

    @Transactional
    @Override
    void run(ApplicationArguments args) throws Exception {

        Cliente cliente1 = new Cliente("83151006027", "João")
        ContaBancaria conta1 = new ContaBancaria("001", "123456", cliente1)

        log.info("Conta do cliente {} criada com sucesso, saldo {}", cliente1.getNome(), conta1.getSaldo())

        Cliente cliente2 = new Cliente("27400952013", "Maria")
        ContaBancaria conta2 = new ContaBancaria("002", "654321", cliente2)

        log.info("Conta do cliente {} criada com sucesso, saldo {}", cliente2.getNome(), conta2.getSaldo())

        conta1.creditar(100.0)
        log.info("Saldo da conta de {} é igual a {}", conta1.cliente.nome, conta1.saldo)

        conta2.creditar(200.0)
        log.info("Saldo da conta de {} é igual a {}", conta2.cliente.nome, conta2.saldo)

        conta2.debitar(50.0)
        log.info("Saldo da conta de {} é igual a {}", conta2.cliente.nome, conta2.saldo)

        contaBancariaRepository.save(conta1)
        contaBancariaRepository.save(conta2)

        contaBancariaService.transferir(conta1.id, conta2.id, 30.0)

        log.info("Saldo da conta de {} é igual a {}", conta1.cliente.nome, conta1.saldo)
        log.info("Saldo da conta de {} é igual a {}", conta2.cliente.nome, conta2.saldo)

    }

}



