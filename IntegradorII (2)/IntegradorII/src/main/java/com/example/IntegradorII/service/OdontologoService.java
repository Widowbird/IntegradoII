package com.example.IntegradorII.service;

import com.example.IntegradorII.entity.Odontologo;
import com.example.IntegradorII.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void elimnarOdontologo(Integer id){
        odontologoRepository.deleteAllById(id);
    }
}
