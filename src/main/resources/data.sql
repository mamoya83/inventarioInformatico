-- Insertar usuarios
INSERT IGNORE INTO usuarios (id, nombre, cargo, departamento) VALUES (1, 'Ana Torres', 'Analista', 'TI');
INSERT IGNORE INTO usuarios (id, nombre, cargo, departamento) VALUES (2, 'Luis Pérez', 'Soporte', 'TI');

-- Insertar equipos
INSERT IGNORE INTO equipos (id, tipo, marca, modelo, numero_serie, estado, ubicacion)
VALUES (1, 'Laptop', 'HP', 'EliteBook', '123ABC', 'Disponible', 'Oficina Central');

INSERT IGNORE INTO equipos (id, tipo, marca, modelo, numero_serie, estado, ubicacion)
VALUES (2, 'Monitor', 'Dell', 'P2419H', '456DEF', 'Asignado', 'Almacén');

-- Insertar asignaciones
INSERT IGNORE INTO asignaciones (id, id_equipo, id_usuario, fecha_asignacion)
VALUES (1, 2, 1, '2024-10-01');

-- Insertar mantenimiento
INSERT IGNORE INTO mantenimiento (id, id_equipo, tipo, fecha, descripcion)
VALUES (1, 1, 'preventivo', '2025-01-10', 'Limpieza de hardware');

-- Insertar software
INSERT IGNORE INTO software (id, nombre, version, licencia, fecha_expiracion)
VALUES (1, 'Office 365', '2021', 'OEM', '2025-12-31');
