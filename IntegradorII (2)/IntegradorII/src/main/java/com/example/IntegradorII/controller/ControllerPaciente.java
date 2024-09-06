package com.example.IntegradorII.controller;

import com.example.IntegradorII.entity.Paciente;
import com.example.IntegradorII.exception.ResourceNotFoundException;
import com.example.IntegradorII.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class ControllerPaciente {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente (@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(){
        return ResponseEntity.ok(pacienteService.listarPaciente());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado= pacienteService.buscarPorID(id);
        if(pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteBuscado);
        }else {
            throw new ResourceNotFoundException("Paciente no encontrado");
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id){
        Optional<Paciente> pacienteBuscado= pacienteService.buscarPorID(id);
        if(pacienteBuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Paciente eliminado");
        }else {
            return ResponseEntity.badRequest().body("Paciente no encontrado");
        }
    }
}
