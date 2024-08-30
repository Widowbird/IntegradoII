package com.example.IntegradorII.repository;

import com.example.IntegradorII.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio,Integer> {
    void deleteAllById(Integer id);
}
