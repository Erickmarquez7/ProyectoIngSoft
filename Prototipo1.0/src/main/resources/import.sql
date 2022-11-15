INSERT INTO productos(idproducto, categoria, nombre, descripcion, cantidad, precio, dias) VALUES ('12345','Disco', 'CD José Madero', 'Disco psalmos el mejor perro disco', 100, 250.00, 5 )

INSERT INTO usuarios(nocuenta, contrasena, nombre, paterno, materno, carrera, celular, correo, rol, activo) VALUES ('123456789', 'contrasena', 'nombre', 'paterno', 'materno', 'compu', 5555, 'correo', 1, true)

INSERT INTO rentar(fechainicio, fechafin, nocuenta, idproducto) VALUES('2020-11-12','2021-12-07','123456789','12345')

INSERT INTO pumapuntos(id, saldo, fechavalida, nocuenta) VALUES('58932',200,'2021-12-07','123456789')

