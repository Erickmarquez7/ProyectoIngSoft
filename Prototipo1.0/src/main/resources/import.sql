INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias) VALUES ('Disco', 'CD José Madero', 'Disco psalmos el mejor perro disco', 100, 250.00, 5 );
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias) VALUES ('Disco', 'CD José Madero', 'Disco giallo el mejor perro disco', 100, 250.00, 3 );

INSERT INTO usuarios (username, nombre, paterno, materno, carrera, celular, email, enabled, password) VALUES ('uzielito mix','Uriel','apellido uriel','xd','carrera chida',5512,'correoxd',true, '$2a$10$OyAWFIe5lToI9fyST7zmV.3FKYfGbPvvJtRh3jM6U1TYcHaixqJXK');
INSERT INTO usuarios (username, nombre, paterno, materno, carrera, celular, email, enabled, password) VALUES ('bbsita','admin','apellido admin','mas','carrera buena',5554,'correo@xd',true, '$2a$10$nbcr3bqlvmywtogFL2DPjOq/s69C86OX6N3S0BxZlHOuaV6W1SnbG');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);

INSERT INTO rentar(fechainicio, fechafin, id, idproducto) VALUES('2020-11-12','2021-12-07', 1 ,1)

INSERT INTO pumapuntos(saldo, fechavalida, id) VALUES(200,'2021-12-07',1)


-- SELECT * FROM productos INNER JOIN rentar on productos.id = rentar.id;
-- SELECT * FROM usuarios INNER JOIN rentar on usuarios.id = rentar.id;
-- SELECT * FROM usuarios INNER JOIN pumapuntos on usuarios.id = pumapuntos.id;
/*
 SELECT usuarios.nombre, usuarios.paterno, usuarios.materno, usuarios.username,
 		rentar.fechafin, rentar.fechainicio, 
 		producto.nombre, producto.categoria, producto.id
  FROM usuarios 
  JOIN rentar 
  ON usuarios.id = rentar.id
  JOIN productos 
  ON productos.id = rentar.id
*/		