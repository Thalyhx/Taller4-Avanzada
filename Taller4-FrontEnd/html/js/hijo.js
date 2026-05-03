/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


document.addEventListener("DOMContentLoaded", () => {
    // Carga inicial de todas las actividades
    cargarCalendario();

    // Evento para buscar por ID
    const btnBuscar = document.getElementById("btnBuscar");
    if (btnBuscar) {
        btnBuscar.addEventListener("click", async () => {
            const id = document.getElementById("inputIdBuscador").value;
            if (!id) return alert("Por favor, ingresa un ID para buscar.");

            try {
                // Usa la función de búsqueda de api.js
                const actividad = await obtenerActividadPorId(id);
                
                renderizarCalendario([actividad]); 
                
            } catch (error) {
                alert("No se encontró la actividad con ID: " + id);
                console.error(error);
            }
        });
    }

    //  Evento para limpiar búsqueda 
    const btnLimpiar = document.getElementById("btnLimpiar");
    if (btnLimpiar) {
        btnLimpiar.addEventListener("click", () => {
            document.getElementById("inputIdBuscador").value = ""; // Limpia el input
            cargarCalendario(); // Llama a la función de carga general del hijo
        });
    }
});

async function cargarCalendario() {
    try {
        // Obtiene los datos
        const actividades = await obtenerTodasLasActividades();
        renderizarCalendario(actividades);
    } catch (error) {
        console.error("Error al cargar el calendario:", error);
    }
}

function renderizarCalendario(lista) {
    const body = document.getElementById("bodyCalendario");
    body.innerHTML = "";

    lista.forEach(act => {
        const fila = `
            <tr>
                <td>${act.idActividad}</td>
                <td><strong>${act.titulo}</strong></td>
                <td>${act.fechaInicio}</td>
                <td>${act.fechaTerminacion}</td>
                <td class="text-small">${act.descripcion}</td>
                <td><span class="badge">${act.tipoActividad}</span></td>
                <td>ID: ${act.idHijo}</td>
                <td>ID: ${act.idTutor}</td>
                <td>
                    <button class="btn-comment" onclick="abrirCajaComentarios(${act.idActividad})">
                        Comentar
                    </button>
                </td>
            </tr>
        `;
        body.innerHTML += fila;
    });
}

function abrirCajaComentarios(id) {

    const comentario = prompt("Escribe tu comentario sobre la actividad #" + id);
    if (comentario) {
        console.log("Guardando comentario para ID " + id + ": " + comentario);
        alert("Comentario enviado al tutor");
    }
}