/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udistrital.BackEnd.Controller;

import edu.udistrital.BackEnd.Model.Actividad;
import edu.udistrital.BackEnd.Service.ActividadService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nath
 */

@RestController
@RequestMapping("/api/actividades")
public class ActividadRestController {
    
    //Inyeccion a Actividadservice
     /**
     * Constructor con inyección de dependencias
     * @param service Instancia del servicio
     */
    @Autowired
    public ActividadService service;
    public ActividadRestController(ActividadService service) {
    this.service = service;
    }
    
     /**
     * Crea una nueva actividad
     * @param actividadDTO Objeto Actividad a crear (recibido como JSON)
     * @return ResponseEntity con la actividad creada
     */
    @PostMapping("/actividad")
    @ResponseStatus(HttpStatus.CREATED)
    public Actividad crearActividad( @RequestBody Actividad actividad) {
  
    return service.crear(actividad);
    }
    
     /**
     *  Obtener todas las actividades
     */
    @GetMapping
    public List<Actividad> obtenerActividades() {
         
    return service.obtenerTodas();
    }
    
     /**
     * Obtener una actividad por ID
     * @param id ID de la actividad
     */
    @GetMapping("/{id}")
    public Actividad obtenerActividadPorId(@PathVariable("id") Long id) {

        return service.obtenerPorId(id);

    }
    
     /**
     * PActualizar una actividad existente
     * @param id ID de la actividad a actualizar
     * @param actividadActualizada Datos actualizados de la actividad (recibido como JSON)
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Actividad> actualizarActividad(
                @PathVariable Long id, 
                @RequestBody Actividad actividadActualizada) {

            // Llamamos al servicio que devuelve el Optional
            Optional<Actividad> resultado = service.actualizar(id, actividadActualizada);
            return resultado
                    .map(actividad -> ResponseEntity.ok(actividad)) 
                .orElseGet(() -> ResponseEntity.notFound().build());
                }
        
    
     /**
     * Eliminar una actividad por ID
     * @param id ID de la actividad a eliminar
     */
    @DeleteMapping("/delete/{id}")
    public void eliminarActividad(@PathVariable("id") Long id) {

        service.eliminar(id);
        
    }

}
