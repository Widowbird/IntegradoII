package com.example.IntegradorII.controller;

import com.example.IntegradorII.entity.Odontologo;
import com.example.IntegradorII.entity.Paciente;
import com.example.IntegradorII.entity.Turno;
import com.example.IntegradorII.exception.BadRequestException;
import com.example.IntegradorII.exception.ResourceNotFoundException;
import com.example.IntegradorII.service.OdontologoService;
import com.example.IntegradorII.service.PacienteService;
import com.example.IntegradorII.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turno")
public class ControllerTurno {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) throws BadRequestException {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorID(turno.getPaciente().getId());
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorID(turno.getOdontologo().getId());
        if(pacienteBuscado.isPresent()&&odontologoBuscado.isPresent()){
            return ResponseEntity.ok(turnoService.guardarTurno( turno));
        }else{
            throw new BadRequestException("Paciente o Odontologo no encontrado");
        }
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurno());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Turno>> buscarTurnoId(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.buscarPorID(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id){
        Optional<Turno> turnoBuscado= turnoService.buscarPorID(id);
        if(turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Turno eliminado");
        }else {
            return ResponseEntity.badRequest().body("Turno no encontrado");
        }
    }
}
