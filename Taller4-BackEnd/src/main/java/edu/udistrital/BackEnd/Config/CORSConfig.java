/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.udistrital.BackEnd.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase que implementa WebMvcConfigurer an vez de usar @Beans
 * @author nath
 */

@Configuration
public class CORSConfig implements WebMvcConfigurer{    
    
    //Metodo 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //Aplica a todos los endpoints 
                .allowedOrigins("http://localhost:3000", "http://localhost:4200") //Las URLs del Frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // ermite cualquier cabecera 
                .allowCredentials(true); // Cookies o Tokens de seguridad
    }
    
}
