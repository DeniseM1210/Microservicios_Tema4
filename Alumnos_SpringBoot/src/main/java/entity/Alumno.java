/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.Transient;
import jakarta.persistence.criteria.Fetch;
import java.util.List;
import lombok.Data;
/**
 *
 * @author denis
 */
@Data //codigo automatizado de LOMBOK para Getters y Setters
@Entity
public class Alumno {
    
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;
    private String numControl;
    private String nombre;
    private byte edad;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "alumno", cascade=CascadeType.ALL, 
            orphanRemoval = true)
    private List<AlumnoMaterias> materias;
    
    //private List<ActividadesExtra> actividades;
    @Transient
    private List<?> actividades;
}

