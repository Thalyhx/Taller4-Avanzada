/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udistrital.Model;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author nath
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Actividad {
    
    private int idActividad;
    
    @NonNull
    private String titulo;
    
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminacion;
    private String tipoActividad;
    private int idQuehacer;
    private int idTutor;
    private int idHijo;
    
    
}
