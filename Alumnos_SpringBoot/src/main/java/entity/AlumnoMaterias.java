/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

/**
 *
 * @author denis
 */
@Data
@Entity
public class AlumnoMaterias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String cveMateria;
    
    @Transient
    private String nombreMateria;
    
    @JsonIgnore //Sirve para evitar una recursion infinita de busqueda del nombre
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Alumno.class)
    @JoinColumn(name = "alumnoId", nullable = true)
    private Alumno alumno;
    
}
