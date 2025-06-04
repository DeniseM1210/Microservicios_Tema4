/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package edu.tecjerez.controller;

import edu.tecjerez.entity.Actividades;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import edu.tecjerez.repository.ActividadesRepository;

@RestController
@RequestMapping("/actividades")
public class ActividadesRestController {
    
    @Autowired
    ActividadesRepository actividadesRepository;
    
    @GetMapping()
    public List<Actividades> list() {
        return actividadesRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        Optional<Actividades> actividades = actividadesRepository.findById(id);
        if(actividades.isPresent())
            return  new ResponseEntity<>(actividades.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Actividades input) {
        Optional<Actividades> actividades = actividadesRepository.findById(id);
        if(actividades.isPresent()){
            Actividades nuevaActividad = actividades.get();
            nuevaActividad.setNombreActividad(input.getNombreActividad());
            nuevaActividad.setCreditos(input.getCreditos());
            Actividades m = actividadesRepository.save(nuevaActividad);
            return  new ResponseEntity<>(actividades.get(), HttpStatus.OK); 
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Actividades input) {
        Actividades actividades = actividadesRepository.save(input);
        return ResponseEntity.ok(actividades);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        actividadesRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
