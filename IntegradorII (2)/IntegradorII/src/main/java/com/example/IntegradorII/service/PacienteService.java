package com.example.IntegradorII.service;

import com.example.IntegradorII.entity.Paciente;
import com.example.IntegradorII.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente guardarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public List<Paciente> listarPaciente(){
        return pacienteRepository.findAll();
    }
    public void elimnarPaciente(Integer id){
        pacienteRepository.deleteAllById(id);
    }
}
