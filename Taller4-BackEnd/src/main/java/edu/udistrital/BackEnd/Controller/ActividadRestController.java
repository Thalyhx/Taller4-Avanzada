/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udistrital.BackEnd.Controller;

import edu.udistrital.BackEnd.Repository.ActividadRepository;
import edu.udistrital.BackEnd.Service.ActividadService;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nath
 */

@RestController
public class ActividadRestController {
    
    //Inyeccion a Actividadservice
    public ActividadService service;
    public ActividadRestController(ActividadService service) {
        this.service = service;
    }

    
    //Inyeccion a Actividadrepositorio
    ActividadRepository repository;
    public ActividadRestController(ActividadRepository repository){
        this.repository = repository;
    }    
    
    
  
}
