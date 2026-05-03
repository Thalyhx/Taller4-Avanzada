/*
 * Click nbfs://nbhost/SystemFileTools/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileTools/Templates/Classes/Class.java to edit this template
 */
package edu.udistrital.BackEnd.Controller;

import edu.udistrital.BackEnd.Model.ActividadDTO;
import edu.udistrital.BackEnd.Model.ActividadResponse;
import edu.udistrital.BackEnd.Service.ActividadService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador MVC para gestionar la presentación de Actividades
 * Utiliza Thymeleaf para renderizar vistas HTML
 * @author nath
 */
//@Controller
@RequestMapping("/actividades")
public class ActividadController {
    
    @Autowired
    private ActividadService service;
    
    /**
     * Constructor con inyección de dependencias
     * @param service Instancia del servicio de actividades
     */
    public ActividadController(ActividadService service) {
        this.service = service;
    }
    
    /**
     * Muestra la lista de todas las actividades
     * @param model Modelo para pasar datos a la vista
     * @return Nombre de la plantilla HTML
     */
    @GetMapping("")
    public String listarActividades(Model model) {
        try {
            List<ActividadDTO> actividades = service.obtenerTodas();
            model.addAttribute("actividades", actividades);
            model.addAttribute("titulo", "Lista de Actividades");
            return "actividades/lista";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar las actividades: " + e.getMessage());
            return "error";
        }
    }
    
