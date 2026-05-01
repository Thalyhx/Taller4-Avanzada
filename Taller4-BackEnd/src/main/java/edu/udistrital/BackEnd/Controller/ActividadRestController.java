/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udistrital.BackEnd.Controller;

import edu.udistrital.BackEnd.Repository.ActividadRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nath
 */

@RestController
public class ActividadRestController {
    
    //Inyeccion a Actividadrepositorio
    ActividadRepository repositorio;
    public ActividadRestController(ActividadRepository repositorio){
        this.repositorio = repositorio;
    }    
  
}
