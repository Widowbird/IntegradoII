package com.example.IntegradorII.repository;

import com.example.IntegradorII.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    void deleteAllById(Integer id);
}
