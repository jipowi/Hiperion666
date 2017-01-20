--TABLA USUARIO
INSERT INTO USUARIO VALUES (1, 'admin', 'PAUL JIMENEZ','admin', '1719186262', 'A', 'A');
INSERT INTO USUARIO VALUES (2, 'fpozo', 'FRANKLIN POZO','fpozo', '1719186262', 'A', 'A');

-- TABLA DE ROL
INSERT INTO ROL VALUES (1, 1, 'COMERCIAL', 'DEPARTAMENTO COMERCIAL', 'A');

--TABLA MENU
INSERT INTO MENU VALUES (1, NULL, 'CLIENTE', NULL,'A');
INSERT INTO MENU VALUES (2, NULL, 'RAMOS', NULL,'A');
INSERT INTO MENU VALUES (3, NULL, 'ASEGURADORA', NULL,'A');
INSERT INTO MENU VALUES (4, NULL, 'ADMINISTRACION', NULL,'A');
INSERT INTO MENU VALUES (5, NULL, 'CORRESPONDENCIA', NULL,'A');
INSERT INTO MENU VALUES (6, NULL, 'SINIESTROS', NULL,'A');
INSERT INTO MENU VALUES (7, NULL, 'REPORTES', NULL,'A');


INSERT INTO MENU VALUES (11, 2, 'Accidentes Personales', '/pages/accidentesPersonales.jsf','A');
INSERT INTO MENU VALUES (12, 2, 'Agropecuario', '/pages/agropecuario.jsf','A');
INSERT INTO MENU VALUES (13, 2, 'Asistencia Medica', '/pages/asistenciaMedica.jsf','A');
INSERT INTO MENU VALUES (14, 2, 'Buen Uso Anticipo', '/pages/buenUsoAnticipo.jsf','A');
INSERT INTO MENU VALUES (15, 2, 'Buena Calidad de Materiales', '/pages/buenaCalidadMateriales.jsf','A');
INSERT INTO MENU VALUES (16, 2, 'Casco Aereo', '/pages/cascoAereo.jsf','A');
INSERT INTO MENU VALUES (17, 2, 'Casco Maritimo', '/pages/cascoMaritimo.jsf','A');
INSERT INTO MENU VALUES (18, 2, 'Cumplimiento Contrato', '/pages/cumplimientoContrato.jsf','A');
INSERT INTO MENU VALUES (19, 2, 'Dinero Valores', '/pages/dineroValores.jsf','A');
INSERT INTO MENU VALUES (20, 2, 'Equipo Electronico', '/pages/equipoElectronico.jsf','A');
INSERT INTO MENU VALUES (21, 2, 'Equipo Maquinaria', '/pages/equipoMaquinaria.jsf','A');
INSERT INTO MENU VALUES (22, 2, 'Fidelidad', '/pages/fidelidad.jsf','A');
INSERT INTO MENU VALUES (23, 2, 'Garantia Aduanera', '/pages/garantiaAduanera.jsf','A');
INSERT INTO MENU VALUES (24, 2, 'Incendio Lineas Aliadas', '/pages/incendioLineasAliadas.jsf','A');
INSERT INTO MENU VALUES (25, 2, 'Lucro Cesante Rotura Maquinaria', '/pages/lucroCesanteRoturaMaquinaria.jsf','A');
INSERT INTO MENU VALUES (26, 2, 'Lucro Cesante Incendio Lineas Aliadas', '/pages/lucroCesanteIncendioLineasAliadas.jsf','A');
INSERT INTO MENU VALUES (27, 2, 'Responsabilidad Civil', '/pages/responsabilidadCivil.jsf','A');
INSERT INTO MENU VALUES (28, 2, 'Riesgos Especiales', '/pages/riesgosEspeciales.jsf','A');
INSERT INTO MENU VALUES (29, 2, 'Robo Asalto', '/pages/roboAsalto.jsf','A');
INSERT INTO MENU VALUES (30, 2, 'Rotura Maquinaria', '/pages/roturaMaquinaria.jsf','A');
INSERT INTO MENU VALUES (31, 2, 'Soat', '/pages/soat.jsf','A');
INSERT INTO MENU VALUES (32, 2, 'Todo Riesgo Contratista', '/pages/todoRiesgoContratista.jsf','A');
INSERT INTO MENU VALUES (33, 2, 'Todo Riesgo Montaje', '/pages/todoRiesgoMontaje.jsf','A');
INSERT INTO MENU VALUES (34, 2, 'Transporte', '/pages/transporte.jsf','A');
INSERT INTO MENU VALUES (35, 2, 'Vehículos', '/pages/vehiculos.jsf','A');
INSERT INTO MENU VALUES (36, 2, 'vida', '/pages/vida.jsf','A');
INSERT INTO MENU VALUES (37, 1, 'Ingresar Cliente', '/pages/cliente.jsf','A');
INSERT INTO MENU VALUES (38, 3, 'Ingresar Aseguradora', '/pages/aseguradoras.jsf','A');
INSERT INTO MENU VALUES (39, 4, 'Ingresar Usuarios', '/pages/usuarios.jsf','A');
INSERT INTO MENU VALUES (40, 5, 'Enviar correo', '/pages/correspondencia.jsf','A');
INSERT INTO MENU VALUES (41, 6, 'Formulario Vehiculos', '/pages/formSiniestroVehiculos.jsf','A');
INSERT INTO MENU VALUES (42, 7, 'Información Cliente', '/pages/reporteClientes.jsf','A');
INSERT INTO MENU VALUES (43, 7, 'Información Polizas', '/pages/reportePolizas.jsf','A');