    /**
     * Muestra el formulario para crear una nueva actividad
     * @param model Modelo para pasar datos a la vista
     * @return Nombre de la plantilla HTML
     */
    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("actividadResponse", new ActividadResponse());
        model.addAttribute("titulo", "Crear Nueva Actividad");
        return "actividades/formulario";
    }
    
    /**
     * Procesa la creación de una nueva actividad
     * @param actividadResponse Datos de la actividad recibidos del formulario
     * @param redirectAttributes Atributos para redireccionamiento
     * @return Redirección a la lista de actividades
     */
    @PostMapping("/guardar")
    public String guardarActividad(ActividadResponse actividadResponse, 
                                   RedirectAttributes redirectAttributes) {
        try {
            // Validación del título
            if (actividadResponse.getTitulo() == null || actividadResponse.getTitulo().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "El título es obligatorio");
                return "redirect:/actividades/crear";
            }
            
            // Convertir ActividadResponse a ActividadDTO
            ActividadDTO actividadDTO = new ActividadDTO();
            actividadDTO.setTitulo(actividadResponse.getTitulo());
            actividadDTO.setDescripcion(actividadResponse.getDescripcion());
            actividadDTO.setFechaInicio(actividadResponse.getFechaInicio());
            actividadDTO.setFechaTerminacion(actividadResponse.getFechaTerminacion());
            actividadDTO.setTipoActividad(actividadResponse.getTipoActividad());
            actividadDTO.setIdQuehacer((long) actividadResponse.getIdQuehacer());
            actividadDTO.setIdTutor((long) actividadResponse.getIdTutor());
            actividadDTO.setIdHijo((long) actividadResponse.getIdHijo());
            
            // Guardar en base de datos
            service.crear(actividadDTO);
            redirectAttributes.addFlashAttribute("exito", "Actividad creada exitosamente");
            return "redirect:/actividades";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al crear la actividad: " + e.getMessage());
            return "redirect:/actividades/crear";
        }
    }
    
    /**
     * Muestra los detalles de una actividad específica
     * @param id ID de la actividad
     * @param model Modelo para pasar datos a la vista
     * @return Nombre de la plantilla HTML o página de error
     */
    @GetMapping("/{id}")
    public String verActividad(@PathVariable Long id, Model model) {
        try {
            ActividadDTO actividad = service.obtenerPorId(id);
            
            // Convertir ActividadDTO a ActividadResponse
            ActividadResponse actividadResponse = new ActividadResponse();
            actividadResponse.setTitulo(actividad.getTitulo());
            actividadResponse.setDescripcion(actividad.getDescripcion());
            actividadResponse.setFechaInicio(actividad.getFechaInicio());
            actividadResponse.setFechaTerminacion(actividad.getFechaTerminacion());
            actividadResponse.setTipoActividad(actividad.getTipoActividad());
            actividadResponse.setIdQuehacer(Math.toIntExact(actividad.getIdQuehacer()));
            actividadResponse.setIdTutor(Math.toIntExact(actividad.getIdTutor()));
            actividadResponse.setIdHijo(Math.toIntExact(actividad.getIdHijo()));
            
            model.addAttribute("actividad", actividad);
            model.addAttribute("actividadResponse", actividadResponse);
            model.addAttribute("titulo", "Detalles de Actividad");
            return "actividades/detalle";
        } catch (java.util.NoSuchElementException e) {
            model.addAttribute("error", "Actividad no encontrada con ID: " + id);
            model.addAttribute("id", id);
            return "error";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la actividad: " + e.getMessage());
            return "error";
        }
    }
    
    /**
     * Muestra el formulario para editar una actividad existente
     * @param id ID de la actividad a editar
     * @param model Modelo para pasar datos a la vista
     * @return Nombre de la plantilla HTML o página de error
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        try {
            ActividadDTO actividad = service.obtenerPorId(id);
            
            // Convertir ActividadDTO a ActividadResponse
            ActividadResponse actividadResponse = new ActividadResponse();
            actividadResponse.setTitulo(actividad.getTitulo());
            actividadResponse.setDescripcion(actividad.getDescripcion());
            actividadResponse.setFechaInicio(actividad.getFechaInicio());
            actividadResponse.setFechaTerminacion(actividad.getFechaTerminacion());
            actividadResponse.setTipoActividad(actividad.getTipoActividad());
            actividadResponse.setIdQuehacer(Math.toIntExact(actividad.getIdQuehacer()));
            actividadResponse.setIdTutor(Math.toIntExact(actividad.getIdTutor()));
            actividadResponse.setIdHijo(Math.toIntExact(actividad.getIdHijo()));
            
            model.addAttribute("actividadResponse", actividadResponse);
            model.addAttribute("id", id);
            model.addAttribute("titulo", "Editar Actividad");
            return "actividades/formulario";
        } catch (java.util.NoSuchElementException e) {
            model.addAttribute("error", "Actividad no encontrada con ID: " + id);
            model.addAttribute("id", id);
            return "error";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la actividad: " + e.getMessage());
            return "error";
        }
    }
    
    /**
     * Procesa la actualización de una actividad existente
     * @param id ID de la actividad a actualizar
     * @param actividadResponse Datos actualizados recibidos del formulario
     * @param redirectAttributes Atributos para redireccionamiento
     * @return Redirección a los detalles de la actividad
     */
    @PostMapping("/actualizar/{id}")
    public String actualizarActividad(@PathVariable Long id, 
                                      ActividadResponse actividadResponse,
                                      RedirectAttributes redirectAttributes) {
        try {
            // Validación del título
            if (actividadResponse.getTitulo() == null || actividadResponse.getTitulo().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "El título es obligatorio");
                return "redirect:/actividades/editar/" + id;
            }
            
            // Convertir ActividadResponse a ActividadDTO
            ActividadDTO actividadDTO = new ActividadDTO();
            actividadDTO.setTitulo(actividadResponse.getTitulo());
            actividadDTO.setDescripcion(actividadResponse.getDescripcion());
            actividadDTO.setFechaInicio(actividadResponse.getFechaInicio());
            actividadDTO.setFechaTerminacion(actividadResponse.getFechaTerminacion());
            actividadDTO.setTipoActividad(actividadResponse.getTipoActividad());
            actividadDTO.setIdQuehacer((long) actividadResponse.getIdQuehacer());
            actividadDTO.setIdTutor((long) actividadResponse.getIdTutor());
            actividadDTO.setIdHijo((long) actividadResponse.getIdHijo());
            
            // Actualizar en base de datos
            Optional<ActividadDTO> resultado = service.actualizar(id, actividadDTO);
            
            if (resultado.isPresent()) {
                redirectAttributes.addFlashAttribute("exito", "Actividad actualizada exitosamente");
                return "redirect:/actividades/" + id;
            } else {
                redirectAttributes.addFlashAttribute("error", "Actividad no encontrada");
                return "redirect:/actividades/editar/" + id;
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar la actividad: " + e.getMessage());
            return "redirect:/actividades/editar/" + id;
        }
    }
    
    /**
     * Elimina una actividad por su ID
     * @param id ID de la actividad a eliminar
     * @param redirectAttributes Atributos para redireccionamiento
     * @return Redirección a la lista de actividades
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarActividad(@PathVariable Long id, 
                                    RedirectAttributes redirectAttributes) {
        try {
            boolean eliminado = service.eliminar(id);
            
            if (eliminado) {
                redirectAttributes.addFlashAttribute("exito", "Actividad eliminada exitosamente");
            } else {
                redirectAttributes.addFlashAttribute("error", "Actividad no encontrada");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar la actividad: " + e.getMessage());
        }
        
        return "redirect:/actividades";
    }
}


