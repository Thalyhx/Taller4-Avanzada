/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udistrital.BackEnd.Service;

import edu.udistrital.BackEnd.Model.ActividadDTO;
import edu.udistrital.BackEnd.Repository.ActividadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio de Actividad - Contiene la lógica de negocio
 * @author nath
 */

@Service
public class ActividadService {
    
    //Inyeccion a Actividadrepositorio
    /**
     * Constructor con inyección de dependencias
     * @param repository Instancia del repositorio
     */
    @Autowired
            
    ActividadRepository repository;
    public ActividadService(ActividadRepository repository){
        this.repository = repository;
    }  
    
     /**
     * Obtiene todas las actividades
     * @return Lista de actividades
     */
    public List<ActividadDTO> obtenerTodas() {
        return repository.findAll();
    }
    
    /**
     * Obtiene una actividad por su ID
     *
     * @param id ID de la actividad
     * @return Optional con la actividad si existe
     */
    public ActividadDTO obtenerPorId(Long id) {
        
        Optional<ActividadDTO> optionalActividad = repository.findById(id);
        return optionalActividad.get();
    }
    
     /**
     * Crea una nueva actividad
     * @param actividadDTO Objeto de actividad a guardar
     * @return La actividad guardada
     */
    public ActividadDTO crear (ActividadDTO actividad) {
        return repository.save(actividad);
    }
    
     /**
     * Actualiza una actividad existente
     * @param id ID de la actividad a actualizar
     * @param actividadActualizada Datos actualizados de la actividad
     * @return La actividad actualizada
     */
            public Optional<ActividadDTO> actualizar(Long id, ActividadDTO actividadActualizada) {

                //Busca en la base de datos.
                return repository.findById(id).map(actividadAntigua -> {

                    // validaciones 
                    if (actividadActualizada.getTitulo() != null && !actividadActualizada.getTitulo().isEmpty()) {
                        actividadAntigua.setTitulo(actividadActualizada.getTitulo());
                    }
                    if (actividadActualizada.getDescripcion() != null) {
                        actividadAntigua.setDescripcion(actividadActualizada.getDescripcion());
                    }
                    if (actividadActualizada.getFechaInicio() != null) {
                        actividadAntigua.setFechaInicio(actividadActualizada.getFechaInicio());
                    }
                    if (actividadActualizada.getFechaTerminacion() != null) {
                        actividadAntigua.setFechaTerminacion(actividadActualizada.getFechaTerminacion());
                    }
                    if (actividadActualizada.getTipoActividad() != null) {
                        actividadAntigua.setTipoActividad(actividadActualizada.getTipoActividad());
                    }
                    if (actividadActualizada.getIdQuehacer() != null) {
                        actividadAntigua.setIdQuehacer(actividadActualizada.getIdQuehacer());
                    }
                    if (actividadActualizada.getIdTutor() != null) {
                        actividadAntigua.setIdTutor(actividadActualizada.getIdTutor());
                    }
                    if (actividadActualizada.getIdHijo() != null) {
                        actividadAntigua.setIdHijo(actividadActualizada.getIdHijo());
                    }

                    //  Guarda la Entidad actualizada en la base de datos
                    return repository.save(actividadAntigua);
                    
                });
            }
    
    /**
     * Elimina una actividad por su ID
     * @param id ID de la actividad a eliminar
     * @return true si se eliminó, false si no existe
     */
    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
