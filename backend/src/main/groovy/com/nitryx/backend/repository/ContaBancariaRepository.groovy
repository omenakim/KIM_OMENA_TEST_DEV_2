package com.nitryx.backend.repository

import com.nitryx.backend.model.ContaBancaria
import org.springframework.data.jpa.repository.JpaRepository

interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {



}