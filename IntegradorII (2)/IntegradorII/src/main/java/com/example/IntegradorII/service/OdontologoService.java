package com.example.IntegradorII.service;

import com.example.IntegradorII.entity.Domicilio;
import com.example.IntegradorII.entity.Odontologo;
import com.example.IntegradorII.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository;

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public List<Odontologo> listarOdontologos(){
        return odontologoRepository.findAll();
    }
    public void eliminarOdontologo(Integer id){
        odontologoRepository.deleteById(id);
    } //cambio deleteAllById
    public Optional<Odontologo> buscarPorID(Integer id){ return odontologoRepository.findById(id);}
}
