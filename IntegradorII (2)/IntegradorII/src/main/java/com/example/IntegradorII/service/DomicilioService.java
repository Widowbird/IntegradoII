package com.example.IntegradorII.service;

import com.example.IntegradorII.entity.Domicilio;
import com.example.IntegradorII.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;

    public Domicilio guardarDomicilio(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }
    public List<Domicilio> listarDomicilio(){
        return domicilioRepository.findAll();
    }
    public void eliminarDomicilio(Integer id){
        domicilioRepository.deleteAllById(id);
    }
}
