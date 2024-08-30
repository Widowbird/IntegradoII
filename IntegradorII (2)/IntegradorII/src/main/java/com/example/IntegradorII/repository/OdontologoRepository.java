package com.example.IntegradorII.repository;

import com.example.IntegradorII.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdontologoRepository extends JpaRepository<Odontologo,Integer> {
    void deleteAllById(Integer id);
}
