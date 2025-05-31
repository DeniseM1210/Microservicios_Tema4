/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package repository;

import entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author denis
 */
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    
    
}
