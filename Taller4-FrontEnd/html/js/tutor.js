/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

document.addEventListener("DOMContentLoaded", () => {
    cargarTabla();

    // Evento para buscar por ID
    document.getElementById("btnBuscar").addEventListener("click", async () => {
        const id = document.getElementById("inputIdBuscador").value;
        if (!id) return alert("Ingresa un ID");

        try {
            const actividad = await obtenerActividadPorId(id);
            renderizarTabla([actividad]); 
        } catch (error) {
            alert("No se encontró la actividad");
        }
    });

    // Evento para limpiar búsqueda
    document.getElementById("btnLimpiar").addEventListener("click", cargarTabla);
});

async function cargarTabla() {
    try {
        const actividades = await obtenerTodasLasActividades();
        renderizarTabla(actividades);
    } catch (error) {
        console.error("Error al cargar datos", error);
    }
}

function renderizarTabla(lista) {
    const body = document.getElementById("bodyActividades");
    body.innerHTML = ""; // Limpiar tabla

    lista.forEach(act => {
        const fila = `
            <tr>
                <td>${act.idActividad}</td>
                <td>${act.titulo}</td>
                <td>${act.descripcion}</td>
                <td>${act.tipoActividad}</td>
                <td>Hijo ID: ${act.idHijo}</td>
                <td>Tutor ID:${act.idTutor}</td>
                <td>
                    <button class="btn-edit" onclick="prepararEdicion(${act.idActividad})">Editar</button>
                    <button class="btn-delete" onclick="ejecutarEliminacion(${act.idActividad})">X</button>
                </td>
            </tr>
        `;
        body.innerHTML += fila;
    });
}

// Función para borrar
async function ejecutarEliminacion(id) {
    if(confirm("¿Seguro que quieres borrar esta actividad?")) {
        await eliminarActividad(id);
        cargarTabla(); // Recargar después de borrar
    }
}

async function prepararEdicion(id) {
    console.log("Intentando editar ID:", id); 
    
    try {
        // Usamos la función de búsqueda
        const act = await obtenerActividadPorId(id); 
        
        // inputs
        document.getElementById("editId").value = act.idActividad;
        document.getElementById("editTitulo").value = act.titulo;
        document.getElementById("editDescripcion").value = act.descripcion;
        document.getElementById("editTipo").value = act.tipoActividad;
        document.getElementById("editHijo").value = act.idHijo;

        // MUESTRA EL MODAL
        const modal = document.getElementById("modalEditar");
        if (modal) {
            modal.style.display = "block";
        } else {
            console.error("No se encontró el elemento modalEditar en el HTML");
        }
    } catch (error) {
        console.error("Error al cargar datos para editar:", error);
    }
}

// Función para cerrar el modal
function cerrarModal() {
    const modal = document.getElementById("modalEditar");
    if (modal) {
        modal.style.display = "none";
    }
}

// Cerrar el modal si el usuario hace clic fuera del contenido (en el fondo oscuro)
window.onclick = function(event) {
    const modal = document.getElementById("modalEditar");
    if (event.target == modal) {
        cerrarModal();
    }
}

