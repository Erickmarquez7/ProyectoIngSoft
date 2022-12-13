-- INSERT INTO rentar (fechaInicio, fechafin, usuario_id, producto_id) VALUES ('2022-10-10', '2022-10-12',1,1);
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Disco', 'Carmesi', 'Amor uwu', 50, 100, 5, 'https://i.scdn.co/image/ab67616d0000b273a59d5333ecb0c104538219be');
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Disco', 'Noche', 'Oscuridad', 100, 100, 3, 'https://i.scdn.co/image/ab67616d00001e02418b13d6e2851c6a307831b4');
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Disco', 'Alba', 'Nostalgia', 241, 150, 3, 'https://i.scdn.co/image/ab67616d00001e022ad8a8dd90be2d65ec430b64');
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Disco', 'Psalmos', 'depresión, ya se quería morir', 7, 75, 3, 'https://i.scdn.co/image/ab67616d0000b273c8ffb35bc9a6931a271e2631');
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Disco', 'Giallo', 'Ya se le quito la depre', 15, 100, 3, 'https://i.scdn.co/image/ab67616d00001e02242ad5bbebcb2b2c84625b8e');
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Deporte', 'Raqueta', 'Pa juegar', 15, 20, 3, 'https://imgs.search.brave.com/d-rAt9ZDMGzwTZbeGH4CO9_691Bvc8gTzbHsHVL_G7c/rs:fit:1200:1200:1/g:ce/aHR0cHM6Ly9pbWFn/ZXMuc2lkZWxpbmVz/d2FwLmNvbS9wcm9k/dWN0aW9uLzAwNi8z/OTQvNTQzLzQyZTUz/YjNiYTNjY2U3ZTNf/b3JpZ2luYWwuanBl/Zw');

INSERT INTO usuarios (username, nombre, paterno, materno, carrera, celular, email, enabled, password, foto, pumapuntos) VALUES ('123456789','Alan','Turing','Mathison','CC', 5556231489,'correo@turing.com',true, '$2a$10$OyAWFIe5lToI9fyST7zmV.3FKYfGbPvvJtRh3jM6U1TYcHaixqJXK', 'https://i.scdn.co/image/ab67616d0000b27386f6c3283b85bf0526229dff', 100);
INSERT INTO usuarios (username, nombre, paterno, materno, carrera, celular, email, enabled, password, foto, pumapuntos) VALUES ('312042513','Augusta','King','-','CC', 5589562341,'correo@lovelace.com',true, '$2a$10$nbcr3bqlvmywtogFL2DPjOq/s69C86OX6N3S0BxZlHOuaV6W1SnbG', 'https://imgs.search.brave.com/uslt8anMySbQ-EWDxCQAq6IhiVkfYAtL_smIGW11Abk/rs:fit:1118:1118:1/g:ce/aHR0cDovL3d3dy5h/bmFycXVpc3RhLm5l/dC93cC1jb250ZW50/L3VwbG9hZHMvMjAx/OC8wMy9hZGEtbG92/ZWxhY2UtcHJpbWVp/cmEtcHJvZ3JhbWFk/b3JhLWRhLW11bmRv/LmpwZw', 150);
INSERT INTO usuarios (username, nombre, paterno, materno, carrera, celular, email, enabled, password, foto, pumapuntos) VALUES ('987654321','Gregor','Mendel','-','BIO', 5566884433,'correo@mendel.com',true, '$2a$10$nbcr3bqlvmywtogFL2DPjOq/s69C86OX6N3S0BxZlHOuaV6W1SnbG', 'https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTgxMTc3NjA0OTQ0OTYyNjQ4/gettyimages-3244238.jpg', 499);

INSERT INTO actividades (id, categoria, nombre, descripcion, recompensa)VALUES ('99999', 'Administrativo', 'Resello Credencial', 'Asistir a Ventanillas a resellar credencial', 10);
INSERT INTO actividades (id, categoria, nombre, descripcion, recompensa)VALUES ('22334', 'Prueba', 'MaximPtos', 'Rompe App', 400);
INSERT INTO actividades (id, categoria, nombre, descripcion, recompensa)VALUES ('12346', 'Administrativo', 'Prestamo Libro', 'Renta de libro dentro de la biblioteca', 20);
INSERT INTO actividades (id, categoria, nombre, descripcion, recompensa)VALUES ('12347', 'Recreativo', 'Conferencia Semanal', 'Conferencia Gravedad Repulsiva', 15);
INSERT INTO actividades (id, categoria, nombre, descripcion, recompensa)VALUES ('11111', 'Recreativo', 'Asistencia Bailongo', 'Asistir al Bailongo FC', 15);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (3, 1);

INSERT INTO rentar (producto_id, usuario_id, fecha_inicio, fechafin) VALUES (1, 2,'2022-12-10','2022-12-24');
INSERT INTO rentar (producto_id, usuario_id, fecha_inicio, fechafin) VALUES (2, 2,'2022-12-01','2022-12-15');
INSERT INTO rentar (producto_id, usuario_id, fecha_inicio, fechafin) VALUES (4, 2,'2022-12-05','2022-12-20');
INSERT INTO rentar (producto_id, usuario_id, fecha_inicio, fechafin) VALUES (2, 1,'2022-12-12','2022-12-24');
INSERT INTO rentar (producto_id, usuario_id, fecha_inicio, fechafin) VALUES (5, 1,'2022-11-30','2022-12-14');
INSERT INTO rentar (producto_id, usuario_id, fecha_inicio, fechafin) VALUES (1, 1,'2022-12-09','2022-12-24');
INSERT INTO rentar (producto_id, usuario_id, fecha_inicio, fechafin) VALUES (2, 3,'2022-11-15','2022-11-29');
INSERT INTO rentar (producto_id, usuario_id, fecha_inicio, fechafin) VALUES (5, 3,'2022-11-28','2022-12-10');
INSERT INTO rentar (producto_id, usuario_id, fecha_inicio, fechafin) VALUES (6, 3,'2022-12-02','2022-12-16');
INSERT INTO rentar (producto_id, usuario_id, fecha_inicio, fechafin) VALUES (6, 3,'2022-12-10','2022-12-24');