INSERT INTO ROL_MENU VALUES (1,1,1);
INSERT INTO ROL_MENU VALUES (2,1,2);
INSERT INTO ROL_MENU VALUES (3,1,3);
INSERT INTO ROL_MENU VALUES (4,1,4);
INSERT INTO ROL_MENU VALUES (5,1,11);
INSERT INTO ROL_MENU VALUES (6,1,12);
INSERT INTO ROL_MENU VALUES (7,1,13);
INSERT INTO ROL_MENU VALUES (8,1,14);
INSERT INTO ROL_MENU VALUES (9,1,15);
INSERT INTO ROL_MENU VALUES (10,1,16);
INSERT INTO ROL_MENU VALUES (11,1,17);
INSERT INTO ROL_MENU VALUES (12,1,18);
INSERT INTO ROL_MENU VALUES (13,1,19);
INSERT INTO ROL_MENU VALUES (14,1,20);
INSERT INTO ROL_MENU VALUES (15,1,21);
INSERT INTO ROL_MENU VALUES (16,1,22);
INSERT INTO ROL_MENU VALUES (17,1,23);
INSERT INTO ROL_MENU VALUES (18,1,24);
INSERT INTO ROL_MENU VALUES (19,1,25);
INSERT INTO ROL_MENU VALUES (20,1,26);
INSERT INTO ROL_MENU VALUES (21,1,27);
INSERT INTO ROL_MENU VALUES (22,1,28);
INSERT INTO ROL_MENU VALUES (23,1,29);
INSERT INTO ROL_MENU VALUES (24,1,30);
INSERT INTO ROL_MENU VALUES (25,1,31);
INSERT INTO ROL_MENU VALUES (26,1,32);
INSERT INTO ROL_MENU VALUES (27,1,33);
INSERT INTO ROL_MENU VALUES (28,1,34);
INSERT INTO ROL_MENU VALUES (29,1,35);
INSERT INTO ROL_MENU VALUES (30,1,36);
INSERT INTO ROL_MENU VALUES (31,1,37);
INSERT INTO ROL_MENU VALUES (32,1,38);
INSERT INTO ROL_MENU VALUES (33,1,39);
INSERT INTO ROL_MENU VALUES (34,1,40);
INSERT INTO ROL_MENU VALUES (35,1,6);
INSERT INTO ROL_MENU VALUES (36,1,41);
INSERT INTO ROL_MENU VALUES (37,1,42);
INSERT INTO ROL_MENU VALUES (38,1,7);
INSERT INTO ROL_MENU VALUES (39,1,43);