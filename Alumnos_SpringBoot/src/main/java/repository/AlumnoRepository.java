/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package repository;

import entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author denis
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    @Query("SELECT numControl FROM Alumno WHERE numControl = ?1")
    public Alumno findByNumControl(String numControl);
    
    @Query("SELECT nombre FROM Alumno WHERE nombre = ?1")
    public Alumno findByNombre(String nombre);
    
}
