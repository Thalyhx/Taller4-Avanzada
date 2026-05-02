-- ============================================
-- DATA.SQL - Datos Iniciales para ACTIVIDADES
-- ============================================
-- Este archivo contiene inserts de ejemplo
-- para probar todos los endpoints del microservicio

INSERT INTO actividades (titulo, descripcion, fecha_inicio, fecha_terminacion, tipo_actividad, id_quehacer, id_tutor, id_hijo) 
VALUES 
('Tarea de Programacion Java', 'Implementar algoritmo de ordenamiento QuickSort', '2026-05-02', '2026-05-15', 'Programacion', 1, 5, 10);

INSERT INTO actividades (titulo, descripcion, fecha_inicio, fecha_terminacion, tipo_actividad, id_quehacer, id_tutor, id_hijo) 
VALUES 
('Ejercicio de Base de Datos', 'Crear consultas SQL avanzadas con JOINs', '2026-05-03', '2026-05-18', 'Base de Datos', 2, 3, 11);

INSERT INTO actividades (titulo, descripcion, fecha_inicio, fecha_terminacion, tipo_actividad, id_quehacer, id_tutor, id_hijo) 
VALUES 
('Desarrollo REST API', 'Implementar endpoints CRUD con Spring Boot', '2026-05-01', '2026-05-20', 'Programacion', 3, 5, 12);

INSERT INTO actividades (titulo, descripcion, fecha_inicio, fecha_terminacion, tipo_actividad, id_quehacer, id_tutor, id_hijo) 
VALUES 
('Testing Unitario', 'Escribir pruebas unitarias con JUnit 5', '2026-05-05', '2026-05-12', 'Testing', 4, 6, 13);

INSERT INTO actividades (titulo, descripcion, fecha_inicio, fecha_terminacion, tipo_actividad, id_quehacer, id_tutor, id_hijo) 
VALUES 
('Documentación API', 'Documentar endpoints con Swagger/OpenAPI', '2026-05-07', '2026-05-25', 'Documentacion', 5, 4, 14);

INSERT INTO actividades (titulo, descripcion, fecha_inicio, fecha_terminacion, tipo_actividad, id_quehacer, id_tutor, id_hijo) 
VALUES 
('Refactorizacion de Codigo', 'Mejorar legibilidad y aplicar patrones de disenio', '2026-05-08', '2026-05-22', 'Mantenimiento', 6, 7, 15);

INSERT INTO actividades (titulo, descripcion, fecha_inicio, fecha_terminacion, tipo_actividad, id_quehacer, id_tutor, id_hijo) 
VALUES 
('Integracion Continua', 'Configurar pipeline CI/CD con GitHub Actions', '2026-05-10', '2026-05-30', 'DevOps', 7, 8, 16);

INSERT INTO actividades (titulo, descripcion, fecha_inicio, fecha_terminacion, tipo_actividad, id_quehacer, id_tutor, id_hijo) 
VALUES 
('Seguridad en Aplicaciones', 'Implementar validaciones y sanitización de inputs', '2026-05-04', '2026-05-19', 'Seguridad', 8, 9, 17);
