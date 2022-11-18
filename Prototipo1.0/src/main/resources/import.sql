INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias) VALUES ('Disco', 'CD José Madero', 'Disco psalmos el mejor perro disco', 100, 60.00, 5 );
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias) VALUES ('Disco', 'CD José Madero', 'Disco giallo el mejor perro disco', 100, 60.00, 3 );

INSERT INTO actividades (id, categoria, nombre, descripcion, recompensa) VALUES (12345,'Entretenimiento', 'Ciclo Cine Star Wars', 'Trilogía original en auditorio ABC', 15);
INSERT INTO actividades (id, categoria, nombre, descripcion, recompensa) VALUES (67890,'Conferencia', 'Gravedad Repulsiva', 'Conferencia auditorio ABC', 15);
INSERT INTO actividades (id, categoria, nombre, descripcion, recompensa) VALUES (13579,'Administrativo', 'Credencial', 'Resello de crencial', 10);
INSERT INTO actividades (id, categoria, nombre, descripcion, recompensa) VALUES (24680,'Biblioteca', 'Hacking for Begginers', 'Prestamo de libro', 20);

INSERT INTO usuarios (username, nombre, paterno, materno, carrera, celular, email, enabled, password, pumapuntos) VALUES ('123456789','Uriel','apellido uriel','xd','carrera chida',5512,'correoxd',true, '$2a$10$OyAWFIe5lToI9fyST7zmV.3FKYfGbPvvJtRh3jM6U1TYcHaixqJXK', 100);
INSERT INTO usuarios (username, nombre, paterno, materno, carrera, celular, email, enabled, password, pumapuntos) VALUES ('312042513','admin','apellido admin','mas','carrera buena',5554,'correo@xd',true, '$2a$10$nbcr3bqlvmywtogFL2DPjOq/s69C86OX6N3S0BxZlHOuaV6W1SnbG', 100);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);

