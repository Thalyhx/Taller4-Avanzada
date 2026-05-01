/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udistrital.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author nath
 */
@Entity
@Data
public class ActividadDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //JPA, que el id se vaya auto incrementando
    private Long idActividad;
    
    @Column(nullable = false, length = 100)
    private String titulo;
    
    @Column(length = 500)
    private String descripcion;
    
    private LocalDate fechaInicio;
    private LocalDate fechaTerminacion;
    private String tipoActividad;
    private Long idQuehacer;
    private Long idTutor;
    private Long idHijo;

    
    //Constructor
    
    public ActividadDTO(Long idActividad, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaTerminacion, String tipoActividad, Long idQuehacer, Long idTutor, Long idHijo) {
        this.idActividad = idActividad;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
        this.tipoActividad = tipoActividad;
        this.idQuehacer = idQuehacer;
        this.idTutor = idTutor;
        this.idHijo = idHijo;
    }
    
    
    
}
