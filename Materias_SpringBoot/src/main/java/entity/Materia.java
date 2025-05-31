/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
/**
 *
 * @author denis
 */
@Data //codigo automatizado de lombok para getterss y setters
@Entity

public class Materia {
    
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;
    private String nombreMateria;
    
    
    
    
}
