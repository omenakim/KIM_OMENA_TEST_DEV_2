package com.nitryx.backend.repository

import com.nitryx.backend.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository extends JpaRepository<Cliente, Long> {

}