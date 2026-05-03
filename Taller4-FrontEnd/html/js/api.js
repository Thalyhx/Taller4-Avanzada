/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

/**
 * Configuración API
 * puerto 9000 donde corre Spring Boot
 */
const BASE_URL = "http://localhost:9000/api/actividades";

/**
 * Consultar todas las actividades (GET)
 * Mapea @RequestMapping(method = RequestMethod.GET)
 */
//async function obtenerTodasLasActividades() {
//   
//         try {
//            const respuesta = await fetch(BASE_URL);
//            if (!respuesta.ok) throw new Error("Error al obtener el listado de actividades");
//            
//            const datos = await respuesta.json();
//            return datos; 
//        } catch (error) {
//            console.error("Fallo de red o servidor:", error);
//            throw error;
//        }
//   
//}

/**
 * Consultar una actividad por ID (GET)
 * Mapea @RequestMapping(value="/{id}" ,method = RequestMethod.GET)
 */
//async function obtenerActividadPorId(id) {
//    try {
//        const respuesta = await fetch(`${BASE_URL}/${id}`);
//        if (!respuesta.ok) {
//            if (respuesta.status === 404) throw new Error("Actividad no encontrada");
//            throw new Error("Error en la consulta por ID");
//        }
//        
//        const datos = await respuesta.json();
//        return datos;
//    } catch (error) {
//        console.error(`Fallo al buscar el ID ${id}:`, error);
//        throw error;
//    }
//}

/**
 * Crear una nueva actividad (POST)
 * Mapea @RequestMapping(value = "/actividad", method = RequestMethod.POST)
 */
async function crearActividad(actividadObj) {
    try {
        
        const respuesta = await fetch(`${BASE_URL}/actividad`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json' // envia JSON
            },
            body: JSON.stringify(actividadObj) // Convierte el objeto JS a texto JSON
        });
        
        if (!respuesta.ok) throw new Error("Error al crear la actividad");
        
        const datos = await respuesta.json();
        return datos;
    } catch (error) {
        console.error("Fallo al crear:", error);
        throw error;
    }
}

/**
 * Actualizar una actividad existente (PUT)
 * Mapea @RequestMapping(value="/update/{id}" ,method = RequestMethod.PUT)
 */
//async function actualizarActividad(id, actividadActualizadaObj) {
//    try {
//        
//        const respuesta = await fetch(`${BASE_URL}/update/${id}`, {
//            method: 'PUT',
//            headers: {
//                'Content-Type': 'application/json'
//            },
//            body: JSON.stringify(actividadActualizadaObj)
//        });
//        
//        if (!respuesta.ok) {
//            if (respuesta.status === 404) throw new Error("La actividad a actualizar no existe");
//            throw new Error("Error al actualizar la actividad");
//        }
//        
//        const datos = await respuesta.json();
//        return datos;
//    } catch (error) {
//        console.error(`Fallo al actualizar el ID ${id}:`, error);
//        throw error;
//    }
//}

/**
 * Eliminar una actividad (DELETE)
 * Mapea @RequestMapping(value="/delete/{id}" ,method = RequestMethod.DELETE)
 */
async function eliminarActividad(id) {
    try {
        
        const respuesta = await fetch(`${BASE_URL}/delete/${id}`, {
            method: 'DELETE'
        });
        
        if (!respuesta.ok) throw new Error("Error al intentar eliminar la actividad");
        
        // Solo retorna true.
        return true; 
    } catch (error) {
        console.error(`Fallo al eliminar el ID ${id}:`, error);
        throw error;
    }
}

///////Pruebas///////

async function obtenerActividadPorId(id) {
    // --- SIMULACIÓN DE RESPUESTA DEL BACKEND ---
    console.log("Simulando búsqueda de ID:", id);
    
    const actividadFicticia = {
        idActividad: id,
        titulo: "Actividad de Prueba",
        descripcion: "Esta es una descripción cargada localmente para probar el modal.",
        tipoActividad: "Física",
        idHijo: 5,
        idTutor: 1
    };

    // En lugar de fetch, devolvemos el objeto directamente
    return actividadFicticia; 
}

async function actualizarActividad(id, datos) {
        
    console.log("Simulando PUT a /api/actividades/update/" + id, datos);
    
    return { status: "success", message: "Actualizado localmente" };
}

async function obtenerTodasLasActividades() {
    
    const actividadesDePrueba = [
        {
            idActividad: 1,
            titulo: "Lavar la ropa",
            descripcion: "Separar color de blanca y usar ciclo suave",
            fechaInicio: "2026-05-01",
            fechaTerminacion: "2026-05-01",
            tipoActividad: "Física",
            idQuehacer: 10,
            idTutor: 1,
            idHijo: 2
        },
        {
            idActividad: 2,
            titulo: "Regar las plantas",
            descripcion: "Usar poca agua en los cactus",
            fechaInicio: "2026-05-02",
            fechaTerminacion: "2026-05-02",
            tipoActividad: "Acompañamiento",
            idQuehacer: 11,
            idTutor: 1,
            idHijo: 3
        }
    ];
    return actividadesDePrueba;
}
