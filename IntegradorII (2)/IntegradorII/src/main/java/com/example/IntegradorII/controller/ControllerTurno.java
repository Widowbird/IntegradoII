package com.example.IntegradorII.controller;

import com.example.IntegradorII.entity.Turno;
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

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.guardarTurno(turno));
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurno());
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarTurno(@RequestBody Integer id){
        Optional<Turno> turnoBuscado= turnoService.buscarPorID(id);
        if(turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Turno eliminado");
        }else {
            return ResponseEntity.badRequest().body("Turno no encontrado");
        }
    }
}
