INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Disco', 'Carmesi', 'Amor uwu', 50, 300.00, 5, 'https://i.scdn.co/image/ab67616d0000b273a59d5333ecb0c104538219be');
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Disco', 'Noche', 'Oscuridad', 100, 250.00, 3, 'https://i.scdn.co/image/ab67616d00001e02418b13d6e2851c6a307831b4');
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Disco', 'Alba', 'Nostalgia', 241, 250.00, 3, 'https://i.scdn.co/image/ab67616d00001e022ad8a8dd90be2d65ec430b64');
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Disco', 'Psalmos', 'depresión, ya se quería morir', 7, 400.00, 3, 'https://i.scdn.co/image/ab67616d0000b273c8ffb35bc9a6931a271e2631');
INSERT INTO productos (categoria, nombre, descripcion, cantidad, precio, dias, imagen) VALUES ('Disco', 'Giallo', 'Ya se le quito la depre', 15, 400.00, 3, 'https://i.scdn.co/image/ab67616d00001e02242ad5bbebcb2b2c84625b8e');

INSERT INTO usuarios (username, nombre, paterno, materno, carrera, celular, email, enabled, password, foto) VALUES ('123456789','Alan','Turing','Mathison','Ciencias de la compuación',23061912,'correo@turing.com',true, '$2a$10$OyAWFIe5lToI9fyST7zmV.3FKYfGbPvvJtRh3jM6U1TYcHaixqJXK', 'https://i.scdn.co/image/ab67616d0000b27386f6c3283b85bf0526229dff');
INSERT INTO usuarios (username, nombre, paterno, materno, carrera, celular, email, enabled, password, foto) VALUES ('312042513','Contagiado','anónimo','-','Criminalistica',00000,'correo@anonymous.com',true, '$2a$10$nbcr3bqlvmywtogFL2DPjOq/s69C86OX6N3S0BxZlHOuaV6W1SnbG', 'https://i.scdn.co/image/ab67616d00001e02016f433bf73e57a9eb7f5d70');
INSERT INTO usuarios (username, nombre, paterno, materno, carrera, celular, email, enabled, password, foto) VALUES ('987654321','Fleetwood','Mac','en vivo','Música',1967,'correo@fleet.com',true, '$2a$10$nbcr3bqlvmywtogFL2DPjOq/s69C86OX6N3S0BxZlHOuaV6W1SnbG', 'https://i.scdn.co/image/ab67616d0000b273477cee4d0227e5f23c6095b6');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (3, 1);


INSERT INTO pumapuntos(saldo, fechavalida, id) VALUES(200,'2021-12-07',1);

