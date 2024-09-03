package com.example.IntegradorII.controller;

import com.example.IntegradorII.entity.Domicilio;
import com.example.IntegradorII.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domicilio")
public class ControllerDomicilio {
    @Autowired
    private DomicilioService domicilioService;

    @PostMapping
    public ResponseEntity<Domicilio> registrarDomicilio(@RequestBody Domicilio domicilio){
        return ResponseEntity.ok(domicilioService.guardarDomicilio(domicilio));
    }

    @GetMapping
    public ResponseEntity<List<Domicilio>> listarDomicilios(){
        return ResponseEntity.ok(domicilioService.listarDomicilio());
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarDomicilio(@RequestBody Integer id){
        Optional<Domicilio> domicilioBuscado= domicilioService.buscarPorID(id);
        if(domicilioBuscado.isPresent()){
            domicilioService.eliminarDomicilio(id);
            return ResponseEntity.ok("Domicilio eliminado");
        }else {
            return ResponseEntity.badRequest().body("Domicilio no encontrado");
        }
    }


}
