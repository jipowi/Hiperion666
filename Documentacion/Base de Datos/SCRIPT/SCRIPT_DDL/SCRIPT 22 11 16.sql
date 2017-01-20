/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     22/11/2016 14:59:43                          */
/*==============================================================*/


/*==============================================================*/
/* Table: ANEXO                                                 */
/*==============================================================*/
create table ANEXO (
   ID_ANEXO             SERIAL               not null,
   NOMBRE_ANEXO         TEXT                 null,
   constraint PK_ANEXO primary key (ID_ANEXO)
);

/*==============================================================*/
/* Index: ANEXO_PK                                              */
/*==============================================================*/
create unique index ANEXO_PK on ANEXO (
ID_ANEXO
);

/*==============================================================*/
/* Table: ARCHIVO_BASE                                          */
/*==============================================================*/
create table ARCHIVO_BASE (
   ID_ARCHIVO           SERIAL               not null,
   ID_AGROPECUARIO      INT4                 null,
   MIME_TYPE            TEXT                 null,
   TIPO_ARCHIVO         TEXT                 null,
   TIPO_DOCUMENTO       TEXT                 null,
   NOMBRE_ARCHIVO       TEXT                 null,
   DOCUMENTO_BYTE       Bytea                null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_ARCHIVO_BASE primary key (ID_ARCHIVO)
);

/*==============================================================*/
/* Index: ARCHIVO_BASE_PK                                       */
/*==============================================================*/
create unique index ARCHIVO_BASE_PK on ARCHIVO_BASE (
ID_ARCHIVO
);

/*==============================================================*/
/* Index: ARCHIVO_BASE_FK                                       */
/*==============================================================*/
create  index ARCHIVO_BASE_FK on ARCHIVO_BASE (
ID_AGROPECUARIO
);

/*==============================================================*/
/* Table: ASEGURADORA                                           */
/*==============================================================*/
create table ASEGURADORA (
   ID_ASEGURADORA       SERIAL               not null,
   CODIGO_ASEGURADORA   TEXT                 null,
   RUC                  TEXT                 null,
   DIRECION             TEXT                 null,
   EMAIL_ASEGURADORA    TEXT                 null,
   TELF_CONVENCIONAL_ASEG TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_ASEGURADORA primary key (ID_ASEGURADORA)
);

/*==============================================================*/
/* Index: ASEGURADORA_PK                                        */
/*==============================================================*/
create unique index ASEGURADORA_PK on ASEGURADORA (
ID_ASEGURADORA
);

/*==============================================================*/
/* Table: BENEFICIARIOS_VIDA                                    */
/*==============================================================*/
create table BENEFICIARIOS_VIDA (
   ID_BENEFICIARIO_VIDA SERIAL               not null,
   ID_MIEMBRRO_VIDA     INT4                 null,
   NOMBRE_BENF_VIDA     TEXT                 null,
   APELLIDO_BENF_VIDA   TEXT                 null,
   EDAD_BENF_VIDA       NUMERIC              null,
   PARENTEZCO_BENF_VIDA TEXT                 null,
   PORCENTEJE_BENF_VIDA DECIMAL              null,
   constraint PK_BENEFICIARIOS_VIDA primary key (ID_BENEFICIARIO_VIDA)
);

/*==============================================================*/
/* Index: BENEFICIARIOS_VIDA_PK                                 */
/*==============================================================*/
create unique index BENEFICIARIOS_VIDA_PK on BENEFICIARIOS_VIDA (
ID_BENEFICIARIO_VIDA
);

/*==============================================================*/
/* Index: BENEFICIARIOS_VIDA_FK                                 */
/*==============================================================*/
create  index BENEFICIARIOS_VIDA_FK on BENEFICIARIOS_VIDA (
ID_MIEMBRRO_VIDA
);

/*==============================================================*/
/* Table: CATALOGO                                              */
/*==============================================================*/
create table CATALOGO (
   ID_CATALOGO          SERIAL               not null,
   DESCRIPCION_CATALOGO TEXT                 null,
   constraint PK_CATALOGO primary key (ID_CATALOGO)
);

/*==============================================================*/
/* Index: CATALOGO_PK                                           */
/*==============================================================*/
create unique index CATALOGO_PK on CATALOGO (
ID_CATALOGO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_ACC_PERS                                */
/*==============================================================*/
create table CLAUSULAS_ADD_ACC_PERS (
   ID_CLAUSULA_AD_ACIDENTE SERIAL               not null,
   ID_ACCIDENTES        INT4                 null,
   CLAUSULA_ACC_PERSONALES TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_ACC_PERS primary key (ID_CLAUSULA_AD_ACIDENTE)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ACC_PERS_PK                             */
/*==============================================================*/
create unique index CLAUSULAS_ADD_ACC_PERS_PK on CLAUSULAS_ADD_ACC_PERS (
ID_CLAUSULA_AD_ACIDENTE
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ACC_PERS_FK                             */
/*==============================================================*/
create  index CLAUSULAS_ADD_ACC_PERS_FK on CLAUSULAS_ADD_ACC_PERS (
ID_ACCIDENTES
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_AGRO                                    */
/*==============================================================*/
create table CLAUSULAS_ADD_AGRO (
   ID_CLAUSULA_AD       SERIAL               not null,
   ID_AGROPECUARIO      INT4                 null,
   CLAUSULA_ADD_AGRO    TEXT                 null,
   NUM_DIAS_AGRO        INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_AGRO primary key (ID_CLAUSULA_AD)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_AGRO_PK                                 */
/*==============================================================*/
create unique index CLAUSULAS_ADD_AGRO_PK on CLAUSULAS_ADD_AGRO (
ID_CLAUSULA_AD
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_AGRO_FK                                 */
/*==============================================================*/
create  index CLAUSULAS_ADD_AGRO_FK on CLAUSULAS_ADD_AGRO (
ID_AGROPECUARIO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_CASCO                                   */
/*==============================================================*/
create table CLAUSULAS_ADD_CASCO (
   ID_CLAUSULA_AD_CASCO SERIAL               not null,
   ID_CASCO             INT4                 null,
   CLAUSULA_ADD_MARITIMO TEXT                 null,
   NUM_DIAS_MARITIMO    INT4                 null,
   ID_USUARIO_CREACION  INT4                 null,
   ID_USUARIO_ACTUALIZACION INT4                 not null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_CASCO primary key (ID_CLAUSULA_AD_CASCO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CASCO_PK                                */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CASCO_PK on CLAUSULAS_ADD_CASCO (
ID_CLAUSULA_AD_CASCO
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CASCO_FK                                */
/*==============================================================*/
create  index CLAUSULAS_ADD_CASCO_FK on CLAUSULAS_ADD_CASCO (
ID_CASCO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_CASCO_AEREO                             */
/*==============================================================*/
create table CLAUSULAS_ADD_CASCO_AEREO (
   ID_CLAUSULA_AD_CASCO_AEREO SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   CLAUSULA_ADD_AEREO   TEXT                 null,
   NUM_DIAS_AEREO       INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_CASCO_AEREO primary key (ID_CLAUSULA_AD_CASCO_AEREO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CASCO_AEREO_PK                          */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CASCO_AEREO_PK on CLAUSULAS_ADD_CASCO_AEREO (
ID_CLAUSULA_AD_CASCO_AEREO
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CASCO_AEREO_FK                          */
/*==============================================================*/
create  index CLAUSULAS_ADD_CASCO_AEREO_FK on CLAUSULAS_ADD_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_CONTRATISTA                             */
/*==============================================================*/
create table CLAUSULAS_ADD_CONTRATISTA (
   ID_CLAUSULA_AD_CONTRATISTA SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   CLAUSULA_ADD_CONTRATISTA TEXT                 null,
   NUM_DIAS_CONTRATISTA INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_CONTRATISTA primary key (ID_CLAUSULA_AD_CONTRATISTA)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CONTRATISTA_PK                          */
/*==============================================================*/
create unique index CLAUSULAS_ADD_CONTRATISTA_PK on CLAUSULAS_ADD_CONTRATISTA (
ID_CLAUSULA_AD_CONTRATISTA
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_CONTRATISTA_FK                          */
/*==============================================================*/
create  index CLAUSULAS_ADD_CONTRATISTA_FK on CLAUSULAS_ADD_CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_DINERO                                  */
/*==============================================================*/
create table CLAUSULAS_ADD_DINERO (
   ID_CLAUSULA_AD_DINERO SERIAL               not null,
   ID_DINERO            INT4                 null,
   CLAUSULA_ADD_DINERO  TEXT                 null,
   NUM_DIAS_DINERO      INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_DINERO primary key (ID_CLAUSULA_AD_DINERO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_DINERO_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_DINERO_PK on CLAUSULAS_ADD_DINERO (
ID_CLAUSULA_AD_DINERO
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_DINERO_FK                               */
/*==============================================================*/
create  index CLAUSULAS_ADD_DINERO_FK on CLAUSULAS_ADD_DINERO (
ID_DINERO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_EQUIPO                                  */
/*==============================================================*/
create table CLAUSULAS_ADD_EQUIPO (
   ID_CLAUSULA_AD_EQUIPO SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   CLAUSULA_EQ_ELEC     TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_EQUIPO primary key (ID_CLAUSULA_AD_EQUIPO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_EQUIPO_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_EQUIPO_PK on CLAUSULAS_ADD_EQUIPO (
ID_CLAUSULA_AD_EQUIPO
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_EQUIPO_FK                               */
/*==============================================================*/
create  index CLAUSULAS_ADD_EQUIPO_FK on CLAUSULAS_ADD_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_EQ_MAQ                                  */
/*==============================================================*/
create table CLAUSULAS_ADD_EQ_MAQ (
   ID_CLAUSULA_AD_EQ_MAQ SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   CLAUSULA_EQ_MAQ      TEXT                 null,
   NUM_DIAS_EQ_MAQ      INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_EQ_MAQ primary key (ID_CLAUSULA_AD_EQ_MAQ)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_EQ_MAQ_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_EQ_MAQ_PK on CLAUSULAS_ADD_EQ_MAQ (
ID_CLAUSULA_AD_EQ_MAQ
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_EQ_MAQ_FK                               */
/*==============================================================*/
create  index CLAUSULAS_ADD_EQ_MAQ_FK on CLAUSULAS_ADD_EQ_MAQ (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_FIDELIDAD                               */
/*==============================================================*/
create table CLAUSULAS_ADD_FIDELIDAD (
   ID_CLAUSULA_AD_FIDELIDAD SERIAL               not null,
   ID_FIDELIDAD         INT4                 null,
   CLAUSULA_FIDELIDAD   TEXT                 null,
   NUMERO_DIAS_FIDELILAD INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_FIDELIDAD primary key (ID_CLAUSULA_AD_FIDELIDAD)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_FIDELIDAD_PK                            */
/*==============================================================*/
create unique index CLAUSULAS_ADD_FIDELIDAD_PK on CLAUSULAS_ADD_FIDELIDAD (
ID_CLAUSULA_AD_FIDELIDAD
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_FIDELIDAD_FK                            */
/*==============================================================*/
create  index CLAUSULAS_ADD_FIDELIDAD_FK on CLAUSULAS_ADD_FIDELIDAD (
ID_FIDELIDAD
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_INCENDIO                                */
/*==============================================================*/
create table CLAUSULAS_ADD_INCENDIO (
   ID_CLAUSULA_AD_INCENDIO SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CLAUSULA_ADD_INCENDIO TEXT                 null,
   NUM_DIAS_INCENDIO    INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_INCENDIO primary key (ID_CLAUSULA_AD_INCENDIO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_INCENDIO_PK                             */
/*==============================================================*/
create unique index CLAUSULAS_ADD_INCENDIO_PK on CLAUSULAS_ADD_INCENDIO (
ID_CLAUSULA_AD_INCENDIO
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_INCENDIO_FK                             */
/*==============================================================*/
create  index CLAUSULAS_ADD_INCENDIO_FK on CLAUSULAS_ADD_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_LC_IN                                   */
/*==============================================================*/
create table CLAUSULAS_ADD_LC_IN (
   ID_CLAUSULA_AD_LUCRO SERIAL               not null,
   ID_LUCRO             INT4                 null,
   CLAUSULA_ADD_LC_INCENDIO TEXT                 null,
   NUM_DIAS_LC_INCENDIO INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_LC_IN primary key (ID_CLAUSULA_AD_LUCRO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_LC_IN_PK                                */
/*==============================================================*/
create unique index CLAUSULAS_ADD_LC_IN_PK on CLAUSULAS_ADD_LC_IN (
ID_CLAUSULA_AD_LUCRO
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_LC_IN_FK                                */
/*==============================================================*/
create  index CLAUSULAS_ADD_LC_IN_FK on CLAUSULAS_ADD_LC_IN (
ID_LUCRO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_MONTAJE                                 */
/*==============================================================*/
create table CLAUSULAS_ADD_MONTAJE (
   ID_CLAUSULA_AD_MONTAJE SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   CLAUSULA_ADD_MONTAJE TEXT                 null,
   NUM_DIAS_MONTAJE     INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_MONTAJE primary key (ID_CLAUSULA_AD_MONTAJE)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_MONTAJE_PK                              */
/*==============================================================*/
create unique index CLAUSULAS_ADD_MONTAJE_PK on CLAUSULAS_ADD_MONTAJE (
ID_CLAUSULA_AD_MONTAJE
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_MONTAJE_FK                              */
/*==============================================================*/
create  index CLAUSULAS_ADD_MONTAJE_FK on CLAUSULAS_ADD_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_RESP                                    */
/*==============================================================*/
create table CLAUSULAS_ADD_RESP (
   ID_CLAUSULA_AD_RESPONSABILIDAD SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   CLAUSULA_RESP        TEXT                 null,
   NUM_DIAS_RESP        INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_RESP primary key (ID_CLAUSULA_AD_RESPONSABILIDAD)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_RESP_PK                                 */
/*==============================================================*/
create unique index CLAUSULAS_ADD_RESP_PK on CLAUSULAS_ADD_RESP (
ID_CLAUSULA_AD_RESPONSABILIDAD
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_RESP_FK                                 */
/*==============================================================*/
create  index CLAUSULAS_ADD_RESP_FK on CLAUSULAS_ADD_RESP (
ID_RESPONSABILIDAD
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_RIESGOS                                 */
/*==============================================================*/
create table CLAUSULAS_ADD_RIESGOS (
   ID_CLAUSULA_AD_RIESGOS SERIAL               not null,
   ID_RIESGO            INT4                 null,
   CLAUSULA_ADD_RIESGOS TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_RIESGOS primary key (ID_CLAUSULA_AD_RIESGOS)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_RIESGOS_PK                              */
/*==============================================================*/
create unique index CLAUSULAS_ADD_RIESGOS_PK on CLAUSULAS_ADD_RIESGOS (
ID_CLAUSULA_AD_RIESGOS
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_RIESGOS_FK                              */
/*==============================================================*/
create  index CLAUSULAS_ADD_RIESGOS_FK on CLAUSULAS_ADD_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_ROBO                                    */
/*==============================================================*/
create table CLAUSULAS_ADD_ROBO (
   ID_CLAUSULA_AD_ROBO  SERIAL               not null,
   ID_ROBO              INT4                 null,
   CLAUSULA_ADD_ROBO    TEXT                 null,
   NUM_DIAS_ROBO        INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_ROBO primary key (ID_CLAUSULA_AD_ROBO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ROBO_PK                                 */
/*==============================================================*/
create unique index CLAUSULAS_ADD_ROBO_PK on CLAUSULAS_ADD_ROBO (
ID_CLAUSULA_AD_ROBO
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ROBO_FK                                 */
/*==============================================================*/
create  index CLAUSULAS_ADD_ROBO_FK on CLAUSULAS_ADD_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_ROTURA                                  */
/*==============================================================*/
create table CLAUSULAS_ADD_ROTURA (
   ID_CLAUSULA_AD_ROTURA SERIAL               not null,
   ID_ROTURA            INT4                 null,
   CLAUSULA_ADD_ROTURA  TEXT                 null,
   NUM_DIAS_ROTURA      INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_ROTURA primary key (ID_CLAUSULA_AD_ROTURA)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ROTURA_PK                               */
/*==============================================================*/
create unique index CLAUSULAS_ADD_ROTURA_PK on CLAUSULAS_ADD_ROTURA (
ID_CLAUSULA_AD_ROTURA
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_ROTURA_FK                               */
/*==============================================================*/
create  index CLAUSULAS_ADD_ROTURA_FK on CLAUSULAS_ADD_ROTURA (
ID_ROTURA
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_TRANS                                   */
/*==============================================================*/
create table CLAUSULAS_ADD_TRANS (
   ID_CLAUSULA_AD_TRANSPORTE SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   CLAUSULA_TRANS       TEXT                 null,
   NUM_DIAS_TRANS       INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_TRANS primary key (ID_CLAUSULA_AD_TRANSPORTE)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_TRANS_PK                                */
/*==============================================================*/
create unique index CLAUSULAS_ADD_TRANS_PK on CLAUSULAS_ADD_TRANS (
ID_CLAUSULA_AD_TRANSPORTE
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_TRANS_FK                                */
/*==============================================================*/
create  index CLAUSULAS_ADD_TRANS_FK on CLAUSULAS_ADD_TRANS (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: CLAUSULAS_ADD_VH                                      */
/*==============================================================*/
create table CLAUSULAS_ADD_VH (
   ID_CLAUSULA_AD_VEHICULO SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   CLAUSULA_ADD_VH      TEXT                 null,
   NUM_DIAS_VH          INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLAUSULAS_ADD_VH primary key (ID_CLAUSULA_AD_VEHICULO)
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_VH_PK                                   */
/*==============================================================*/
create unique index CLAUSULAS_ADD_VH_PK on CLAUSULAS_ADD_VH (
ID_CLAUSULA_AD_VEHICULO
);

/*==============================================================*/
/* Index: CLAUSULAS_ADD_VH_FK                                   */
/*==============================================================*/
create  index CLAUSULAS_ADD_VH_FK on CLAUSULAS_ADD_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: CLA_ADD_LC_ROT                                        */
/*==============================================================*/
create table CLA_ADD_LC_ROT (
   ID_CLAUSULA_AD_CESANTE SERIAL               not null,
   ID_CESANTE           INT4                 null,
   CLAUSULA_ADD_LC_ROTURA TEXT                 null,
   NUM_DIAS_CLA_LC_ROTURA INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLA_ADD_LC_ROT primary key (ID_CLAUSULA_AD_CESANTE)
);

/*==============================================================*/
/* Index: CLA_ADD_LC_ROT_PK                                     */
/*==============================================================*/
create unique index CLA_ADD_LC_ROT_PK on CLA_ADD_LC_ROT (
ID_CLAUSULA_AD_CESANTE
);

/*==============================================================*/
/* Index: CLA_ADD_LC_ROT_FK                                     */
/*==============================================================*/
create  index CLA_ADD_LC_ROT_FK on CLA_ADD_LC_ROT (
ID_CESANTE
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   ID_CLIENTE           SERIAL               not null,
   ID_ASEGURADORA       INT4                 null,
   CODIGO_CLIENTE       TEXT                 null,
   TIPO_PERSONA         TEXT                 null,
   TIPO_IDENTIFICACION  TEXT                 null,
   IDENTIFICACION_PERSONA TEXT                 null,
   NOMBRE_PERSONA       TEXT                 null,
   APELLIDO_PATERNO     TEXT                 null,
   APELLIDO_MATERNO     TEXT                 null,
   ACTIVIDAD_PROFESION  TEXT                 null,
   RAZON_SOCIAL         TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_CLIENTE primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Index: CLIENTE_PK                                            */
/*==============================================================*/
create unique index CLIENTE_PK on CLIENTE (
ID_CLIENTE
);

/*==============================================================*/
/* Index: CLIENTE_FK                                            */
/*==============================================================*/
create  index CLIENTE_FK on CLIENTE (
ID_ASEGURADORA
);

/*==============================================================*/
/* Table: COBERTURA_ROBO                                        */
/*==============================================================*/
create table COBERTURA_ROBO (
   ID_COBERT_ROBO       SERIAL               not null,
   ID_ROBO              INT4                 null,
   COBERTURA_ROBO       TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERTURA_ROBO primary key (ID_COBERT_ROBO)
);

/*==============================================================*/
/* Index: COBERTURA_ROBO_PK                                     */
/*==============================================================*/
create unique index COBERTURA_ROBO_PK on COBERTURA_ROBO (
ID_COBERT_ROBO
);

/*==============================================================*/
/* Index: COBERTURA_ROBO_FK                                     */
/*==============================================================*/
create  index COBERTURA_ROBO_FK on COBERTURA_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: COBERT_ACC_PER                                        */
/*==============================================================*/
create table COBERT_ACC_PER (
   ID_COBERTURA         SERIAL               not null,
   ID_ACCIDENTES        INT4                 null,
   COBERTURA_ACC_PERSONALES TEXT                 null,
   constraint PK_COBERT_ACC_PER primary key (ID_COBERTURA)
);

/*==============================================================*/
/* Index: COBERT_ACC_PER_PK                                     */
/*==============================================================*/
create unique index COBERT_ACC_PER_PK on COBERT_ACC_PER (
ID_COBERTURA
);

/*==============================================================*/
/* Index: COBERT_ACC_PER_FK                                     */
/*==============================================================*/
create  index COBERT_ACC_PER_FK on COBERT_ACC_PER (
ID_ACCIDENTES
);

/*==============================================================*/
/* Table: COBERT_ADD_CASCO                                      */
/*==============================================================*/
create table COBERT_ADD_CASCO (
   ID_COBERT_AD_CASCO   SERIAL               not null,
   ID_CASCO             INT4                 null,
   COBERTURA_CASCO      TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ADD_CASCO primary key (ID_COBERT_AD_CASCO)
);

/*==============================================================*/
/* Index: COBERT_ADD_CASCO_PK                                   */
/*==============================================================*/
create unique index COBERT_ADD_CASCO_PK on COBERT_ADD_CASCO (
ID_COBERT_AD_CASCO
);

/*==============================================================*/
/* Index: COBERT_ADD_CASCO_FK                                   */
/*==============================================================*/
create  index COBERT_ADD_CASCO_FK on COBERT_ADD_CASCO (
ID_CASCO
);

/*==============================================================*/
/* Table: COBERT_ADD_CASCO_AEREO                                */
/*==============================================================*/
create table COBERT_ADD_CASCO_AEREO (
   ID_COBERT_AD_CASCO_AEREO SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   COBERTURA_ADD_CASCO_EREO TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ADD_CASCO_AEREO primary key (ID_COBERT_AD_CASCO_AEREO)
);

/*==============================================================*/
/* Index: COBERT_ADD_CASCO_AEREO_PK                             */
/*==============================================================*/
create unique index COBERT_ADD_CASCO_AEREO_PK on COBERT_ADD_CASCO_AEREO (
ID_COBERT_AD_CASCO_AEREO
);

/*==============================================================*/
/* Index: COBERT_ADD_CASCO_AEREO_FK                             */
/*==============================================================*/
create  index COBERT_ADD_CASCO_AEREO_FK on COBERT_ADD_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Table: COBERT_ADD_EQUIPO                                     */
/*==============================================================*/
create table COBERT_ADD_EQUIPO (
   ID_COBERT_AD_EQUIPO  SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   COBERTURA_ADD_EQ_ELEC TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ADD_EQUIPO primary key (ID_COBERT_AD_EQUIPO)
);

/*==============================================================*/
/* Index: COBERT_ADD_EQUIPO_PK                                  */
/*==============================================================*/
create unique index COBERT_ADD_EQUIPO_PK on COBERT_ADD_EQUIPO (
ID_COBERT_AD_EQUIPO
);

/*==============================================================*/
/* Index: COBERT_ADD_EQUIPO_FK                                  */
/*==============================================================*/
create  index COBERT_ADD_EQUIPO_FK on COBERT_ADD_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: COBERT_ADD_EQ_MAQ                                     */
/*==============================================================*/
create table COBERT_ADD_EQ_MAQ (
   ID_COBERT_AD_EQ_MAQ  SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   COBERTURA_ADD_EQ_MAQ TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ADD_EQ_MAQ primary key (ID_COBERT_AD_EQ_MAQ)
);

/*==============================================================*/
/* Index: COBERT_ADD_EQ_MAQ_PK                                  */
/*==============================================================*/
create unique index COBERT_ADD_EQ_MAQ_PK on COBERT_ADD_EQ_MAQ (
ID_COBERT_AD_EQ_MAQ
);

/*==============================================================*/
/* Index: COBERT_ADD_EQ_MAQ_FK                                  */
/*==============================================================*/
create  index COBERT_ADD_EQ_MAQ_FK on COBERT_ADD_EQ_MAQ (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Table: COBERT_ADD_INCENDIO                                   */
/*==============================================================*/
create table COBERT_ADD_INCENDIO (
   ID_COBERT_AD_RAMO_INC SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   COBERTURA_ADD_INCENDIO TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ADD_INCENDIO primary key (ID_COBERT_AD_RAMO_INC)
);

/*==============================================================*/
/* Index: COBERT_ADD_INCENDIO_PK                                */
/*==============================================================*/
create unique index COBERT_ADD_INCENDIO_PK on COBERT_ADD_INCENDIO (
ID_COBERT_AD_RAMO_INC
);

/*==============================================================*/
/* Index: COBERT_ADD_INCENDIO_FK                                */
/*==============================================================*/
create  index COBERT_ADD_INCENDIO_FK on COBERT_ADD_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: COBERT_ADD_LC_ROT                                     */
/*==============================================================*/
create table COBERT_ADD_LC_ROT (
   ID_COBERT_AD_CESANTE SERIAL               not null,
   ID_CESANTE           INT4                 null,
   COBERTURA_ADD_LC_ROTURA TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ADD_LC_ROT primary key (ID_COBERT_AD_CESANTE)
);

/*==============================================================*/
/* Index: COBERT_ADD_LC_ROT_PK                                  */
/*==============================================================*/
create unique index COBERT_ADD_LC_ROT_PK on COBERT_ADD_LC_ROT (
ID_COBERT_AD_CESANTE
);

/*==============================================================*/
/* Index: COBERT_ADD_LC_ROT_FK                                  */
/*==============================================================*/
create  index COBERT_ADD_LC_ROT_FK on COBERT_ADD_LC_ROT (
ID_CESANTE
);

/*==============================================================*/
/* Table: COBERT_ADD_RIESGOS                                    */
/*==============================================================*/
create table COBERT_ADD_RIESGOS (
   ID_COBERT_AD_RIESGOS SERIAL               not null,
   ID_RIESGO            INT4                 null,
   COBERTURA_ADD_RIESGOS TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ADD_RIESGOS primary key (ID_COBERT_AD_RIESGOS)
);

/*==============================================================*/
/* Index: COBERT_ADD_RIESGOS_PK                                 */
/*==============================================================*/
create unique index COBERT_ADD_RIESGOS_PK on COBERT_ADD_RIESGOS (
ID_COBERT_AD_RIESGOS
);

/*==============================================================*/
/* Index: COBERT_ADD_RIESGOS_FK                                 */
/*==============================================================*/
create  index COBERT_ADD_RIESGOS_FK on COBERT_ADD_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: COBERT_ADD_ROBO                                       */
/*==============================================================*/
create table COBERT_ADD_ROBO (
   ID_COBERT_AD_ROBO    SERIAL               not null,
   ID_ROBO              INT4                 null,
   COBERTURA_ADD_ROBO   TEXT                 null,
   VALOR_COB_ADD_ROBO   DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ADD_ROBO primary key (ID_COBERT_AD_ROBO)
);

/*==============================================================*/
/* Index: COBERT_ADD_ROBO_PK                                    */
/*==============================================================*/
create unique index COBERT_ADD_ROBO_PK on COBERT_ADD_ROBO (
ID_COBERT_AD_ROBO
);

/*==============================================================*/
/* Index: COBERT_ADD_ROBO_FK                                    */
/*==============================================================*/
create  index COBERT_ADD_ROBO_FK on COBERT_ADD_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: COBERT_ADD_ROTURA                                     */
/*==============================================================*/
create table COBERT_ADD_ROTURA (
   ID_COBERT_AD_ROTURA  SERIAL               not null,
   ID_ROTURA            INT4                 null,
   COBERTURA_ADD_ROTURA TEXT                 null,
   VALOR_COB_ROTURA     DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ADD_ROTURA primary key (ID_COBERT_AD_ROTURA)
);

/*==============================================================*/
/* Index: COBERT_ADD_ROTURA_PK                                  */
/*==============================================================*/
create unique index COBERT_ADD_ROTURA_PK on COBERT_ADD_ROTURA (
ID_COBERT_AD_ROTURA
);

/*==============================================================*/
/* Index: COBERT_ADD_ROTURA_FK                                  */
/*==============================================================*/
create  index COBERT_ADD_ROTURA_FK on COBERT_ADD_ROTURA (
ID_ROTURA
);

/*==============================================================*/
/* Table: COBERT_ADUANERA                                       */
/*==============================================================*/
create table COBERT_ADUANERA (
   ID_COBERT_ADUANERA   SERIAL               not null,
   ID_ADUANERA          INT4                 null,
   COBERTURA_ADUANERA   TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ADUANERA primary key (ID_COBERT_ADUANERA)
);

/*==============================================================*/
/* Index: COBERT_ADUANERA_PK                                    */
/*==============================================================*/
create unique index COBERT_ADUANERA_PK on COBERT_ADUANERA (
ID_COBERT_ADUANERA
);

/*==============================================================*/
/* Index: COBERT_ADUANERA_FK                                    */
/*==============================================================*/
create  index COBERT_ADUANERA_FK on COBERT_ADUANERA (
ID_ADUANERA
);

/*==============================================================*/
/* Table: COBERT_AGRO                                           */
/*==============================================================*/
create table COBERT_AGRO (
   ID_COBERT_AGRO       SERIAL               not null,
   ID_AGROPECUARIO      INT4                 null,
   COBERTURA_AGRO       TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   TIPO_COBERTURA_AGRO  TEXT                 null,
   constraint PK_COBERT_AGRO primary key (ID_COBERT_AGRO)
);

/*==============================================================*/
/* Index: COBERT_AGRO_PK                                        */
/*==============================================================*/
create unique index COBERT_AGRO_PK on COBERT_AGRO (
ID_COBERT_AGRO
);

/*==============================================================*/
/* Index: COBERT_AGRO_FK                                        */
/*==============================================================*/
create  index COBERT_AGRO_FK on COBERT_AGRO (
ID_AGROPECUARIO
);

/*==============================================================*/
/* Table: COBERT_BUEN_USO_ANT                                   */
/*==============================================================*/
create table COBERT_BUEN_USO_ANT (
   ID_COBERT_BUEN_USO_ANT SERIAL               not null,
   IND_BUEN_USO_ANT     INT4                 null,
   COBERTURA_ANTICIPO   TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_BUEN_USO_ANT primary key (ID_COBERT_BUEN_USO_ANT)
);

/*==============================================================*/
/* Index: COBERT_BUEN_USO_ANT_PK                                */
/*==============================================================*/
create unique index COBERT_BUEN_USO_ANT_PK on COBERT_BUEN_USO_ANT (
ID_COBERT_BUEN_USO_ANT
);

/*==============================================================*/
/* Index: COBERT_BUEN_USO_ANT_FK                                */
/*==============================================================*/
create  index COBERT_BUEN_USO_ANT_FK on COBERT_BUEN_USO_ANT (
IND_BUEN_USO_ANT
);

/*==============================================================*/
/* Table: COBERT_CASCO_AEREO                                    */
/*==============================================================*/
create table COBERT_CASCO_AEREO (
   ID_COBERT_AEREO      SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   COBERTURA_AEREO      TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_CASCO_AEREO primary key (ID_COBERT_AEREO)
);

/*==============================================================*/
/* Index: COBERT_CASCO_AEREO_PK                                 */
/*==============================================================*/
create unique index COBERT_CASCO_AEREO_PK on COBERT_CASCO_AEREO (
ID_COBERT_AEREO
);

/*==============================================================*/
/* Index: COBERT_CASCO_AEREO_FK                                 */
/*==============================================================*/
create  index COBERT_CASCO_AEREO_FK on COBERT_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Table: COBERT_CONTRATISTA                                    */
/*==============================================================*/
create table COBERT_CONTRATISTA (
   ID_COBERT_CONTRATISTA SERIAL               not null,
   ID_CONTRATISTA       INT4                 null,
   COBERTURA_CONTRATISTA TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_CONTRATISTA primary key (ID_COBERT_CONTRATISTA)
);

/*==============================================================*/
/* Index: COBERT_CONTRATISTA_PK                                 */
/*==============================================================*/
create unique index COBERT_CONTRATISTA_PK on COBERT_CONTRATISTA (
ID_COBERT_CONTRATISTA
);

/*==============================================================*/
/* Index: COBERT_CONTRATISTA_FK                                 */
/*==============================================================*/
create  index COBERT_CONTRATISTA_FK on COBERT_CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Table: COBERT_CONTRATO                                       */
/*==============================================================*/
create table COBERT_CONTRATO (
   ID_COBERT_CONTRATO   SERIAL               not null,
   ID_CONTRATO          INT4                 null,
   COBERTURA_CONTRATO   TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_CONTRATO primary key (ID_COBERT_CONTRATO)
);

/*==============================================================*/
/* Index: COBERT_CONTRATO_PK                                    */
/*==============================================================*/
create unique index COBERT_CONTRATO_PK on COBERT_CONTRATO (
ID_COBERT_CONTRATO
);

/*==============================================================*/
/* Index: COBERT_CONTRATO_FK                                    */
/*==============================================================*/
create  index COBERT_CONTRATO_FK on COBERT_CONTRATO (
ID_CONTRATO
);

/*==============================================================*/
/* Table: COBERT_DINERO_VAL                                     */
/*==============================================================*/
create table COBERT_DINERO_VAL (
   ID_COBERT_DINERO_VALORES SERIAL               not null,
   ID_DINERO            INT4                 null,
   COBERTURA_DINERO     TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_DINERO_VAL primary key (ID_COBERT_DINERO_VALORES)
);

/*==============================================================*/
/* Index: COBERT_DINERO_VAL_PK                                  */
/*==============================================================*/
create unique index COBERT_DINERO_VAL_PK on COBERT_DINERO_VAL (
ID_COBERT_DINERO_VALORES
);

/*==============================================================*/
/* Index: COBERT_DINERO_VAL_FK                                  */
/*==============================================================*/
create  index COBERT_DINERO_VAL_FK on COBERT_DINERO_VAL (
ID_DINERO
);

/*==============================================================*/
/* Table: COBERT_EQUIPO                                         */
/*==============================================================*/
create table COBERT_EQUIPO (
   ID_COBERT_EQUIPO     SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   COBERTURA_EQ_ELEC    TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_EQUIPO primary key (ID_COBERT_EQUIPO)
);

/*==============================================================*/
/* Index: COBERT_EQUIPO_PK                                      */
/*==============================================================*/
create unique index COBERT_EQUIPO_PK on COBERT_EQUIPO (
ID_COBERT_EQUIPO
);

/*==============================================================*/
/* Index: COBERT_EQUIPO_FK                                      */
/*==============================================================*/
create  index COBERT_EQUIPO_FK on COBERT_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: COBERT_EQ_MAQ                                         */
/*==============================================================*/
create table COBERT_EQ_MAQ (
   ID_COBERT_EQ_MAQ     SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   COBERTURA_EQ_MAQ     TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_EQ_MAQ primary key (ID_COBERT_EQ_MAQ)
);

/*==============================================================*/
/* Index: COBERT_EQ_MAQ_PK                                      */
/*==============================================================*/
create unique index COBERT_EQ_MAQ_PK on COBERT_EQ_MAQ (
ID_COBERT_EQ_MAQ
);

/*==============================================================*/
/* Index: COBERT_EQ_MAQ_FK                                      */
/*==============================================================*/
create  index COBERT_EQ_MAQ_FK on COBERT_EQ_MAQ (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Table: COBERT_FIDELIDAD                                      */
/*==============================================================*/
create table COBERT_FIDELIDAD (
   ID_COBERT_FIDELIDAD  SERIAL               not null,
   ID_FIDELIDAD         INT4                 null,
   COBERTURA_FIDELIDAD  TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_FIDELIDAD primary key (ID_COBERT_FIDELIDAD)
);

/*==============================================================*/
/* Index: COBERT_FIDELIDAD_PK                                   */
/*==============================================================*/
create unique index COBERT_FIDELIDAD_PK on COBERT_FIDELIDAD (
ID_COBERT_FIDELIDAD
);

/*==============================================================*/
/* Index: COBERT_FIDELIDAD_FK                                   */
/*==============================================================*/
create  index COBERT_FIDELIDAD_FK on COBERT_FIDELIDAD (
ID_FIDELIDAD
);

/*==============================================================*/
/* Table: COBERT_INCENDIO                                       */
/*==============================================================*/
create table COBERT_INCENDIO (
   ID_COBERT_INCENDIO   SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   COBERTURA_INCENDIO   TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_INCENDIO primary key (ID_COBERT_INCENDIO)
);

/*==============================================================*/
/* Index: COBERT_INCENDIO_PK                                    */
/*==============================================================*/
create unique index COBERT_INCENDIO_PK on COBERT_INCENDIO (
ID_COBERT_INCENDIO
);

/*==============================================================*/
/* Index: COBERT_INCENDIO_FK                                    */
/*==============================================================*/
create  index COBERT_INCENDIO_FK on COBERT_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: COBERT_LC_IN                                          */
/*==============================================================*/
create table COBERT_LC_IN (
   ID_COBERT_LUCRO      SERIAL               not null,
   ID_LUCRO             INT4                 null,
   COBERTURA_LC_INCENDIO TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_LC_IN primary key (ID_COBERT_LUCRO)
);

/*==============================================================*/
/* Index: COBERT_LC_IN_PK                                       */
/*==============================================================*/
create unique index COBERT_LC_IN_PK on COBERT_LC_IN (
ID_COBERT_LUCRO
);

/*==============================================================*/
/* Index: COBERT_LC_IN_FK                                       */
/*==============================================================*/
create  index COBERT_LC_IN_FK on COBERT_LC_IN (
ID_LUCRO
);

/*==============================================================*/
/* Table: COBERT_LC_ROT                                         */
/*==============================================================*/
create table COBERT_LC_ROT (
   ID_COBERT_CESANTE    SERIAL               not null,
   ID_CESANTE           INT4                 null,
   COBERTURA_LC_ROTURA  TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_LC_ROT primary key (ID_COBERT_CESANTE)
);

/*==============================================================*/
/* Index: COBERT_LC_ROT_PK                                      */
/*==============================================================*/
create unique index COBERT_LC_ROT_PK on COBERT_LC_ROT (
ID_COBERT_CESANTE
);

/*==============================================================*/
/* Index: COBERT_LC_ROT_FK                                      */
/*==============================================================*/
create  index COBERT_LC_ROT_FK on COBERT_LC_ROT (
ID_CESANTE
);

/*==============================================================*/
/* Table: COBERT_MATERIALES                                     */
/*==============================================================*/
create table COBERT_MATERIALES (
   ID_COBERT_MATERIALES SERIAL               not null,
   ID_MATERIAL          INT4                 null,
   COBERTURA_MATERIALES TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_MATERIALES primary key (ID_COBERT_MATERIALES)
);

/*==============================================================*/
/* Index: COBERT_MATERIALES_PK                                  */
/*==============================================================*/
create unique index COBERT_MATERIALES_PK on COBERT_MATERIALES (
ID_COBERT_MATERIALES
);

/*==============================================================*/
/* Index: COBERT_MATERIALES_FK                                  */
/*==============================================================*/
create  index COBERT_MATERIALES_FK on COBERT_MATERIALES (
ID_MATERIAL
);

/*==============================================================*/
/* Table: COBERT_MONTAJE                                        */
/*==============================================================*/
create table COBERT_MONTAJE (
   ID_COBERT_MONTAJE    SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   COBERTURA_MONTAJE    TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_MONTAJE primary key (ID_COBERT_MONTAJE)
);

/*==============================================================*/
/* Index: COBERT_MONTAJE_PK                                     */
/*==============================================================*/
create unique index COBERT_MONTAJE_PK on COBERT_MONTAJE (
ID_COBERT_MONTAJE
);

/*==============================================================*/
/* Index: COBERT_MONTAJE_FK                                     */
/*==============================================================*/
create  index COBERT_MONTAJE_FK on COBERT_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Table: COBERT_RESP                                           */
/*==============================================================*/
create table COBERT_RESP (
   ID_COBERT_RESPONSABILIDAD SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   COBERTURA_RESP       TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_RESP primary key (ID_COBERT_RESPONSABILIDAD)
);

/*==============================================================*/
/* Index: COBERT_RESP_PK                                        */
/*==============================================================*/
create unique index COBERT_RESP_PK on COBERT_RESP (
ID_COBERT_RESPONSABILIDAD
);

/*==============================================================*/
/* Index: COBERT_RESP_FK                                        */
/*==============================================================*/
create  index COBERT_RESP_FK on COBERT_RESP (
ID_RESPONSABILIDAD
);

/*==============================================================*/
/* Table: COBERT_RIESGOS                                        */
/*==============================================================*/
create table COBERT_RIESGOS (
   ID_COBERT_RIESGOS    SERIAL               not null,
   ID_RIESGO            INT4                 null,
   COBERTURA_RIESGOS    TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_RIESGOS primary key (ID_COBERT_RIESGOS)
);

/*==============================================================*/
/* Index: COBERT_RIESGOS_PK                                     */
/*==============================================================*/
create unique index COBERT_RIESGOS_PK on COBERT_RIESGOS (
ID_COBERT_RIESGOS
);

/*==============================================================*/
/* Index: COBERT_RIESGOS_FK                                     */
/*==============================================================*/
create  index COBERT_RIESGOS_FK on COBERT_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: COBERT_ROTURA                                         */
/*==============================================================*/
create table COBERT_ROTURA (
   ID_COBERT_ROTURA     SERIAL               not null,
   ID_ROTURA            INT4                 null,
   COBERTURA_ROTURA     TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_ROTURA primary key (ID_COBERT_ROTURA)
);

/*==============================================================*/
/* Index: COBERT_ROTURA_PK                                      */
/*==============================================================*/
create unique index COBERT_ROTURA_PK on COBERT_ROTURA (
ID_COBERT_ROTURA
);

/*==============================================================*/
/* Index: COBERT_ROTURA_FK                                      */
/*==============================================================*/
create  index COBERT_ROTURA_FK on COBERT_ROTURA (
ID_ROTURA
);

/*==============================================================*/
/* Table: COBERT_SOAT                                           */
/*==============================================================*/
create table COBERT_SOAT (
   ID_COBERT_SOAT       SERIAL               not null,
   ID_SOAT              INT4                 null,
   COBERTURA_SOAT       TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_SOAT primary key (ID_COBERT_SOAT)
);

/*==============================================================*/
/* Index: COBERT_SOAT_PK                                        */
/*==============================================================*/
create unique index COBERT_SOAT_PK on COBERT_SOAT (
ID_COBERT_SOAT
);

/*==============================================================*/
/* Index: COBERT_SOAT_FK                                        */
/*==============================================================*/
create  index COBERT_SOAT_FK on COBERT_SOAT (
ID_SOAT
);

/*==============================================================*/
/* Table: COBERT_TRANS                                          */
/*==============================================================*/
create table COBERT_TRANS (
   ID_COBERT_TRANSPORTE SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   COBERTURA_TRANSPORTE TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COBERT_TRANS primary key (ID_COBERT_TRANSPORTE)
);

/*==============================================================*/
/* Index: COBERT_TRANS_PK                                       */
/*==============================================================*/
create unique index COBERT_TRANS_PK on COBERT_TRANS (
ID_COBERT_TRANSPORTE
);

/*==============================================================*/
/* Index: COBERT_TRANS_FK                                       */
/*==============================================================*/
create  index COBERT_TRANS_FK on COBERT_TRANS (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: COND_ESP_ACC_PERS                                     */
/*==============================================================*/
create table COND_ESP_ACC_PERS (
   ID_CONDICION_ESP_ACC SERIAL               not null,
   ID_ACCIDENTES        INT4                 null,
   CONDICION_ACC        TEXT                 null,
   constraint PK_COND_ESP_ACC_PERS primary key (ID_CONDICION_ESP_ACC)
);

/*==============================================================*/
/* Index: COND_ESP_ACC_PERS_PK                                  */
/*==============================================================*/
create unique index COND_ESP_ACC_PERS_PK on COND_ESP_ACC_PERS (
ID_CONDICION_ESP_ACC
);

/*==============================================================*/
/* Index: COND_ESP_ACC_PERS_FK                                  */
/*==============================================================*/
create  index COND_ESP_ACC_PERS_FK on COND_ESP_ACC_PERS (
ID_ACCIDENTES
);

/*==============================================================*/
/* Table: COND_ESP_INCENDIO                                     */
/*==============================================================*/
create table COND_ESP_INCENDIO (
   ID_CONDICION_ESP_INCENDIO SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   CONDICION_ESP_INCENDIO TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COND_ESP_INCENDIO primary key (ID_CONDICION_ESP_INCENDIO)
);

/*==============================================================*/
/* Index: COND_ESP_INCENDIO_PK                                  */
/*==============================================================*/
create unique index COND_ESP_INCENDIO_PK on COND_ESP_INCENDIO (
ID_CONDICION_ESP_INCENDIO
);

/*==============================================================*/
/* Index: COND_ESP_INCENDIO_FK                                  */
/*==============================================================*/
create  index COND_ESP_INCENDIO_FK on COND_ESP_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: COND_ESP_RIESGOS                                      */
/*==============================================================*/
create table COND_ESP_RIESGOS (
   ID_COND_ESP_RIESGOS  SERIAL               not null,
   ID_RIESGO            INT4                 null,
   CONDICION_ESP_RIESGOS TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COND_ESP_RIESGOS primary key (ID_COND_ESP_RIESGOS)
);

/*==============================================================*/
/* Index: COND_ESP_RIESGOS_PK                                   */
/*==============================================================*/
create unique index COND_ESP_RIESGOS_PK on COND_ESP_RIESGOS (
ID_COND_ESP_RIESGOS
);

/*==============================================================*/
/* Index: COND_ESP_RIESGOS_FK                                   */
/*==============================================================*/
create  index COND_ESP_RIESGOS_FK on COND_ESP_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: COND_ESP_ROBO                                         */
/*==============================================================*/
create table COND_ESP_ROBO (
   ID_COND_ESP_ROBO     SERIAL               not null,
   ID_ROBO              INT4                 null,
   CONDICION_ESP_ROBO   TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COND_ESP_ROBO primary key (ID_COND_ESP_ROBO)
);

/*==============================================================*/
/* Index: COND_ESP_ROBO_PK                                      */
/*==============================================================*/
create unique index COND_ESP_ROBO_PK on COND_ESP_ROBO (
ID_COND_ESP_ROBO
);

/*==============================================================*/
/* Index: COND_ESP_ROBO_FK                                      */
/*==============================================================*/
create  index COND_ESP_ROBO_FK on COND_ESP_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: COND_ESP_TRANS                                        */
/*==============================================================*/
create table COND_ESP_TRANS (
   ID_CONDICION_ESP_TRANSPORTE SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   DESCRIPCION_COND_ESP_TRANS TEXT                 null,
   CONDICION_ESP_TRANS  TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COND_ESP_TRANS primary key (ID_CONDICION_ESP_TRANSPORTE)
);

/*==============================================================*/
/* Index: COND_ESP_TRANS_PK                                     */
/*==============================================================*/
create unique index COND_ESP_TRANS_PK on COND_ESP_TRANS (
ID_CONDICION_ESP_TRANSPORTE
);

/*==============================================================*/
/* Index: COND_ESP_TRANS_FK                                     */
/*==============================================================*/
create  index COND_ESP_TRANS_FK on COND_ESP_TRANS (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: COND_ESP_VH                                           */
/*==============================================================*/
create table COND_ESP_VH (
   ID_CONDICION_ESP_VEHICULO SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   CONDICION_ESP_VH     TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COND_ESP_VH primary key (ID_CONDICION_ESP_VEHICULO)
);

/*==============================================================*/
/* Index: COND_ESP_VH_PK                                        */
/*==============================================================*/
create unique index COND_ESP_VH_PK on COND_ESP_VH (
ID_CONDICION_ESP_VEHICULO
);

/*==============================================================*/
/* Index: COND_ESP_VH_FK                                        */
/*==============================================================*/
create  index COND_ESP_VH_FK on COND_ESP_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: COND_PART_ASM                                         */
/*==============================================================*/
create table COND_PART_ASM (
   ID_COND_PART_ASM     SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   CONDICION_PART_ASM   TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COND_PART_ASM primary key (ID_COND_PART_ASM)
);

/*==============================================================*/
/* Index: COND_PART_ASM_PK                                      */
/*==============================================================*/
create unique index COND_PART_ASM_PK on COND_PART_ASM (
ID_COND_PART_ASM
);

/*==============================================================*/
/* Index: COND_PART_ASM_FK                                      */
/*==============================================================*/
create  index COND_PART_ASM_FK on COND_PART_ASM (
ID_AST_MEDICA
);

/*==============================================================*/
/* Table: COND_PART_RIESGOS                                     */
/*==============================================================*/
create table COND_PART_RIESGOS (
   ID_COND_PART_RIESGOS SERIAL               not null,
   ID_RIESGO            INT4                 null,
   CONDICION_PART_RIESGOS TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_COND_PART_RIESGOS primary key (ID_COND_PART_RIESGOS)
);

/*==============================================================*/
/* Index: COND_PART_RIESGOS_PK                                  */
/*==============================================================*/
create unique index COND_PART_RIESGOS_PK on COND_PART_RIESGOS (
ID_COND_PART_RIESGOS
);

/*==============================================================*/
/* Index: COND_PART_RIESGOS_FK                                  */
/*==============================================================*/
create  index COND_PART_RIESGOS_FK on COND_PART_RIESGOS (
ID_RIESGO
);

/*==============================================================*/
/* Table: CONTACTO                                              */
/*==============================================================*/
create table CONTACTO (
   ID_CONTACTO          SERIAL               not null,
   ID_CLIENTE           INT4                 null,
   TIPO_CONTACTO        TEXT                 null,
   DESCRIPCION_CONTACTO TEXT                 null,
   constraint PK_CONTACTO primary key (ID_CONTACTO)
);

comment on column CONTACTO.TIPO_CONTACTO is
'Este tipo de contacto se encuentra registrado en la tabla Catalogo y DetalleCatalogo:
1) Celular
2) Email
3) Telefono';

/*==============================================================*/
/* Index: CONTACTO_PK                                           */
/*==============================================================*/
create unique index CONTACTO_PK on CONTACTO (
ID_CONTACTO
);

/*==============================================================*/
/* Index: CONTACTO_FK                                           */
/*==============================================================*/
create  index CONTACTO_FK on CONTACTO (
ID_CLIENTE
);

/*==============================================================*/
/* Table: DETALLE_ANEXO                                         */
/*==============================================================*/
create table DETALLE_ANEXO (
   ID_DETALLE_ANEXO     SERIAL               not null,
   ID_ANEXO             INT4                 null,
   ID_TITULO            INT4                 null,
   ID_RAMO              INT4                 null,
   NOMBRE_DETALLE_ANEXO TEXT                 null,
   constraint PK_DETALLE_ANEXO primary key (ID_DETALLE_ANEXO)
);

/*==============================================================*/
/* Index: DETALLE_ANEXO_PK                                      */
/*==============================================================*/
create unique index DETALLE_ANEXO_PK on DETALLE_ANEXO (
ID_DETALLE_ANEXO
);

/*==============================================================*/
/* Index: DETALLE_ANEXO_FK                                      */
/*==============================================================*/
create  index DETALLE_ANEXO_FK on DETALLE_ANEXO (
ID_ANEXO
);

/*==============================================================*/
/* Index: DETALLE_ANEXO_FK2                                     */
/*==============================================================*/
create  index DETALLE_ANEXO_FK2 on DETALLE_ANEXO (
ID_RAMO
);

/*==============================================================*/
/* Index: DETALLE_ANEXO_FK3                                     */
/*==============================================================*/
create  index DETALLE_ANEXO_FK3 on DETALLE_ANEXO (
ID_TITULO
);

/*==============================================================*/
/* Table: DETALLE_CATALOGO                                      */
/*==============================================================*/
create table DETALLE_CATALOGO (
   ID_DETALLE_CATALOGO  SERIAL               not null,
   ID_CATALOGO          INT4                 null,
   COD_DETALLE_CATALOGO TEXT                 null,
   COD_DEP_CATALOGO     TEXT                 null,
   COD_DEP_DETALLE_CATALOGO TEXT                 null,
   DESC_DET_CATALOGO    TEXT                 null,
   constraint PK_DETALLE_CATALOGO primary key (ID_DETALLE_CATALOGO)
);

/*==============================================================*/
/* Index: DETALLE_CATALOGO_PK                                   */
/*==============================================================*/
create unique index DETALLE_CATALOGO_PK on DETALLE_CATALOGO (
ID_DETALLE_CATALOGO
);

/*==============================================================*/
/* Index: DETALLE_CATALOGO_FK                                   */
/*==============================================================*/
create  index DETALLE_CATALOGO_FK on DETALLE_CATALOGO (
ID_CATALOGO
);

/*==============================================================*/
/* Table: DIRECCION                                             */
/*==============================================================*/
create table DIRECCION (
   ID_DIRECCION         SERIAL               not null,
   ID_PROVINCIA         INT4                 null,
   ID_TIPO_DIRECCION    INT4                 null,
   ID_CLIENTE           INT4                 null,
   CALLE_PRINCIPAL      TEXT                 null,
   CALLE_SECUNDARIA     TEXT                 null,
   NUMERACION           TEXT                 null,
   REFERENCIA           TEXT                 null,
   constraint PK_DIRECCION primary key (ID_DIRECCION)
);

/*==============================================================*/
/* Index: DIRECCION_PK                                          */
/*==============================================================*/
create unique index DIRECCION_PK on DIRECCION (
ID_DIRECCION
);

/*==============================================================*/
/* Index: DIRECCION_FK                                          */
/*==============================================================*/
create  index DIRECCION_FK on DIRECCION (
ID_CLIENTE
);

/*==============================================================*/
/* Index: DIRECCION_FK2                                         */
/*==============================================================*/
create  index DIRECCION_FK2 on DIRECCION (
ID_TIPO_DIRECCION
);

/*==============================================================*/
/* Index: DIRECCION_FK3                                         */
/*==============================================================*/
create  index DIRECCION_FK3 on DIRECCION (
ID_PROVINCIA
);

/*==============================================================*/
/* Table: ENCARGADO                                             */
/*==============================================================*/
create table ENCARGADO (
   ID_ENCARGADO         SERIAL               not null,
   TIPO_TITULO          TEXT                 null,
   CARGO                TEXT                 null,
   NOMBRE_ENCARGADO     TEXT                 null,
   APELLIDO_PATERNO_ENCARGADO TEXT                 null,
   APELLIDO_MATERNO_ENCARGADO TEXT                 null,
   constraint PK_ENCARGADO primary key (ID_ENCARGADO)
);

/*==============================================================*/
/* Index: ENCARGADO_PK                                          */
/*==============================================================*/
create unique index ENCARGADO_PK on ENCARGADO (
ID_ENCARGADO
);

/*==============================================================*/
/* Table: EXTRAS_CASCO_AEREO                                    */
/*==============================================================*/
create table EXTRAS_CASCO_AEREO (
   ID_EXTRA_CASCO_AEREO SERIAL               not null,
   ID_CASCO_AEREO       INT4                 null,
   EXTRA_CASCO_AEREO    TEXT                 null,
   VALOR_EXTRA_AEREO    DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_EXTRAS_CASCO_AEREO primary key (ID_EXTRA_CASCO_AEREO)
);

/*==============================================================*/
/* Index: EXTRAS_CASCO_AEREO_PK                                 */
/*==============================================================*/
create unique index EXTRAS_CASCO_AEREO_PK on EXTRAS_CASCO_AEREO (
ID_EXTRA_CASCO_AEREO
);

/*==============================================================*/
/* Index: EXTRAS_CASCO_AEREO_FK                                 */
/*==============================================================*/
create  index EXTRAS_CASCO_AEREO_FK on EXTRAS_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Table: EXTRAS_VH                                             */
/*==============================================================*/
create table EXTRAS_VH (
   ID_EXTRA_VEHICULO    SERIAL               not null,
   ID_RAMO_VEHICULOS    INT4                 null,
   EXTRA_VH             TEXT                 null,
   CANTIDAD_EXTRA_VH    INT4                 null,
   VALOR_EXTRA_VH       DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_EXTRAS_VH primary key (ID_EXTRA_VEHICULO)
);

/*==============================================================*/
/* Index: EXTRAS_VH_PK                                          */
/*==============================================================*/
create unique index EXTRAS_VH_PK on EXTRAS_VH (
ID_EXTRA_VEHICULO
);

/*==============================================================*/
/* Index: EXTRAS_VH_FK                                          */
/*==============================================================*/
create  index EXTRAS_VH_FK on EXTRAS_VH (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Table: FINANCIAMIENTO                                        */
/*==============================================================*/
create table FINANCIAMIENTO (
   ID_FINANCIAMIENTO    SERIAL               not null,
   ID_PAGO_POLIZA       INT4                 null,
   NUMERO_CUOTA         NUMERIC              null,
   FECHA_VENCIMIENTO    DATE                 null,
   VALOR_LETRA          DECIMAL              null,
   constraint PK_FINANCIAMIENTO primary key (ID_FINANCIAMIENTO)
);

/*==============================================================*/
/* Index: FINANCIAMIENTO_PK                                     */
/*==============================================================*/
create unique index FINANCIAMIENTO_PK on FINANCIAMIENTO (
ID_FINANCIAMIENTO
);

/*==============================================================*/
/* Index: FINANCIAMIENTO_FK                                     */
/*==============================================================*/
create  index FINANCIAMIENTO_FK on FINANCIAMIENTO (
ID_PAGO_POLIZA
);

/*==============================================================*/
/* Table: GARANTIA_POLIZA                                       */
/*==============================================================*/
create table GARANTIA_POLIZA (
   ID_GARANTIA_POLIZA   SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   GARANTIA_EQ_ELEC     TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_GARANTIA_POLIZA primary key (ID_GARANTIA_POLIZA)
);

/*==============================================================*/
/* Index: GARANTIA_POLIZA_PK                                    */
/*==============================================================*/
create unique index GARANTIA_POLIZA_PK on GARANTIA_POLIZA (
ID_GARANTIA_POLIZA
);

/*==============================================================*/
/* Index: GARANTIA_POLIZA_FK                                    */
/*==============================================================*/
create  index GARANTIA_POLIZA_FK on GARANTIA_POLIZA (
ID_EQUIPO
);

/*==============================================================*/
/* Table: GRUPO_ACC_PERSONALES                                  */
/*==============================================================*/
create table GRUPO_ACC_PERSONALES (
   ID_GRUPO_ACCP        SERIAL               not null,
   ID_ACCIDENTES        INT4                 null,
   NOMBRE_GRUPO_ACC     TEXT                 null,
   NUMERO_PERSONAS_ACC  INT4                 null,
   ACTIVIDAD_ACC        TEXT                 null,
   VALOR_GRUPO_ACC      DECIMAL              null,
   DEDUC_GRUPO_ACC      DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   NUMERO_GRUPO_ACC     TEXT                 null,
   constraint PK_GRUPO_ACC_PERSONALES primary key (ID_GRUPO_ACCP)
);

/*==============================================================*/
/* Index: GRUPO_ACC_PERSONALES_PK                               */
/*==============================================================*/
create unique index GRUPO_ACC_PERSONALES_PK on GRUPO_ACC_PERSONALES (
ID_GRUPO_ACCP
);

/*==============================================================*/
/* Index: GRUPO_ACC_PERSONALES_FK                               */
/*==============================================================*/
create  index GRUPO_ACC_PERSONALES_FK on GRUPO_ACC_PERSONALES (
ID_ACCIDENTES
);

/*==============================================================*/
/* Table: GRUPO_ASM                                             */
/*==============================================================*/
create table GRUPO_ASM (
   ID_GRUPO_ASM         SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   NOMBRE_GRUPO_ASM     TEXT                 null,
   NUMERO_PERSONAS_ASM  INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   NUMERO_GRUPO_ASM     NUMERIC              null,
   ACTIVIDAD_GRUPO_AM   TEXT                 null,
   VALOR_GRUPO_ASM      DECIMAL              null,
   constraint PK_GRUPO_ASM primary key (ID_GRUPO_ASM)
);

/*==============================================================*/
/* Index: GRUPO_ASM_PK                                          */
/*==============================================================*/
create unique index GRUPO_ASM_PK on GRUPO_ASM (
ID_GRUPO_ASM
);

/*==============================================================*/
/* Index: GRUPO_ASM_FK                                          */
/*==============================================================*/
create  index GRUPO_ASM_FK on GRUPO_ASM (
ID_AST_MEDICA
);

/*==============================================================*/
/* Table: GRUPO_VIDA                                            */
/*==============================================================*/
create table GRUPO_VIDA (
   NOMBRE_GRUPO_VIDA    TEXT                 null,
   NUMERO_PERSONAS_VIDA INT4                 null,
   ACTIVIDAD_VIDA       TEXT                 null,
   VALOR_GRUPO_VIDA     DECIMAL              null,
   DEDUC_GRUPO_VIDA     DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   ID_GRUPO_VIDA        SERIAL               not null,
   ID_VIDA              INT4                 null,
   constraint PK_GRUPO_VIDA primary key (ID_GRUPO_VIDA)
);

/*==============================================================*/
/* Index: GRUPO_VIDA_PK                                         */
/*==============================================================*/
create unique index GRUPO_VIDA_PK on GRUPO_VIDA (
ID_GRUPO_VIDA
);

/*==============================================================*/
/* Index: GRUPO_VIDA_FK                                         */
/*==============================================================*/
create  index GRUPO_VIDA_FK on GRUPO_VIDA (
ID_VIDA
);

/*==============================================================*/
/* Table: LIMITES_COSTOS_ASM                                    */
/*==============================================================*/
create table LIMITES_COSTOS_ASM (
   ID_LIMITE_COSTO_ASM  SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   TIPO_LIMITE          INT4                 null,
   LIMITE_COSTO         TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_LIMITES_COSTOS_ASM primary key (ID_LIMITE_COSTO_ASM)
);

/*==============================================================*/
/* Index: LIMITES_COSTOS_ASM_PK                                 */
/*==============================================================*/
create unique index LIMITES_COSTOS_ASM_PK on LIMITES_COSTOS_ASM (
ID_LIMITE_COSTO_ASM
);

/*==============================================================*/
/* Index: LIMITES_COSTOS_ASM_FK                                 */
/*==============================================================*/
create  index LIMITES_COSTOS_ASM_FK on LIMITES_COSTOS_ASM (
ID_AST_MEDICA
);

/*==============================================================*/
/* Table: MENU                                                  */
/*==============================================================*/
create table MENU (
   ID_MENU              SERIAL               not null,
   ID_PADRE             INT4                 null,
   NOMBRE_MENU          TEXT                 null,
   URL                  TEXT                 null,
   ESTADO_MENU          TEXT                 null,
   constraint PK_MENU primary key (ID_MENU)
);

/*==============================================================*/
/* Index: MENU_PK                                               */
/*==============================================================*/
create unique index MENU_PK on MENU (
ID_MENU
);

/*==============================================================*/
/* Table: MIEMBROS_GRUPO_ACC                                    */
/*==============================================================*/
create table MIEMBROS_GRUPO_ACC (
   ID_MIEMBRO_ACCP      SERIAL               not null,
   ID_GRUPO_ACCP        INT4                 null,
   NOMBRE_MIEMBRO       TEXT                 null,
   CEDULA_MIEMBRO       TEXT                 null,
   FECHA_NACIMIENTO_MIEMBRO DATE                 null,
   PARENTEZCO_MIEMBRO   TEXT                 null,
   SEXO_MIEBRO          TEXT                 null,
   EDAD_MIEMBRO         INT4                 null,
   MODALIDAD_ACC        INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_MIEMBROS_GRUPO_ACC primary key (ID_MIEMBRO_ACCP)
);

/*==============================================================*/
/* Index: MIEMBROS_GRUPO_ACC_PK                                 */
/*==============================================================*/
create unique index MIEMBROS_GRUPO_ACC_PK on MIEMBROS_GRUPO_ACC (
ID_MIEMBRO_ACCP
);

/*==============================================================*/
/* Index: MIEMBROS_GRUPO_ACC_FK                                 */
/*==============================================================*/
create  index MIEMBROS_GRUPO_ACC_FK on MIEMBROS_GRUPO_ACC (
ID_GRUPO_ACCP
);

/*==============================================================*/
/* Table: MIEMBROS_GRUPO_ASM                                    */
/*==============================================================*/
create table MIEMBROS_GRUPO_ASM (
   ID_MIEMBRO_ASM       SERIAL               not null,
   ID_GRUPO_ASM         INT4                 null,
   NOMBRE_MIEMBRO_ASM   TEXT                 null,
   CEDULA_MIEMBRO_ASM   TEXT                 null,
   FECHA_NACIMIENTO_ASM DATE                 null,
   PARENTEZCO_ASM       TEXT                 null,
   SEXO_MIEMBRO_ASM     TEXT                 null,
   EDAD_MIEMBRO_ASM     DATE                 null,
   MODALIDAD_ASM        DATE                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_MIEMBROS_GRUPO_ASM primary key (ID_MIEMBRO_ASM)
);

/*==============================================================*/
/* Index: MIEMBROS_GRUPO_ASM_PK                                 */
/*==============================================================*/
create unique index MIEMBROS_GRUPO_ASM_PK on MIEMBROS_GRUPO_ASM (
ID_MIEMBRO_ASM
);

/*==============================================================*/
/* Index: MIEMBROS_GRUPO_ASM_FK                                 */
/*==============================================================*/
create  index MIEMBROS_GRUPO_ASM_FK on MIEMBROS_GRUPO_ASM (
ID_GRUPO_ASM
);

/*==============================================================*/
/* Table: MIEMBROS_GRUPO_VIDA                                   */
/*==============================================================*/
create table MIEMBROS_GRUPO_VIDA (
   ID_MIEMBRRO_VIDA     SERIAL               not null,
   ID_GRUPO_VIDA        INT4                 null,
   NOMBRE_MIEMBRO_VIDA  TEXT                 null,
   CEDULA_MIEMBRO_VIDA  TEXT                 null,
   FECHA_NAC_MIEMBRO_VIDA DATE                 null,
   PARENTEZCO_MIEMBRO_VIDA TEXT                 null,
   SEXO_MIEMBRO_VIDA    TEXT                 null,
   EDAD_MIEMBRO_VIDA    DATE                 null,
   MODALIDAD_MIEMBRO_VIDA TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_MIEMBROS_GRUPO_VIDA primary key (ID_MIEMBRRO_VIDA)
);

/*==============================================================*/
/* Index: MIEMBROS_GRUPO_VIDA_PK                                */
/*==============================================================*/
create unique index MIEMBROS_GRUPO_VIDA_PK on MIEMBROS_GRUPO_VIDA (
ID_MIEMBRRO_VIDA
);

/*==============================================================*/
/* Index: MIEMBROS_GRUPO_VIDA_FK                                */
/*==============================================================*/
create  index MIEMBROS_GRUPO_VIDA_FK on MIEMBROS_GRUPO_VIDA (
ID_GRUPO_VIDA
);

/*==============================================================*/
/* Table: OBJ_ASEG_AGROPECUARIO                                 */
/*==============================================================*/
create table OBJ_ASEG_AGROPECUARIO (
   ID_OBJ_AGROPECUARIO  SERIAL               not null,
   ID_AGROPECUARIO      INT4                 null,
   ITEM_OBJ_AGRO        INT4                 null,
   NOMBRE_OBJ_AGRO      TEXT                 null,
   SEXO_OBJ_AGRO        TEXT                 null,
   RAZA_OBJ_AGRO        TEXT                 null,
   COLOR_OBJ_AGRO       TEXT                 null,
   EDAD_OBJ_AGRO        INT4                 null,
   MONTO_ASEG_OBJ_AGRO  DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   VALOR_ASEGURADO_AGRO DECIMAL              null,
   DETALLE_AGRO         TEXT                 null,
   UBICACION_AGRO       TEXT                 null,
   TIPO_OBJETO_AGRO     NUMERIC              null,
   constraint PK_OBJ_ASEG_AGROPECUARIO primary key (ID_OBJ_AGROPECUARIO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_AGROPECUARIO_PK                              */
/*==============================================================*/
create unique index OBJ_ASEG_AGROPECUARIO_PK on OBJ_ASEG_AGROPECUARIO (
ID_OBJ_AGROPECUARIO
);

/*==============================================================*/
/* Index: OBJ_ASEG_AGROPECUARIO_FK                              */
/*==============================================================*/
create  index OBJ_ASEG_AGROPECUARIO_FK on OBJ_ASEG_AGROPECUARIO (
ID_AGROPECUARIO
);

/*==============================================================*/
/* Table: OBJ_ASEG_DINERO_VAL                                   */
/*==============================================================*/
create table OBJ_ASEG_DINERO_VAL (
   ID_OB_ASEG_DINERO_VALORES SERIAL               not null,
   ID_DINERO            INT4                 null,
   DINERO_VALORES       DECIMAL              null,
   LIMITE_ESTIMADO      DECIMAL              null,
   DESDE                TEXT                 null,
   HASTA                TEXT                 null,
   ITEM_OBJ_DINERO      INT4                 null,
   LIMITE_EMBARQUE_OBJ_DINERO DECIMAL              null,
   MEDIO_TRANSPORTE_DINERO TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_DINERO_VAL primary key (ID_OB_ASEG_DINERO_VALORES)
);

/*==============================================================*/
/* Index: OBJ_ASEG_DINERO_VAL_PK                                */
/*==============================================================*/
create unique index OBJ_ASEG_DINERO_VAL_PK on OBJ_ASEG_DINERO_VAL (
ID_OB_ASEG_DINERO_VALORES
);

/*==============================================================*/
/* Index: OBJ_ASEG_DINERO_VAL_FK                                */
/*==============================================================*/
create  index OBJ_ASEG_DINERO_VAL_FK on OBJ_ASEG_DINERO_VAL (
ID_DINERO
);

/*==============================================================*/
/* Table: OBJ_ASEG_EQUIPO                                       */
/*==============================================================*/
create table OBJ_ASEG_EQUIPO (
   ID_OBJETO_ASEG_EQUIPO SERIAL               not null,
   ID_EQUIPO            INT4                 null,
   ITEM_OBJ_EQ_ELEC     INT4                 null,
   UBICACION_OBJ_EQ_ELEC TEXT                 null,
   DETALLE_OBJETO_EQ_ELEC TEXT                 null,
   VALOR_OBJ_EQ_ELEC    DECIMAL              null,
   DESC_OBJ_EQ_ELEC     TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_EQUIPO primary key (ID_OBJETO_ASEG_EQUIPO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_EQUIPO_PK                                    */
/*==============================================================*/
create unique index OBJ_ASEG_EQUIPO_PK on OBJ_ASEG_EQUIPO (
ID_OBJETO_ASEG_EQUIPO
);

/*==============================================================*/
/* Index: OBJ_ASEG_EQUIPO_FK                                    */
/*==============================================================*/
create  index OBJ_ASEG_EQUIPO_FK on OBJ_ASEG_EQUIPO (
ID_EQUIPO
);

/*==============================================================*/
/* Table: OBJ_ASEG_EQUIPO_MAQ                                   */
/*==============================================================*/
create table OBJ_ASEG_EQUIPO_MAQ (
   ID_OBJETO_EQUIPO_MAQ SERIAL               not null,
   ID_EQUIPO_MAQUINARIA INT4                 null,
   NUMERO_SERIE_OBJ_MAQ TEXT                 null,
   MARCA_OBJ_EQ_MAQ     TEXT                 null,
   MODELO_OBJ_EQ_MAQ    TEXT                 null,
   ANIO_OBJ_MAQ         INT4                 null,
   MOTOR_OBJJ_EQ_MAQ    TEXT                 null,
   CHASIS_OBJ_EQ_MAQ    TEXT                 null,
   COLOR_OBJ_EQ_MAQ     TEXT                 null,
   ITEM_OBJ_EQ_MAQ      INT4                 null,
   VALOR_ASEG_OBJ_EQ_MAQ DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_EQUIPO_MAQ primary key (ID_OBJETO_EQUIPO_MAQ)
);

/*==============================================================*/
/* Index: OBJ_ASEG_EQUIPO_MAQ_PK                                */
/*==============================================================*/
create unique index OBJ_ASEG_EQUIPO_MAQ_PK on OBJ_ASEG_EQUIPO_MAQ (
ID_OBJETO_EQUIPO_MAQ
);

/*==============================================================*/
/* Index: OBJ_ASEG_EQUIPO_MAQ_FK                                */
/*==============================================================*/
create  index OBJ_ASEG_EQUIPO_MAQ_FK on OBJ_ASEG_EQUIPO_MAQ (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Table: OBJ_ASEG_FIDELIDAD                                    */
/*==============================================================*/
create table OBJ_ASEG_FIDELIDAD (
   ID_MOD_OBJ_ASEGURADO SERIAL               not null,
   ID_FIDELIDAD         INT4                 null,
   TIPO_MODALIDAD_FIDELIDAD INT4                 null,
   CARGO_FIDELIDAD      TEXT                 null,
   NOMBRE_FIDELIDAD     TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_FIDELIDAD primary key (ID_MOD_OBJ_ASEGURADO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_FIDELIDAD_PK                                 */
/*==============================================================*/
create unique index OBJ_ASEG_FIDELIDAD_PK on OBJ_ASEG_FIDELIDAD (
ID_MOD_OBJ_ASEGURADO
);

/*==============================================================*/
/* Index: OBJ_ASEG_FIDELIDAD_FK                                 */
/*==============================================================*/
create  index OBJ_ASEG_FIDELIDAD_FK on OBJ_ASEG_FIDELIDAD (
ID_FIDELIDAD
);

/*==============================================================*/
/* Table: OBJ_ASEG_INCENDIO                                     */
/*==============================================================*/
create table OBJ_ASEG_INCENDIO (
   ID_OBJETO_ASEG_INCENDIO SERIAL               not null,
   ID_INCENDIO          INT4                 null,
   ITEM_INCENDIO        TEXT                 null,
   UBICACION_INCENDIO   TEXT                 null,
   FORMA_SEGURO_INCENDIO DECIMAL              null,
   UTILIDAD_BRUTA_INCENDIO_LA DECIMAL              null,
   DETALLE_INCENDIO     TEXT                 null,
   VALOR_OBJ_ASEG_INCENDIO DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_INCENDIO primary key (ID_OBJETO_ASEG_INCENDIO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_INCENDIO_PK                                  */
/*==============================================================*/
create unique index OBJ_ASEG_INCENDIO_PK on OBJ_ASEG_INCENDIO (
ID_OBJETO_ASEG_INCENDIO
);

/*==============================================================*/
/* Index: OBJ_ASEG_INCENDIO_FK                                  */
/*==============================================================*/
create  index OBJ_ASEG_INCENDIO_FK on OBJ_ASEG_INCENDIO (
ID_INCENDIO
);

/*==============================================================*/
/* Table: OBJ_ASEG_LC_IN                                        */
/*==============================================================*/
create table OBJ_ASEG_LC_IN (
   ID_OBJETO_ASEG_LUCRO SERIAL               not null,
   ID_LUCRO             INT4                 null,
   UBICACION_OBJ_LC_INCENDIO TEXT                 null,
   FORMA_SEGURO_LC      TEXT                 null,
   ITEM_OBJ_LC_INCENDIO INT4                 null,
   UTILIDAD_BRUTA_LC_INCENDIO DECIMAL              null,
   DETALLE_OBJ_LC_INCENDIO TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_LC_IN primary key (ID_OBJETO_ASEG_LUCRO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_LC_IN_PK                                     */
/*==============================================================*/
create unique index OBJ_ASEG_LC_IN_PK on OBJ_ASEG_LC_IN (
ID_OBJETO_ASEG_LUCRO
);

/*==============================================================*/
/* Index: OBJ_ASEG_LC_IN_FK                                     */
/*==============================================================*/
create  index OBJ_ASEG_LC_IN_FK on OBJ_ASEG_LC_IN (
ID_LUCRO
);

/*==============================================================*/
/* Table: OBJ_ASEG_LC_ROT_MAQ                                   */
/*==============================================================*/
create table OBJ_ASEG_LC_ROT_MAQ (
   ID_OBJETO_ASEG_CESANTE SERIAL               not null,
   ID_CESANTE           INT4                 null,
   ITEM_OBJ_LC_ROTURA   INT4                 null,
   UBICACION_OBJ_LC_ROTURA TEXT                 null,
   VALOR_ASEG_OBJ_LC_ROTURA DECIMAL              null,
   DES_OBJ_LC_ROTURA    TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_LC_ROT_MAQ primary key (ID_OBJETO_ASEG_CESANTE)
);

/*==============================================================*/
/* Index: OBJ_ASEG_LC_ROT_MAQ_PK                                */
/*==============================================================*/
create unique index OBJ_ASEG_LC_ROT_MAQ_PK on OBJ_ASEG_LC_ROT_MAQ (
ID_OBJETO_ASEG_CESANTE
);

/*==============================================================*/
/* Index: OBJ_ASEG_LC_ROT_MAQ_FK                                */
/*==============================================================*/
create  index OBJ_ASEG_LC_ROT_MAQ_FK on OBJ_ASEG_LC_ROT_MAQ (
ID_CESANTE
);

/*==============================================================*/
/* Table: OBJ_ASEG_MONTAJE                                      */
/*==============================================================*/
create table OBJ_ASEG_MONTAJE (
   ID_OBJ_ASEG_MONTAJE  SERIAL               not null,
   ID_RIESGO_MONTAJE    INT4                 null,
   DETALLE_OBJ_MONTAJE  TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_MONTAJE primary key (ID_OBJ_ASEG_MONTAJE)
);

/*==============================================================*/
/* Index: OBJ_ASEG_MONTAJE_PK                                   */
/*==============================================================*/
create unique index OBJ_ASEG_MONTAJE_PK on OBJ_ASEG_MONTAJE (
ID_OBJ_ASEG_MONTAJE
);

/*==============================================================*/
/* Index: OBJ_ASEG_MONTAJE_FK                                   */
/*==============================================================*/
create  index OBJ_ASEG_MONTAJE_FK on OBJ_ASEG_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Table: OBJ_ASEG_RESPONSABILIDAD                              */
/*==============================================================*/
create table OBJ_ASEG_RESPONSABILIDAD (
   ID_OBJETO_ASEG_RESPOSABILIDAD SERIAL               not null,
   ID_RESPONSABILIDAD   INT4                 null,
   ITEM_RESP            INT4                 null,
   DESCRIPCION_RESP     TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_RESPONSABILIDAD primary key (ID_OBJETO_ASEG_RESPOSABILIDAD)
);

/*==============================================================*/
/* Index: OBJ_ASEG_RESPONSABILIDAD_PK                           */
/*==============================================================*/
create unique index OBJ_ASEG_RESPONSABILIDAD_PK on OBJ_ASEG_RESPONSABILIDAD (
ID_OBJETO_ASEG_RESPOSABILIDAD
);

/*==============================================================*/
/* Index: OBJ_ASEG_RESPONSABILIDAD_FK                           */
/*==============================================================*/
create  index OBJ_ASEG_RESPONSABILIDAD_FK on OBJ_ASEG_RESPONSABILIDAD (
ID_RESPONSABILIDAD
);

/*==============================================================*/
/* Table: OBJ_ASEG_ROBO                                         */
/*==============================================================*/
create table OBJ_ASEG_ROBO (
   ID_OBJETO_ROBO       SERIAL               not null,
   ID_ROBO              INT4                 null,
   ITEM_ROBO_ASALTO     INT4                 null,
   VALOR_OBJ_ROBO       DECIMAL              null,
   UBICACION_OBJ_ROBO   TEXT                 null,
   DETALLE_OBJ_ROBO     TEXT                 null,
   MUEBLES_OBJ_ROBO     DECIMAL              null,
   JOYAS_OBJ_ROBO       DECIMAL              null,
   MAQUINARIA_OBJ_ROBO  DECIMAL              null,
   DINERO_OBJ_ROBO      DECIMAL              null,
   MARCADERIA_OBJ_ROBO  DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_ROBO primary key (ID_OBJETO_ROBO)
);

/*==============================================================*/
/* Index: OBJ_ASEG_ROBO_PK                                      */
/*==============================================================*/
create unique index OBJ_ASEG_ROBO_PK on OBJ_ASEG_ROBO (
ID_OBJETO_ROBO
);

/*==============================================================*/
/* Index: OBJ_ASEG_ROBO_FK                                      */
/*==============================================================*/
create  index OBJ_ASEG_ROBO_FK on OBJ_ASEG_ROBO (
ID_ROBO
);

/*==============================================================*/
/* Table: OBJ_ASEG_ROTURA                                       */
/*==============================================================*/
create table OBJ_ASEG_ROTURA (
   ID_OBJETO_ROTURA     SERIAL               not null,
   ID_ROTURA            INT4                 null,
   ITEM_OBJ_ROTURA      INT4                 null,
   UBICACION_OBJ_ROTURA TEXT                 null,
   DESCRIPCION_OBJ_ROTURA TEXT                 null,
   TOTAL_OBJ_ROTURA     DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_ROTURA primary key (ID_OBJETO_ROTURA)
);

/*==============================================================*/
/* Index: OBJ_ASEG_ROTURA_PK                                    */
/*==============================================================*/
create unique index OBJ_ASEG_ROTURA_PK on OBJ_ASEG_ROTURA (
ID_OBJETO_ROTURA
);

/*==============================================================*/
/* Index: OBJ_ASEG_ROTURA_FK                                    */
/*==============================================================*/
create  index OBJ_ASEG_ROTURA_FK on OBJ_ASEG_ROTURA (
ID_ROTURA
);

/*==============================================================*/
/* Table: OBJ_ASEG_TRANSPORTE                                   */
/*==============================================================*/
create table OBJ_ASEG_TRANSPORTE (
   ID_OBJ_ASG_TRANSPORTE SERIAL               not null,
   ID_TRANSPORTE        INT4                 null,
   ITEM_TRANSPORTE      INT4                 null,
   LIMITE_MOVILIZACION_ANUAL DECIMAL              null,
   LIMITE_EMBARQUE_TRANSPORTE DECIMAL              null,
   MEDIO_TRANSPORTE     TEXT                 null,
   TRAYECTO_DESDE       TEXT                 null,
   TRAYECTO_HASTA       TEXT                 null,
   TIPO_EMBALAJE        TEXT                 null,
   VALUACION            TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_OBJ_ASEG_TRANSPORTE primary key (ID_OBJ_ASG_TRANSPORTE)
);

/*==============================================================*/
/* Index: OBJ_ASEG_TRANSPORTE_PK                                */
/*==============================================================*/
create unique index OBJ_ASEG_TRANSPORTE_PK on OBJ_ASEG_TRANSPORTE (
ID_OBJ_ASG_TRANSPORTE
);

/*==============================================================*/
/* Index: OBJ_ASEG_TRANSPORTE_FK                                */
/*==============================================================*/
create  index OBJ_ASEG_TRANSPORTE_FK on OBJ_ASEG_TRANSPORTE (
ID_TRANSPORTE
);

/*==============================================================*/
/* Table: PAGO_POLIZA                                           */
/*==============================================================*/
create table PAGO_POLIZA (
   ID_PAGO_POLIZA       SERIAL               not null,
   NUMERO_FACTURA       TEXT                 null,
   SUBTOTAL             DECIMAL(8,2)         null,
   ADICIONAL_SEG_CAMPESINO DECIMAL(8,2)         null,
   IVA                  DECIMAL(8,2)         null,
   CUOTA_INICIAL        DECIMAL(8,2)         null,
   VALOR_TOTAL_PAGO_POLIZA DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   TARJETA              TEXT                 null,
   TIPO_PAGO            TEXT                 null,
   NUMERO_MESES         NUMERIC              null,
   constraint PK_PAGO_POLIZA primary key (ID_PAGO_POLIZA)
);

/*==============================================================*/
/* Index: PAGO_POLIZA_PK                                        */
/*==============================================================*/
create unique index PAGO_POLIZA_PK on PAGO_POLIZA (
ID_PAGO_POLIZA
);

/*==============================================================*/
/* Table: PLAN_ASM                                              */
/*==============================================================*/
create table PLAN_ASM (
   ID_PLAN_AM           SERIAL               not null,
   ID_AST_MEDICA        INT4                 null,
   NOMBRE_PLAN_ASM      TEXT                 null,
   VALOR_PLAN_ASM       DECIMAL              null,
   constraint PK_PLAN_ASM primary key (ID_PLAN_AM)
);

/*==============================================================*/
/* Index: PLAN_ASM_PK                                           */
/*==============================================================*/
create unique index PLAN_ASM_PK on PLAN_ASM (
ID_PLAN_AM
);

/*==============================================================*/
/* Index: PLAN_ASM_FK                                           */
/*==============================================================*/
create  index PLAN_ASM_FK on PLAN_ASM (
ID_AST_MEDICA
);

/*==============================================================*/
/* Table: POLIZA                                                */
/*==============================================================*/
create table POLIZA (
   ID_POLIZA            SERIAL               not null,
   ID_CLIENTE           INT4                 null,
   ID_PAGO_POLIZA       INT4                 null,
   NUMERO_POLIZA        NUMERIC              null,
   NUMERO_ANEXO         TEXT                 null,
   EJECUTIVO            TEXT                 null,
   VIGENCIA_DESDE       DATE                 null,
   HORA_DESDE           TEXT                 null,
   VIGENCIA_HASTA       DATE                 null,
   HORA_HASTA           TEXT                 null,
   DIAS_COBERTURA       NUMERIC              null,
   SUMA_ASEGURADA       DECIMAL(8,2)         null,
   PRIMA_NETA           DECIMAL(8,2)         null,
   SUPER_BAN_SEGUROS    DECIMAL(8,2)         null,
   SEGURO_CAMPESINO     DECIMAL(8,2)         null,
   DERECHO_EMISION      DECIMAL(8,2)         null,
   RAMO                 TEXT                 null,
   ESTADO_POLIZA        TEXT                 null,
   FECHA_REGISTRO       DATE                 null,
   constraint PK_POLIZA primary key (ID_POLIZA)
);

/*==============================================================*/
/* Index: POLIZA_PK                                             */
/*==============================================================*/
create unique index POLIZA_PK on POLIZA (
ID_POLIZA
);

/*==============================================================*/
/* Index: POLIZA_FK                                             */
/*==============================================================*/
create  index POLIZA_FK on POLIZA (
ID_PAGO_POLIZA
);

/*==============================================================*/
/* Index: POLIZA_FK2                                            */
/*==============================================================*/
create  index POLIZA_FK2 on POLIZA (
ID_CLIENTE
);

/*==============================================================*/
/* Table: PROVINCIA                                             */
/*==============================================================*/
create table PROVINCIA (
   ID_PROVINCIA         SERIAL               not null,
   CODIGO               TEXT                 null,
   NOMBRE_PROVINCIA     TEXT                 null,
   constraint PK_PROVINCIA primary key (ID_PROVINCIA)
);

/*==============================================================*/
/* Index: PROVINCIA_PK                                          */
/*==============================================================*/
create unique index PROVINCIA_PK on PROVINCIA (
ID_PROVINCIA
);

/*==============================================================*/
/* Table: RAMO                                                  */
/*==============================================================*/
create table RAMO (
   ID_RAMO              SERIAL               not null,
   CODIGO_RAMO          TEXT                 null,
   NOMBRE_RAMO          TEXT                 null,
   constraint PK_RAMO primary key (ID_RAMO)
);

/*==============================================================*/
/* Index: RAMO_PK                                               */
/*==============================================================*/
create unique index RAMO_PK on RAMO (
ID_RAMO
);

/*==============================================================*/
/* Table: RAMO_ACCIDENTES_PERSONALES                            */
/*==============================================================*/
create table RAMO_ACCIDENTES_PERSONALES (
   ID_ACCIDENTES        SERIAL               not null,
   ID_POLIZA            INT4                 null,
   PRIMA_NETA_PERSONA   DECIMAL(8,2)         null,
   PRIMA_TOTAL_PERSONA  DECIMAL(8,2)         null,
   TASA_ACCIDENTE       DECIMAL              null,
   FACTURACION          INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_ACCIDENTES_PERSONALES primary key (ID_ACCIDENTES)
);

/*==============================================================*/
/* Index: RAMO_ACCIDENTES_PERSONALES_PK                         */
/*==============================================================*/
create unique index RAMO_ACCIDENTES_PERSONALES_PK on RAMO_ACCIDENTES_PERSONALES (
ID_ACCIDENTES
);

/*==============================================================*/
/* Index: RAMO_ACCIDENTES_PERSONALES_FK                         */
/*==============================================================*/
create  index RAMO_ACCIDENTES_PERSONALES_FK on RAMO_ACCIDENTES_PERSONALES (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_AGROPECUARIO                                     */
/*==============================================================*/
create table RAMO_AGROPECUARIO (
   ID_AGROPECUARIO      SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA_AGRO            DECIMAL              null,
   DEDUC_AGRO           DECIMAL              null,
   GANADERO_PLANTACION  INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_AGROPECUARIO primary key (ID_AGROPECUARIO)
);

/*==============================================================*/
/* Index: RAMO_AGROPECUARIO_PK                                  */
/*==============================================================*/
create unique index RAMO_AGROPECUARIO_PK on RAMO_AGROPECUARIO (
ID_AGROPECUARIO
);

/*==============================================================*/
/* Index: RAMO_AGROPECUARIO_FK                                  */
/*==============================================================*/
create  index RAMO_AGROPECUARIO_FK on RAMO_AGROPECUARIO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_ASEGURADORA                                      */
/*==============================================================*/
create table RAMO_ASEGURADORA (
   ID_RAMO_ASEGURADORA  SERIAL               not null,
   ID_RAMO              INT4                 null,
   ID_ASEGURADORA       INT4                 null,
   COMISION             DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_ASEGURADORA primary key (ID_RAMO_ASEGURADORA)
);

/*==============================================================*/
/* Index: RAMO_ASEGURADORA_PK                                   */
/*==============================================================*/
create unique index RAMO_ASEGURADORA_PK on RAMO_ASEGURADORA (
ID_RAMO_ASEGURADORA
);

/*==============================================================*/
/* Index: RAMO_ASEGURADORA_FK                                   */
/*==============================================================*/
create  index RAMO_ASEGURADORA_FK on RAMO_ASEGURADORA (
ID_RAMO
);

/*==============================================================*/
/* Index: RAMO_ASEGURADORA_FK2                                  */
/*==============================================================*/
create  index RAMO_ASEGURADORA_FK2 on RAMO_ASEGURADORA (
ID_ASEGURADORA
);

/*==============================================================*/
/* Table: RAMO_ASISTENCIA_MEDICA                                */
/*==============================================================*/
create table RAMO_ASISTENCIA_MEDICA (
   ID_AST_MEDICA        SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TOTAL_MENSUAL_GRUPO_ASM DECIMAL(8,2)         null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   TOTAL_ASEGURADOS_ASM INT4                 null,
   constraint PK_RAMO_ASISTENCIA_MEDICA primary key (ID_AST_MEDICA)
);

/*==============================================================*/
/* Index: RAMO_ASISTENCIA_MEDICA_PK                             */
/*==============================================================*/
create unique index RAMO_ASISTENCIA_MEDICA_PK on RAMO_ASISTENCIA_MEDICA (
ID_AST_MEDICA
);

/*==============================================================*/
/* Index: RAMO_ASISTENCIA_MEDICA_FK                             */
/*==============================================================*/
create  index RAMO_ASISTENCIA_MEDICA_FK on RAMO_ASISTENCIA_MEDICA (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_BUENA_CAL_MAT                                    */
/*==============================================================*/
create table RAMO_BUENA_CAL_MAT (
   ID_MATERIAL          SERIAL               not null,
   ID_POLIZA            INT4                 null,
   OBJ_ASEG_CAL_MAT     TEXT                 null,
   SECTOR_CAL_MAT       TEXT                 null,
   VALOR_POLIZA_MATERIALES DECIMAL              null,
   VALOR_CONTRATO_MATERIALES DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_BUENA_CAL_MAT primary key (ID_MATERIAL)
);

/*==============================================================*/
/* Index: RAMO_BUENA_CAL_MAT_PK                                 */
/*==============================================================*/
create unique index RAMO_BUENA_CAL_MAT_PK on RAMO_BUENA_CAL_MAT (
ID_MATERIAL
);

/*==============================================================*/
/* Index: RAMO_BUENA_CAL_MAT_FK                                 */
/*==============================================================*/
create  index RAMO_BUENA_CAL_MAT_FK on RAMO_BUENA_CAL_MAT (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_BUEN_USO_ANT                                     */
/*==============================================================*/
create table RAMO_BUEN_USO_ANT (
   IND_BUEN_USO_ANT     SERIAL               not null,
   ID_POLIZA            INT4                 null,
   SECTOR_ANTICIPO      TEXT                 null,
   VALOR_CONTRATO_ANTICIPO DECIMAL              null,
   VALOR_POLIZA_ANTICIPO DECIMAL              null,
   OBJ_ASEG_ANTICIPO    TEXT                 null,
   TIPO_CONTRAGARANTIA_BUEN_ANT TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_BUEN_USO_ANT primary key (IND_BUEN_USO_ANT)
);

/*==============================================================*/
/* Index: RAMO_BUEN_USO_ANT_PK                                  */
/*==============================================================*/
create unique index RAMO_BUEN_USO_ANT_PK on RAMO_BUEN_USO_ANT (
IND_BUEN_USO_ANT
);

/*==============================================================*/
/* Index: RAMO_BUEN_USO_ANT_FK                                  */
/*==============================================================*/
create  index RAMO_BUEN_USO_ANT_FK on RAMO_BUEN_USO_ANT (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_CASCO_AEREO                                      */
/*==============================================================*/
create table RAMO_CASCO_AEREO (
   ID_CASCO_AEREO       SERIAL               not null,
   ID_POLIZA            INT4                 null,
   ITEM_AEREO           INT4                 null,
   MATRICULA            TEXT                 null,
   ANIO_CONSTRUCCION_AEREO INT4                 null,
   PESO_MAXIMO_AEREO    DECIMAL              null,
   VALOR_CASCO_AEREO    DECIMAL              null,
   MARCA_AEREO          TEXT                 null,
   TIPO_MODELO_AEREO    TEXT                 null,
   HORAS_VOLADAS        INT4                 null,
   MAXIMA_CARGA_AEREO   DECIMAL              null,
   MARCA_MOTOR_AEREO    TEXT                 null,
   TIPO_MOTOR_AEREO     TEXT                 null,
   TOTAL_ASEGURADO_AEREO DECIMAL              null,
   TASA_CASCO_AEREO     DECIMAL              null,
   DEDUC_SINIESTRO_AEREO DECIMAL              null,
   DEDUC_MINIMO_SINIESTRO_AEREO DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_CASCO_AEREO primary key (ID_CASCO_AEREO)
);

/*==============================================================*/
/* Index: RAMO_CASCO_AEREO_PK                                   */
/*==============================================================*/
create unique index RAMO_CASCO_AEREO_PK on RAMO_CASCO_AEREO (
ID_CASCO_AEREO
);

/*==============================================================*/
/* Index: RAMO_CASCO_AEREO_FK                                   */
/*==============================================================*/
create  index RAMO_CASCO_AEREO_FK on RAMO_CASCO_AEREO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_CASCO_MARITIMO                                   */
/*==============================================================*/
create table RAMO_CASCO_MARITIMO (
   ID_CASCO             SERIAL               not null,
   ID_POLIZA            INT4                 null,
   ITEM_MARITIMO        INT4                 null,
   NOMBRE_NAVE          TEXT                 null,
   NUMERO_REGISTRO      TEXT                 null,
   TONELAJE_BRUTO       DECIMAL              null,
   CLASE_EMBARCACION    TEXT                 null,
   BANDERA              TEXT                 null,
   ZONA_NAVEGACION      TEXT                 null,
   ESLORA               TEXT                 null,
   PUNTAL               TEXT                 null,
   ANIO_CONSTR_MARITIMO INT4                 null,
   MANGA                TEXT                 null,
   SUPERESTRUCTURA      TEXT                 null,
   LOCALIDAD            TEXT                 null,
   MARCA_MOTOR_MARITIMO TEXT                 null,
   AVALUO               DECIMAL              null,
   VALOR_CASCO_MARITIMO DECIMAL              null,
   VALOR_MAQUINARIA_MARITIMO DECIMAL              null,
   VALOR_REDES          DECIMAL              null,
   TASA_MARITIMO        DECIMAL              null,
   OTROS_MARITIMO       DECIMAL              null,
   TOTAL_MARITIMO       DECIMAL              null,
   DEDUC_SINIESTRO_MARITIMO DECIMAL              null,
   DEDUC_MINIMO_MARITIMO DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_CASCO_MARITIMO primary key (ID_CASCO)
);

/*==============================================================*/
/* Index: RAMO_CASCO_MARITIMO_PK                                */
/*==============================================================*/
create unique index RAMO_CASCO_MARITIMO_PK on RAMO_CASCO_MARITIMO (
ID_CASCO
);

/*==============================================================*/
/* Index: RAMO_CASCO_MARITIMO_FK                                */
/*==============================================================*/
create  index RAMO_CASCO_MARITIMO_FK on RAMO_CASCO_MARITIMO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_CUMPLIMIENTO_CONTRATO                            */
/*==============================================================*/
create table RAMO_CUMPLIMIENTO_CONTRATO (
   ID_CONTRATO          SERIAL               not null,
   ID_POLIZA            INT4                 null,
   OBJETO_ASEG_CONTRATO TEXT                 null,
   VALOR_CONTRATO       DECIMAL              null,
   VALOR_ASEGURADO_CONTRATO DECIMAL              null,
   TIPO_CONTRAGARANTIA_CONTRATO TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_CUMPLIMIENTO_CONTRATO primary key (ID_CONTRATO)
);

/*==============================================================*/
/* Index: RAMO_CUMPLIMIENTO_CONTRATO_PK                         */
/*==============================================================*/
create unique index RAMO_CUMPLIMIENTO_CONTRATO_PK on RAMO_CUMPLIMIENTO_CONTRATO (
ID_CONTRATO
);

/*==============================================================*/
/* Index: RAMO_CUMPLIMIENTO_CONTRATO_FK                         */
/*==============================================================*/
create  index RAMO_CUMPLIMIENTO_CONTRATO_FK on RAMO_CUMPLIMIENTO_CONTRATO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_DINERO_VALORES                                   */
/*==============================================================*/
create table RAMO_DINERO_VALORES (
   ID_DINERO            SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA_DINERO          DECIMAL              null,
   DEDUC_MINIMO_DINERO  DECIMAL              null,
   DEDUC_POR_SINIESTRO_DINERO DECIMAL              null,
   PORCENTAJE_EMBARQUE_DINERO DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_DINERO_VALORES primary key (ID_DINERO)
);

/*==============================================================*/
/* Index: RAMO_DINERO_VALORES_PK                                */
/*==============================================================*/
create unique index RAMO_DINERO_VALORES_PK on RAMO_DINERO_VALORES (
ID_DINERO
);

/*==============================================================*/
/* Index: RAMO_DINERO_VALORES_FK                                */
/*==============================================================*/
create  index RAMO_DINERO_VALORES_FK on RAMO_DINERO_VALORES (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_EQUIPO_ELECTRONICO                               */
/*==============================================================*/
create table RAMO_EQUIPO_ELECTRONICO (
   ID_EQUIPO            SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA_EQUIPOS_FIJOS   DECIMAL              null,
   TASA_EXT_DATOS       DECIMAL              null,
   TASA_OPERACION       DECIMAL              null,
   TASA_EQUIPOS_PORTATILES DECIMAL              null,
   TASA_CELULARES       DECIMAL              null,
   TASA_HURTO_EQ_ELEC   DECIMAL              null,
   TASA_OTROS_EQ_ELEC   DECIMAL              null,
   DEDUC_EQUIPO_FIJO_SINIESTRO DECIMAL              null,
   DEDUC_EQUIPO_FIJO_MINIMO DECIMAL              null,
   DEDUC_EXT_DATOS_SINIESTRO DECIMAL              null,
   DEDUC_EXT_DATOS_MINIMO DECIMAL              null,
   DEDUC_OPERACION_NUM_DIAS INT4                 null,
   DEDUC_EQUIPO_PORTATIL_SINIESTRO DECIMAL              null,
   DEDUC_EQUIPO_PORTATIL_MINIMO DECIMAL              null,
   DECUC_CELULAR_SINIESTRO DECIMAL              null,
   DEDUC_CELULAR_MINIMO DECIMAL              null,
   DEDUC_HURTO_SINIESTRO DECIMAL              null,
   DEDUC_HURTO_MINIMO   DECIMAL              null,
   SUMA_ASEGURADA_FIJOS DECIMAL              null,
   SUMA_ASEGURADA_PORTATIL DECIMAL              null,
   SUMA_ASEGURADA_OTROS DECIMAL              null,
   SUMA_ASEGURADA_CELULARES DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   SUMA_ASEGURADA_TOTAL DECIMAL              null,
   constraint PK_RAMO_EQUIPO_ELECTRONICO primary key (ID_EQUIPO)
);

/*==============================================================*/
/* Index: RAMO_EQUIPO_ELECTRONICO_PK                            */
/*==============================================================*/
create unique index RAMO_EQUIPO_ELECTRONICO_PK on RAMO_EQUIPO_ELECTRONICO (
ID_EQUIPO
);

/*==============================================================*/
/* Index: RAMO_EQUIPO_ELECTRONICO_FK                            */
/*==============================================================*/
create  index RAMO_EQUIPO_ELECTRONICO_FK on RAMO_EQUIPO_ELECTRONICO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_EQUIPO_MAQUINARIA                                */
/*==============================================================*/
create table RAMO_EQUIPO_MAQUINARIA (
   ID_EQUIPO_MAQUINARIA SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA_EQUIPO_MAQ      DECIMAL              null,
   DEDUC_PORC_SINIESTRO_MAQ DECIMAL              null,
   DEDUC_MIN_ASEG_MAQ   DECIMAL              null,
   DEDUC_MINIMO_SINIESTRO_MAQ DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_EQUIPO_MAQUINARIA primary key (ID_EQUIPO_MAQUINARIA)
);

/*==============================================================*/
/* Index: RAMO_EQUIPO_MAQUINARIA_PK                             */
/*==============================================================*/
create unique index RAMO_EQUIPO_MAQUINARIA_PK on RAMO_EQUIPO_MAQUINARIA (
ID_EQUIPO_MAQUINARIA
);

/*==============================================================*/
/* Index: RAMO_EQUIPO_MAQUINARIA_FK                             */
/*==============================================================*/
create  index RAMO_EQUIPO_MAQUINARIA_FK on RAMO_EQUIPO_MAQUINARIA (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_FIDELIDAD                                        */
/*==============================================================*/
create table RAMO_FIDELIDAD (
   ID_FIDELIDAD         SERIAL               not null,
   ID_POLIZA            INT4                 null,
   VALOR_COLUSORIO      DECIMAL              null,
   VALOR_INDIVIDUAL     DECIMAL              null,
   TASA_FIDELIDAD       DECIMAL              null,
   DEDUC_SINIESTRO_FIDELIDAD DECIMAL              null,
   DEDUC_MINIMO_FIDELIDAD DECIMAL              null,
   SECTOR_FIDELIDAD     TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_FIDELIDAD primary key (ID_FIDELIDAD)
);

/*==============================================================*/
/* Index: RAMO_FIDELIDAD_PK                                     */
/*==============================================================*/
create unique index RAMO_FIDELIDAD_PK on RAMO_FIDELIDAD (
ID_FIDELIDAD
);

/*==============================================================*/
/* Index: RAMO_FIDELIDAD_FK                                     */
/*==============================================================*/
create  index RAMO_FIDELIDAD_FK on RAMO_FIDELIDAD (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_GARANTIA_ADUANERA                                */
/*==============================================================*/
create table RAMO_GARANTIA_ADUANERA (
   ID_ADUANERA          SERIAL               not null,
   ID_POLIZA            INT4                 null,
   OBJ_ASG_ADUANERA     TEXT                 null,
   VALOR_CONTRATO_ADUANERA DECIMAL              null,
   VALOR_POLIZA_ADUANERA DECIMAL              null,
   TIPO_CONTRAGARANTIA_ADUANERA TEXT                 null,
   SECTOR_ADUANERA      TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_GARANTIA_ADUANERA primary key (ID_ADUANERA)
);

/*==============================================================*/
/* Index: RAMO_GARANTIA_ADUANERA_PK                             */
/*==============================================================*/
create unique index RAMO_GARANTIA_ADUANERA_PK on RAMO_GARANTIA_ADUANERA (
ID_ADUANERA
);

/*==============================================================*/
/* Index: RAMO_GARANTIA_ADUANERA_FK                             */
/*==============================================================*/
create  index RAMO_GARANTIA_ADUANERA_FK on RAMO_GARANTIA_ADUANERA (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_INCENDIO_LINEAS_ALIADAS                          */
/*==============================================================*/
create table RAMO_INCENDIO_LINEAS_ALIADAS (
   ID_INCENDIO          SERIAL               not null,
   ID_POLIZA            INT4                 null,
   VALOR_ITEMS_INCENDIO DECIMAL              null,
   CONSIDERACIONES_IMP_INCENDIO TEXT                 null,
   DEDUC_MINIMO_TERREMOTO DECIMAL              null,
   DEDUC_MINIMO_LLUVIA  DECIMAL              null,
   DEDUC_MINIMO_OTROS   DECIMAL              null,
   DEDUC_MINIMO_VIDRIOS DECIMAL              null,
   DEDUC_TERREMOTO      DECIMAL              null,
   DEDUC_LLUVIA         DECIMAL              null,
   DEDUC_OTROS          DECIMAL              null,
   DEDUC_VIDRIOS        DECIMAL              null,
   TASA_REMOCION        DECIMAL              null,
   TASA_DOCUMENTOS      DECIMAL              null,
   TASA_HONORARIOS      DECIMAL              null,
   TASA_CLA_ELECTRICA   DECIMAL              null,
   TASA_AUTOEXPLOSION   DECIMAL              null,
   TASA_VIDRIOS         DECIMAL              null,
   TASA_COMPRENSIVA_INCENDIO DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_INCENDIO_LINEAS_ALIADA primary key (ID_INCENDIO)
);

/*==============================================================*/
/* Index: RAMO_INCENDIO_LINEAS_ALIADAS_PK                       */
/*==============================================================*/
create unique index RAMO_INCENDIO_LINEAS_ALIADAS_PK on RAMO_INCENDIO_LINEAS_ALIADAS (
ID_INCENDIO
);

/*==============================================================*/
/* Index: RAMO_INCENDIO_LINEAS_ALIADAS_FK                       */
/*==============================================================*/
create  index RAMO_INCENDIO_LINEAS_ALIADAS_FK on RAMO_INCENDIO_LINEAS_ALIADAS (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_LC_INCENDIO                                      */
/*==============================================================*/
create table RAMO_LC_INCENDIO (
   ID_LUCRO             SERIAL               not null,
   ID_POLIZA            INT4                 null,
   VALOR_ITEMS_LC       DECIMAL(8,2)         null,
   PERIODO_INDEMNIZACION INT4                 null,
   TASA_COMPRENSIVA_LC  DECIMAL(8,2)         null,
   DEDUC_CATASTROFICO_LC DECIMAL              null,
   DEDUC_OTROS_LC       DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_LC_INCENDIO primary key (ID_LUCRO)
);

/*==============================================================*/
/* Index: RAMO_LC_INCENDIO_PK                                   */
/*==============================================================*/
create unique index RAMO_LC_INCENDIO_PK on RAMO_LC_INCENDIO (
ID_LUCRO
);

/*==============================================================*/
/* Index: RAMO_LC_INCENDIO_FK                                   */
/*==============================================================*/
create  index RAMO_LC_INCENDIO_FK on RAMO_LC_INCENDIO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_LC_ROT_MAQ                                       */
/*==============================================================*/
create table RAMO_LC_ROT_MAQ (
   ID_CESANTE           SERIAL               not null,
   ID_POLIZA            INT4                 null,
   UTILIDAD_BRUTA_LC_ROTURA DECIMAL(8,2)         null,
   TASA_LC_ROTURA       DECIMAL              null,
   DEDUC_NUM_DIAS       INT4                 null,
   DEDUC_MINIMO_LC_ROTURA DECIMAL              null,
   DEDUC_MINIMO_ASEG_LC_ROTURA DECIMAL              null,
   PERIOD_INDEMNIZACION_LC INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_LC_ROT_MAQ primary key (ID_CESANTE)
);

/*==============================================================*/
/* Index: RAMO_LC_ROT_MAQ_PK                                    */
/*==============================================================*/
create unique index RAMO_LC_ROT_MAQ_PK on RAMO_LC_ROT_MAQ (
ID_CESANTE
);

/*==============================================================*/
/* Index: RAMO_LC_ROT_MAQ_FK                                    */
/*==============================================================*/
create  index RAMO_LC_ROT_MAQ_FK on RAMO_LC_ROT_MAQ (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_RESPONSABILIDAD_CIVIL                            */
/*==============================================================*/
create table RAMO_RESPONSABILIDAD_CIVIL (
   ID_RESPONSABILIDAD   SERIAL               not null,
   ID_POLIZA            INT4                 null,
   LIMITE_UNICO_ANUAL_RESP INT4                 null,
   TASA_RESP            DECIMAL              null,
   TIPO_CONTRAGARANTIA_RESP TEXT                 null,
   DEDUC_SINIESTRO_RESP DECIMAL              null,
   DEDUC_MINIMO_RESP    DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_RESPONSABILIDAD_CIVIL primary key (ID_RESPONSABILIDAD)
);

/*==============================================================*/
/* Index: RAMO_RESPONSABILIDAD_CIVIL_PK                         */
/*==============================================================*/
create unique index RAMO_RESPONSABILIDAD_CIVIL_PK on RAMO_RESPONSABILIDAD_CIVIL (
ID_RESPONSABILIDAD
);

/*==============================================================*/
/* Index: RAMO_RESPONSABILIDAD_CIVIL_FK                         */
/*==============================================================*/
create  index RAMO_RESPONSABILIDAD_CIVIL_FK on RAMO_RESPONSABILIDAD_CIVIL (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_RIESGOS_ESP                                      */
/*==============================================================*/
create table RAMO_RIESGOS_ESP (
   ID_RIESGO            SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA_RIESGOS_ESP     DECIMAL              null,
   COND_IMP_RIESGOS     TEXT                 null,
   DESC_OBJ_ASEG_RIESGOS TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_RIESGOS_ESP primary key (ID_RIESGO)
);

/*==============================================================*/
/* Index: RAMO_RIESGOS_ESP_PK                                   */
/*==============================================================*/
create unique index RAMO_RIESGOS_ESP_PK on RAMO_RIESGOS_ESP (
ID_RIESGO
);

/*==============================================================*/
/* Index: RAMO_RIESGOS_ESP_FK                                   */
/*==============================================================*/
create  index RAMO_RIESGOS_ESP_FK on RAMO_RIESGOS_ESP (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_RIESGO_CONTRATISTA                               */
/*==============================================================*/
create table RAMO_RIESGO_CONTRATISTA (
   ID_CONTRATISTA       SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA_PERID_CONST     DECIMAL              null,
   PERIOD_CONSTRUCCION_CONTRATISTA INT4                 null,
   PERIOD_MANT_CONTRATISTA INT4                 null,
   AMPARO_A_CONTRATISTA DECIMAL              null,
   AMPARO_B_CONTRATISTA DECIMAL              null,
   AMPARO_C_CONTRATISTA DECIMAL              null,
   AMPARO_D_CONTRATISTA DECIMAL              null,
   AMPARO_G_CONTRATISTA DECIMAL              null,
   MINIMO_AMPARO_A      DECIMAL              null,
   MINIMO_AMPARO_B      DECIMAL              null,
   MINIMO_AMPARO_C      DECIMAL              null,
   MINIMO_AMPARO_D      DECIMAL              null,
   MINIMO_AMPARO_G      DECIMAL              null,
   DOC_CRONOGRAMA_CONTRATISTA TEXT                 null,
   DOC_ESTUDIO_CONTRATISTA TEXT                 null,
   DOC_FORMULARIO_CONTRATISTA TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_RIESGO_CONTRATISTA primary key (ID_CONTRATISTA)
);

/*==============================================================*/
/* Index: RAMO_RIESGO_CONTRATISTA_PK                            */
/*==============================================================*/
create unique index RAMO_RIESGO_CONTRATISTA_PK on RAMO_RIESGO_CONTRATISTA (
ID_CONTRATISTA
);

/*==============================================================*/
/* Index: RAMO_RIESGO_CONTRATISTA_FK                            */
/*==============================================================*/
create  index RAMO_RIESGO_CONTRATISTA_FK on RAMO_RIESGO_CONTRATISTA (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_RIESGO_MONTAJE                                   */
/*==============================================================*/
create table RAMO_RIESGO_MONTAJE (
   ID_RIESGO_MONTAJE    SERIAL               not null,
   ID_POLIZA            INT4                 null,
   PERIODO_CONSTRUC_MONTAJE INT4                 null,
   PERIODO_MANT_MONTAJE INT4                 null,
   TASA_MONTAJE         DECIMAL              null,
   AMPARO_A_MONTAJE     DECIMAL              null,
   AMPARO_B_MONTAJE     DECIMAL              null,
   AMPARO_C_MONTAJE     DECIMAL              null,
   AMPARO_D_MONTAJE     DECIMAL              null,
   AMPARO_G_MONTAJE     DECIMAL              null,
   MINIMO_AMPARO_A_MONTAJE DECIMAL              null,
   MINIMO_AMPARO_B_MONTAJE DECIMAL              null,
   MINIMO_AMPARO_C_MONTAJE DECIMAL              null,
   MINIMO_AMPARO_D_MONTAJE DECIMAL              null,
   MINIMO_AMPARO_G_MONTAJE DECIMAL              null,
   DOC_CRONOGRAMA_MONTAJE TEXT                 null,
   DOC_ESTUDIO_MONTAJE  TEXT                 null,
   DOC_FORMULARIO_MONTJE TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_RIESGO_MONTAJE primary key (ID_RIESGO_MONTAJE)
);

/*==============================================================*/
/* Index: RAMO_RIESGO_MONTAJE_PK                                */
/*==============================================================*/
create unique index RAMO_RIESGO_MONTAJE_PK on RAMO_RIESGO_MONTAJE (
ID_RIESGO_MONTAJE
);

/*==============================================================*/
/* Index: RAMO_RIESGO_MONTAJE_FK                                */
/*==============================================================*/
create  index RAMO_RIESGO_MONTAJE_FK on RAMO_RIESGO_MONTAJE (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_ROBO_ASALTO                                      */
/*==============================================================*/
create table RAMO_ROBO_ASALTO (
   ID_ROBO              SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA_ROBO_ASALTO     DECIMAL              null,
   TASA_HURTO_ROBO      DECIMAL              null,
   TASA_PROPIEDAD       DECIMAL              null,
   TASA_CONTENIDOS      DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_ROBO_ASALTO primary key (ID_ROBO)
);

/*==============================================================*/
/* Index: RAMO_ROBO_ASALTO_PK                                   */
/*==============================================================*/
create unique index RAMO_ROBO_ASALTO_PK on RAMO_ROBO_ASALTO (
ID_ROBO
);

/*==============================================================*/
/* Index: RAMO_ROBO_ASALTO_FK                                   */
/*==============================================================*/
create  index RAMO_ROBO_ASALTO_FK on RAMO_ROBO_ASALTO (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_ROTURA_MAQUINARIA                                */
/*==============================================================*/
create table RAMO_ROTURA_MAQUINARIA (
   ID_ROTURA            SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA_ROT_MAQ         DECIMAL              null,
   DEDUC_SINIESTRO_ROT_MAQ DECIMAL              null,
   DEDUC_MINIMO_ASEG_ROT_MAQ DECIMAL              null,
   DEDUC_MINIMO_SINIESTRO_ROT DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 not null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 not null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_ROTURA_MAQUINARIA primary key (ID_ROTURA)
);

/*==============================================================*/
/* Index: RAMO_ROTURA_MAQUINARIA_PK                             */
/*==============================================================*/
create unique index RAMO_ROTURA_MAQUINARIA_PK on RAMO_ROTURA_MAQUINARIA (
ID_ROTURA
);

/*==============================================================*/
/* Index: RAMO_ROTURA_MAQUINARIA_FK                             */
/*==============================================================*/
create  index RAMO_ROTURA_MAQUINARIA_FK on RAMO_ROTURA_MAQUINARIA (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_SOAT                                             */
/*==============================================================*/
create table RAMO_SOAT (
   ID_SOAT              SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TIPO_VEHICULO_SOAT   TEXT                 null,
   MODELO_SOAT          TEXT                 null,
   ASEGURADO            TEXT                 null,
   MARCA_SOAT           TEXT                 null,
   COLOR_SOAT           TEXT                 null,
   PLACA_SOAT           TEXT                 null,
   MOTOR_SOAT           TEXT                 null,
   CHASIS_SOAT          TEXT                 null,
   ANIO_SOAT            INT4                 null,
   CILINDRAJE_SOAT      INT4                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_SOAT primary key (ID_SOAT)
);

/*==============================================================*/
/* Index: RAMO_SOAT_PK                                          */
/*==============================================================*/
create unique index RAMO_SOAT_PK on RAMO_SOAT (
ID_SOAT
);

/*==============================================================*/
/* Index: RAMO_SOAT_FK                                          */
/*==============================================================*/
create  index RAMO_SOAT_FK on RAMO_SOAT (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_TRANSPORTE                                       */
/*==============================================================*/
create table RAMO_TRANSPORTE (
   ID_TRANSPORTE        SERIAL               not null,
   ID_POLIZA            INT4                 null,
   COND_IMPORTANTES_TRANSPORTE TEXT                 null,
   TASA_TRANSPORTE      DECIMAL              null,
   SINIESTRO_TRANS      DECIMAL              null,
   MINIMO_SINIESTRO_TRANS DECIMAL              null,
   EMBARQUE_TRANS       DECIMAL              null,
   MINIMO_EMBARQUE_TRANS DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_TRANSPORTE primary key (ID_TRANSPORTE)
);

/*==============================================================*/
/* Index: RAMO_TRANSPORTE_PK                                    */
/*==============================================================*/
create unique index RAMO_TRANSPORTE_PK on RAMO_TRANSPORTE (
ID_TRANSPORTE
);

/*==============================================================*/
/* Index: RAMO_TRANSPORTE_FK                                    */
/*==============================================================*/
create  index RAMO_TRANSPORTE_FK on RAMO_TRANSPORTE (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_VEHICULOS                                        */
/*==============================================================*/
create table RAMO_VEHICULOS (
   ID_RAMO_VEHICULOS    SERIAL               not null,
   ID_POLIZA            INT4                 null,
   CLASE_VH             TEXT                 null,
   TIPO_VH              TEXT                 null,
   USO_VH               TEXT                 null,
   MODELO_VH            TEXT                 null,
   DETALLE_MODELO_VH    TEXT                 null,
   ITEM_VH              INT4                 null,
   PROPIETARIO_VH       TEXT                 null,
   PLACA_VH             TEXT                 null,
   MOTOR_VH             TEXT                 null,
   CHASIS_VH            TEXT                 null,
   ANIO_FABRICACCION_VH INT4                 null,
   COLOR_VH             TEXT                 null,
   VALOR_ASEG_VH        DECIMAL              null,
   VALOR_TOTAL_ITEMS_VH DECIMAL              null,
   TASA_VH              DECIMAL              null,
   CONSIDERACIONES_IMP_VH TEXT                 null,
   AMPARO_PATRIMONIAL_VH DECIMAL              null,
   COBERTURA_PACTO_ANDINO DECIMAL              null,
   ASISTENCIA_VEHICULAR TEXT                 null,
   AUTO_SUSTITUTO       TEXT                 null,
   DEDUC_PORCENTAJE_VH  DECIMAL              null,
   DEDUC_SINIESTRO_VH   DECIMAL              null,
   DEDUC_MINIMO_SINIESTRO_VH DECIMAL              null,
   DEDUC_VALOR_ASEG_VH  DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_VEHICULOS primary key (ID_RAMO_VEHICULOS)
);

/*==============================================================*/
/* Index: RAMO_VEHICULOS_PK                                     */
/*==============================================================*/
create unique index RAMO_VEHICULOS_PK on RAMO_VEHICULOS (
ID_RAMO_VEHICULOS
);

/*==============================================================*/
/* Index: RAMO_VEHICULOS_FK                                     */
/*==============================================================*/
create  index RAMO_VEHICULOS_FK on RAMO_VEHICULOS (
ID_POLIZA
);

/*==============================================================*/
/* Table: RAMO_VIDA                                             */
/*==============================================================*/
create table RAMO_VIDA (
   ID_VIDA              SERIAL               not null,
   ID_POLIZA            INT4                 null,
   TASA_VIDA            DECIMAL              null,
   TASA_MUERTE          DECIMAL              null,
   TASA_INCAPICIDAD     DECIMAL              null,
   TOTAL_ASEGURADOS     INT4                 null,
   PRIMA_NETA_PERSONA_VIDA DECIMAL              null,
   PRIMA_TOTAL_PERSONA_VIDA DECIMAL              null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_RAMO_VIDA primary key (ID_VIDA)
);

/*==============================================================*/
/* Index: RAMO_VIDA_PK                                          */
/*==============================================================*/
create unique index RAMO_VIDA_PK on RAMO_VIDA (
ID_VIDA
);

/*==============================================================*/
/* Index: RAMO_VIDA_FK                                          */
/*==============================================================*/
create  index RAMO_VIDA_FK on RAMO_VIDA (
ID_POLIZA
);

/*==============================================================*/
/* Table: ROL                                                   */
/*==============================================================*/
create table ROL (
   ID_ROL               SERIAL               not null,
   ID_USUARIO           INT4                 null,
   NOMBRE_ROL           TEXT                 null,
   DESCRIPCION_ROL      TEXT                 null,
   ESTADO_ROL           TEXT                 null,
   constraint PK_ROL primary key (ID_ROL)
);

/*==============================================================*/
/* Index: ROL_PK                                                */
/*==============================================================*/
create unique index ROL_PK on ROL (
ID_ROL
);

/*==============================================================*/
/* Index: ROL_FK                                                */
/*==============================================================*/
create  index ROL_FK on ROL (
ID_USUARIO
);

/*==============================================================*/
/* Table: ROL_MENU                                              */
/*==============================================================*/
create table ROL_MENU (
   ID_MENU_ROL          SERIAL               not null,
   ID_ROL               INT4                 null,
   ID_MENU              INT4                 null,
   constraint PK_ROL_MENU primary key (ID_MENU_ROL)
);

/*==============================================================*/
/* Index: ROL_MENU_PK                                           */
/*==============================================================*/
create unique index ROL_MENU_PK on ROL_MENU (
ID_MENU_ROL
);

/*==============================================================*/
/* Index: ROL_MENU_FK                                           */
/*==============================================================*/
create  index ROL_MENU_FK on ROL_MENU (
ID_ROL
);

/*==============================================================*/
/* Index: ROL_MENU_FK2                                          */
/*==============================================================*/
create  index ROL_MENU_FK2 on ROL_MENU (
ID_MENU
);

/*==============================================================*/
/* Table: TIPO_DIRECCION                                        */
/*==============================================================*/
create table TIPO_DIRECCION (
   ID_TIPO_DIRECCION    SERIAL               not null,
   CODIGO_TIPO_DIRECCION TEXT                 null,
   DESC_TIPO_DIRECCION  TEXT                 null,
   constraint PK_TIPO_DIRECCION primary key (ID_TIPO_DIRECCION)
);

/*==============================================================*/
/* Index: TIPO_DIRECCION_PK                                     */
/*==============================================================*/
create unique index TIPO_DIRECCION_PK on TIPO_DIRECCION (
ID_TIPO_DIRECCION
);

/*==============================================================*/
/* Table: TITULO                                                */
/*==============================================================*/
create table TITULO (
   ID_TITULO            SERIAL               not null,
   TIPO_TITULO          TEXT                 null,
   constraint PK_TITULO primary key (ID_TITULO)
);

/*==============================================================*/
/* Index: TITULO_PK                                             */
/*==============================================================*/
create unique index TITULO_PK on TITULO (
ID_TITULO
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   ID_USUARIO           SERIAL               not null,
   USUARIO              TEXT                 null,
   NOMBRE_USUARIO       TEXT                 null,
   CLAVE                TEXT                 null,
   IDENTIFICACION_USUARIO TEXT                 null,
   EMAIL_USUARIO        TEXT                 null,
   ESTADO               TEXT                 null,
   ID_USUARIO_CREACION  INT4                 null,
   FECHA_CREACION       DATE                 null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_ACTUALIZACION  DATE                 null,
   constraint PK_USUARIO primary key (ID_USUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
ID_USUARIO
);

alter table ARCHIVO_BASE
   add constraint FK_ARCHIVO__DOC_AGROP_RAMO_AGR foreign key (ID_AGROPECUARIO)
      references RAMO_AGROPECUARIO (ID_AGROPECUARIO)
      on delete restrict on update restrict;

alter table BENEFICIARIOS_VIDA
   add constraint FK_BENEFICI_RELATIONS_MIEMBROS foreign key (ID_MIEMBRRO_VIDA)
      references MIEMBROS_GRUPO_VIDA (ID_MIEMBRRO_VIDA)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_ACC_PERS
   add constraint FK_CLAUSULA_CLA_ACC_P_RAMO_ACC foreign key (ID_ACCIDENTES)
      references RAMO_ACCIDENTES_PERSONALES (ID_ACCIDENTES)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_AGRO
   add constraint FK_CLAUSULA_CLA_ADD_A_RAMO_AGR foreign key (ID_AGROPECUARIO)
      references RAMO_AGROPECUARIO (ID_AGROPECUARIO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_CASCO
   add constraint FK_CLAUSULA_CLA_ADD_C_RAMO_CAS foreign key (ID_CASCO)
      references RAMO_CASCO_MARITIMO (ID_CASCO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_CASCO_AEREO
   add constraint FK_CLAUSULA_CLA_ADD_C_RAMO_CAS foreign key (ID_CASCO_AEREO)
      references RAMO_CASCO_AEREO (ID_CASCO_AEREO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_CONTRATISTA
   add constraint FK_CLAUSULA_CLA_ADD_C_RAMO_RIE foreign key (ID_CONTRATISTA)
      references RAMO_RIESGO_CONTRATISTA (ID_CONTRATISTA)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_DINERO
   add constraint FK_CLAUSULA_CLA_ADD_D_RAMO_DIN foreign key (ID_DINERO)
      references RAMO_DINERO_VALORES (ID_DINERO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_EQUIPO
   add constraint FK_CLAUSULA_CLA_ADD_E_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_EQ_MAQ
   add constraint FK_CLAUSULA_CLA_ADD_E_RAMO_EQU foreign key (ID_EQUIPO_MAQUINARIA)
      references RAMO_EQUIPO_MAQUINARIA (ID_EQUIPO_MAQUINARIA)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_FIDELIDAD
   add constraint FK_CLAUSULA_CLA_ADD_F_RAMO_FID foreign key (ID_FIDELIDAD)
      references RAMO_FIDELIDAD (ID_FIDELIDAD)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_INCENDIO
   add constraint FK_CLAUSULA_CLA_ADD_I_RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_LC_IN
   add constraint FK_CLAUSULA_CLA_ADD_L_RAMO_LC_ foreign key (ID_LUCRO)
      references RAMO_LC_INCENDIO (ID_LUCRO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_MONTAJE
   add constraint FK_CLAUSULA_CLA_ADD_M_RAMO_RIE foreign key (ID_RIESGO_MONTAJE)
      references RAMO_RIESGO_MONTAJE (ID_RIESGO_MONTAJE)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_RESP
   add constraint FK_CLAUSULA_CLA_RESP_RAMO_RES foreign key (ID_RESPONSABILIDAD)
      references RAMO_RESPONSABILIDAD_CIVIL (ID_RESPONSABILIDAD)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_RIESGOS
   add constraint FK_CLAUSULA_CLA_ADD_R_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_ROBO
   add constraint FK_CLAUSULA_CLA_ADD_R_RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_ROTURA
   add constraint FK_CLAUSULA_CLA_ADD_R_RAMO_ROT foreign key (ID_ROTURA)
      references RAMO_ROTURA_MAQUINARIA (ID_ROTURA)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_TRANS
   add constraint FK_CLAUSULA_CLA_ADD_T_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table CLAUSULAS_ADD_VH
   add constraint FK_CLAUSULA_CLA_ADD_V_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table CLA_ADD_LC_ROT
   add constraint FK_CLA_ADD__CLA_ADD_L_RAMO_LC_ foreign key (ID_CESANTE)
      references RAMO_LC_ROT_MAQ (ID_CESANTE)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_RELATIONS_ASEGURAD foreign key (ID_ASEGURADORA)
      references ASEGURADORA (ID_ASEGURADORA)
      on delete restrict on update restrict;

alter table COBERTURA_ROBO
   add constraint FK_COBERTUR_COB_ROBO_RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table COBERT_ACC_PER
   add constraint FK_COBERT_A_RELATIONS_RAMO_ACC foreign key (ID_ACCIDENTES)
      references RAMO_ACCIDENTES_PERSONALES (ID_ACCIDENTES)
      on delete restrict on update restrict;

alter table COBERT_ADD_CASCO
   add constraint FK_COBERT_A_COB_ADD_C_RAMO_CAS foreign key (ID_CASCO)
      references RAMO_CASCO_MARITIMO (ID_CASCO)
      on delete restrict on update restrict;

alter table COBERT_ADD_CASCO_AEREO
   add constraint FK_COBERT_A_COBERT_AD_RAMO_CAS foreign key (ID_CASCO_AEREO)
      references RAMO_CASCO_AEREO (ID_CASCO_AEREO)
      on delete restrict on update restrict;

alter table COBERT_ADD_EQUIPO
   add constraint FK_COBERT_A_COB_ADD_E_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table COBERT_ADD_EQ_MAQ
   add constraint FK_COBERT_A_COB_ADD_E_RAMO_EQU foreign key (ID_EQUIPO_MAQUINARIA)
      references RAMO_EQUIPO_MAQUINARIA (ID_EQUIPO_MAQUINARIA)
      on delete restrict on update restrict;

alter table COBERT_ADD_INCENDIO
   add constraint FK_COBERT_A_COB_ADD_I_RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COBERT_ADD_LC_ROT
   add constraint FK_COBERT_A_COB_ADD_L_RAMO_LC_ foreign key (ID_CESANTE)
      references RAMO_LC_ROT_MAQ (ID_CESANTE)
      on delete restrict on update restrict;

alter table COBERT_ADD_RIESGOS
   add constraint FK_COBERT_A_COB_ADD_R_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table COBERT_ADD_ROBO
   add constraint FK_COBERT_A_COB_ADD_R_RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table COBERT_ADD_ROTURA
   add constraint FK_COBERT_A_COB_ADD_R_RAMO_ROT foreign key (ID_ROTURA)
      references RAMO_ROTURA_MAQUINARIA (ID_ROTURA)
      on delete restrict on update restrict;

alter table COBERT_ADUANERA
   add constraint FK_COBERT_A_COB_ADUAN_RAMO_GAR foreign key (ID_ADUANERA)
      references RAMO_GARANTIA_ADUANERA (ID_ADUANERA)
      on delete restrict on update restrict;

alter table COBERT_AGRO
   add constraint FK_COBERT_A_COB_AGRO_RAMO_AGR foreign key (ID_AGROPECUARIO)
      references RAMO_AGROPECUARIO (ID_AGROPECUARIO)
      on delete restrict on update restrict;

alter table COBERT_BUEN_USO_ANT
   add constraint FK_COBERT_B_COBERTURA_RAMO_BUE foreign key (IND_BUEN_USO_ANT)
      references RAMO_BUEN_USO_ANT (IND_BUEN_USO_ANT)
      on delete restrict on update restrict;

alter table COBERT_CASCO_AEREO
   add constraint FK_COBERT_C_RELATIONS_RAMO_CAS foreign key (ID_CASCO_AEREO)
      references RAMO_CASCO_AEREO (ID_CASCO_AEREO)
      on delete restrict on update restrict;

alter table COBERT_CONTRATISTA
   add constraint FK_COBERT_C_COB_CONTR_RAMO_RIE foreign key (ID_CONTRATISTA)
      references RAMO_RIESGO_CONTRATISTA (ID_CONTRATISTA)
      on delete restrict on update restrict;

alter table COBERT_CONTRATO
   add constraint FK_COBERT_C_COB_CONTR_RAMO_CUM foreign key (ID_CONTRATO)
      references RAMO_CUMPLIMIENTO_CONTRATO (ID_CONTRATO)
      on delete restrict on update restrict;

alter table COBERT_DINERO_VAL
   add constraint FK_COBERT_D_COB_DINER_RAMO_DIN foreign key (ID_DINERO)
      references RAMO_DINERO_VALORES (ID_DINERO)
      on delete restrict on update restrict;

alter table COBERT_EQUIPO
   add constraint FK_COBERT_E_COB_EQUIP_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table COBERT_EQ_MAQ
   add constraint FK_COBERT_E_COB_EQUIP_RAMO_EQU foreign key (ID_EQUIPO_MAQUINARIA)
      references RAMO_EQUIPO_MAQUINARIA (ID_EQUIPO_MAQUINARIA)
      on delete restrict on update restrict;

alter table COBERT_FIDELIDAD
   add constraint FK_COBERT_F_COB_FIDEL_RAMO_FID foreign key (ID_FIDELIDAD)
      references RAMO_FIDELIDAD (ID_FIDELIDAD)
      on delete restrict on update restrict;

alter table COBERT_INCENDIO
   add constraint FK_COBERT_I_COB_INCEN_RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COBERT_LC_IN
   add constraint FK_COBERT_L_COB_LC_IN_RAMO_LC_ foreign key (ID_LUCRO)
      references RAMO_LC_INCENDIO (ID_LUCRO)
      on delete restrict on update restrict;

alter table COBERT_LC_ROT
   add constraint FK_COBERT_L_COB_LC_RO_RAMO_LC_ foreign key (ID_CESANTE)
      references RAMO_LC_ROT_MAQ (ID_CESANTE)
      on delete restrict on update restrict;

alter table COBERT_MATERIALES
   add constraint FK_COBERT_M_COB_BUEN__RAMO_BUE foreign key (ID_MATERIAL)
      references RAMO_BUENA_CAL_MAT (ID_MATERIAL)
      on delete restrict on update restrict;

alter table COBERT_MONTAJE
   add constraint FK_COBERT_M_COB_MONTA_RAMO_RIE foreign key (ID_RIESGO_MONTAJE)
      references RAMO_RIESGO_MONTAJE (ID_RIESGO_MONTAJE)
      on delete restrict on update restrict;

alter table COBERT_RESP
   add constraint FK_COBERT_R_COB_RESP_RAMO_RES foreign key (ID_RESPONSABILIDAD)
      references RAMO_RESPONSABILIDAD_CIVIL (ID_RESPONSABILIDAD)
      on delete restrict on update restrict;

alter table COBERT_RIESGOS
   add constraint FK_COBERT_R_COB_RIESG_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table COBERT_ROTURA
   add constraint FK_COBERT_R_COB_ROTUR_RAMO_ROT foreign key (ID_ROTURA)
      references RAMO_ROTURA_MAQUINARIA (ID_ROTURA)
      on delete restrict on update restrict;

alter table COBERT_SOAT
   add constraint FK_COBERT_S_COB_SOAT_RAMO_SOA foreign key (ID_SOAT)
      references RAMO_SOAT (ID_SOAT)
      on delete restrict on update restrict;

alter table COBERT_TRANS
   add constraint FK_COBERT_T_COB_TRANS_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table COND_ESP_ACC_PERS
   add constraint FK_COND_ESP_RELATIONS_RAMO_ACC foreign key (ID_ACCIDENTES)
      references RAMO_ACCIDENTES_PERSONALES (ID_ACCIDENTES)
      on delete restrict on update restrict;

alter table COND_ESP_INCENDIO
   add constraint FK_COND_ESP_COND_ESP__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table COND_ESP_RIESGOS
   add constraint FK_COND_ESP_COND_ESP__RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table COND_ESP_ROBO
   add constraint FK_COND_ESP_COND_ESP__RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table COND_ESP_TRANS
   add constraint FK_COND_ESP_TRANS_CON_RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table COND_ESP_VH
   add constraint FK_COND_ESP_RAMO_VH_C_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table COND_PART_ASM
   add constraint FK_COND_PAR_ASM_COND__RAMO_ASI foreign key (ID_AST_MEDICA)
      references RAMO_ASISTENCIA_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table COND_PART_RIESGOS
   add constraint FK_COND_PAR_COND_PART_RAMO_RIE foreign key (ID_RIESGO)
      references RAMO_RIESGOS_ESP (ID_RIESGO)
      on delete restrict on update restrict;

alter table CONTACTO
   add constraint FK_CONTACTO_RELATIONS_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE)
      on delete restrict on update restrict;

alter table DETALLE_ANEXO
   add constraint FK_DETALLE__DETALLE_A_ANEXO foreign key (ID_ANEXO)
      references ANEXO (ID_ANEXO)
      on delete restrict on update restrict;

alter table DETALLE_ANEXO
   add constraint FK_DETALLE__DETALLE_A_RAMO foreign key (ID_RAMO)
      references RAMO (ID_RAMO)
      on delete restrict on update restrict;

alter table DETALLE_ANEXO
   add constraint FK_DETALLE__DETALLE_T_TITULO foreign key (ID_TITULO)
      references TITULO (ID_TITULO)
      on delete restrict on update restrict;

alter table DETALLE_CATALOGO
   add constraint FK_DETALLE__CATALOGO__CATALOGO foreign key (ID_CATALOGO)
      references CATALOGO (ID_CATALOGO)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_CLIENTE_D_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_DIRECCION_PROVINCI foreign key (ID_PROVINCIA)
      references PROVINCIA (ID_PROVINCIA)
      on delete restrict on update restrict;

alter table DIRECCION
   add constraint FK_DIRECCIO_DIRECCION_TIPO_DIR foreign key (ID_TIPO_DIRECCION)
      references TIPO_DIRECCION (ID_TIPO_DIRECCION)
      on delete restrict on update restrict;

alter table EXTRAS_CASCO_AEREO
   add constraint FK_EXTRAS_C_EXTRAS_CA_RAMO_CAS foreign key (ID_CASCO_AEREO)
      references RAMO_CASCO_AEREO (ID_CASCO_AEREO)
      on delete restrict on update restrict;

alter table EXTRAS_VH
   add constraint FK_EXTRAS_V_RAMO_VH_E_RAMO_VEH foreign key (ID_RAMO_VEHICULOS)
      references RAMO_VEHICULOS (ID_RAMO_VEHICULOS)
      on delete restrict on update restrict;

alter table FINANCIAMIENTO
   add constraint FK_FINANCIA_PAGO_FINA_PAGO_POL foreign key (ID_PAGO_POLIZA)
      references PAGO_POLIZA (ID_PAGO_POLIZA)
      on delete restrict on update restrict;

alter table GARANTIA_POLIZA
   add constraint FK_GARANTIA_GART_POLI_RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table GRUPO_ACC_PERSONALES
   add constraint FK_GRUPO_AC_GRUPO_ACC_RAMO_ACC foreign key (ID_ACCIDENTES)
      references RAMO_ACCIDENTES_PERSONALES (ID_ACCIDENTES)
      on delete restrict on update restrict;

alter table GRUPO_ASM
   add constraint FK_GRUPO_AS_ASM_GRUPO_RAMO_ASI foreign key (ID_AST_MEDICA)
      references RAMO_ASISTENCIA_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table GRUPO_VIDA
   add constraint FK_GRUPO_VI_VIDA_GRUP_RAMO_VID foreign key (ID_VIDA)
      references RAMO_VIDA (ID_VIDA)
      on delete restrict on update restrict;

alter table LIMITES_COSTOS_ASM
   add constraint FK_LIMITES__LIMITES_C_RAMO_ASI foreign key (ID_AST_MEDICA)
      references RAMO_ASISTENCIA_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table MIEMBROS_GRUPO_ACC
   add constraint FK_MIEMBROS_GRUPO_MIE_GRUPO_AC foreign key (ID_GRUPO_ACCP)
      references GRUPO_ACC_PERSONALES (ID_GRUPO_ACCP)
      on delete restrict on update restrict;

alter table MIEMBROS_GRUPO_ASM
   add constraint FK_MIEMBROS_GRUPO_MIE_GRUPO_AS foreign key (ID_GRUPO_ASM)
      references GRUPO_ASM (ID_GRUPO_ASM)
      on delete restrict on update restrict;

alter table MIEMBROS_GRUPO_VIDA
   add constraint FK_MIEMBROS_GRUPO_MIE_GRUPO_VI foreign key (ID_GRUPO_VIDA)
      references GRUPO_VIDA (ID_GRUPO_VIDA)
      on delete restrict on update restrict;

alter table OBJ_ASEG_AGROPECUARIO
   add constraint FK_OBJ_ASEG_RELATIONS_RAMO_AGR foreign key (ID_AGROPECUARIO)
      references RAMO_AGROPECUARIO (ID_AGROPECUARIO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_DINERO_VAL
   add constraint FK_OBJ_ASEG_OBJ_ASG_D_RAMO_DIN foreign key (ID_DINERO)
      references RAMO_DINERO_VALORES (ID_DINERO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_EQUIPO
   add constraint FK_OBJ_ASEG_OBJ_ASEG__RAMO_EQU foreign key (ID_EQUIPO)
      references RAMO_EQUIPO_ELECTRONICO (ID_EQUIPO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_EQUIPO_MAQ
   add constraint FK_OBJ_ASEG_OBJ_ASEG__RAMO_EQU foreign key (ID_EQUIPO_MAQUINARIA)
      references RAMO_EQUIPO_MAQUINARIA (ID_EQUIPO_MAQUINARIA)
      on delete restrict on update restrict;

alter table OBJ_ASEG_FIDELIDAD
   add constraint FK_OBJ_ASEG_OBJ_ASEG__RAMO_FID foreign key (ID_FIDELIDAD)
      references RAMO_FIDELIDAD (ID_FIDELIDAD)
      on delete restrict on update restrict;

alter table OBJ_ASEG_INCENDIO
   add constraint FK_OBJ_ASEG_OBJ_ASEG__RAMO_INC foreign key (ID_INCENDIO)
      references RAMO_INCENDIO_LINEAS_ALIADAS (ID_INCENDIO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_LC_IN
   add constraint FK_OBJ_ASEG_OBJ_ASEG__RAMO_LC_ foreign key (ID_LUCRO)
      references RAMO_LC_INCENDIO (ID_LUCRO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_LC_ROT_MAQ
   add constraint FK_OBJ_ASEG_OBJ_ASEG__RAMO_LC_ foreign key (ID_CESANTE)
      references RAMO_LC_ROT_MAQ (ID_CESANTE)
      on delete restrict on update restrict;

alter table OBJ_ASEG_MONTAJE
   add constraint FK_OBJ_ASEG_OBJ_ASEG__RAMO_RIE foreign key (ID_RIESGO_MONTAJE)
      references RAMO_RIESGO_MONTAJE (ID_RIESGO_MONTAJE)
      on delete restrict on update restrict;

alter table OBJ_ASEG_RESPONSABILIDAD
   add constraint FK_OBJ_ASEG_OBJ_ASEG__RAMO_RES foreign key (ID_RESPONSABILIDAD)
      references RAMO_RESPONSABILIDAD_CIVIL (ID_RESPONSABILIDAD)
      on delete restrict on update restrict;

alter table OBJ_ASEG_ROBO
   add constraint FK_OBJ_ASEG_ROBO_OBJE_RAMO_ROB foreign key (ID_ROBO)
      references RAMO_ROBO_ASALTO (ID_ROBO)
      on delete restrict on update restrict;

alter table OBJ_ASEG_ROTURA
   add constraint FK_OBJ_ASEG_OBJ_ASEG__RAMO_ROT foreign key (ID_ROTURA)
      references RAMO_ROTURA_MAQUINARIA (ID_ROTURA)
      on delete restrict on update restrict;

alter table OBJ_ASEG_TRANSPORTE
   add constraint FK_OBJ_ASEG_OBJ_ASEG__RAMO_TRA foreign key (ID_TRANSPORTE)
      references RAMO_TRANSPORTE (ID_TRANSPORTE)
      on delete restrict on update restrict;

alter table PLAN_ASM
   add constraint FK_PLAN_ASM_RELATIONS_RAMO_ASI foreign key (ID_AST_MEDICA)
      references RAMO_ASISTENCIA_MEDICA (ID_AST_MEDICA)
      on delete restrict on update restrict;

alter table POLIZA
   add constraint FK_POLIZA_POLIZA_PA_PAGO_POL foreign key (ID_PAGO_POLIZA)
      references PAGO_POLIZA (ID_PAGO_POLIZA)
      on delete restrict on update restrict;

alter table POLIZA
   add constraint FK_POLIZA_RELATIONS_CLIENTE foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE)
      on delete restrict on update restrict;

alter table RAMO_ACCIDENTES_PERSONALES
   add constraint FK_RAMO_ACC_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_AGROPECUARIO
   add constraint FK_RAMO_AGR_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_ASEGURADORA
   add constraint FK_RAMO_ASE_AEGURADOR_ASEGURAD foreign key (ID_ASEGURADORA)
      references ASEGURADORA (ID_ASEGURADORA)
      on delete restrict on update restrict;

alter table RAMO_ASEGURADORA
   add constraint FK_RAMO_ASE_RAMO_RA_RAMO foreign key (ID_RAMO)
      references RAMO (ID_RAMO)
      on delete restrict on update restrict;

alter table RAMO_ASISTENCIA_MEDICA
   add constraint FK_RAMO_ASI_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_BUENA_CAL_MAT
   add constraint FK_RAMO_BUE_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_BUEN_USO_ANT
   add constraint FK_RAMO_BUE_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_CASCO_AEREO
   add constraint FK_RAMO_CAS_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_CASCO_MARITIMO
   add constraint FK_RAMO_CAS_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_CUMPLIMIENTO_CONTRATO
   add constraint FK_RAMO_CUM_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_DINERO_VALORES
   add constraint FK_RAMO_DIN_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_EQUIPO_ELECTRONICO
   add constraint FK_RAMO_EQU_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_EQUIPO_MAQUINARIA
   add constraint FK_RAMO_EQU_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_FIDELIDAD
   add constraint FK_RAMO_FID_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_GARANTIA_ADUANERA
   add constraint FK_RAMO_GAR_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_INCENDIO_LINEAS_ALIADAS
   add constraint FK_RAMO_INC_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_LC_INCENDIO
   add constraint FK_RAMO_LC__POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_LC_ROT_MAQ
   add constraint FK_RAMO_LC__POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_RESPONSABILIDAD_CIVIL
   add constraint FK_RAMO_RES_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_RIESGOS_ESP
   add constraint FK_RAMO_RIE_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_RIESGO_CONTRATISTA
   add constraint FK_RAMO_RIE_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_RIESGO_MONTAJE
   add constraint FK_RAMO_RIE_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_ROBO_ASALTO
   add constraint FK_RAMO_ROB_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_ROTURA_MAQUINARIA
   add constraint FK_RAMO_ROT_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_SOAT
   add constraint FK_RAMO_SOA_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_TRANSPORTE
   add constraint FK_RAMO_TRA_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_VEHICULOS
   add constraint FK_RAMO_VEH_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table RAMO_VIDA
   add constraint FK_RAMO_VID_POLIZA_RA_POLIZA foreign key (ID_POLIZA)
      references POLIZA (ID_POLIZA)
      on delete restrict on update restrict;

alter table ROL
   add constraint FK_ROL_USUARIO_R_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table ROL_MENU
   add constraint FK_ROL_MENU_MENU_ROLE_MENU foreign key (ID_MENU)
      references MENU (ID_MENU)
      on delete restrict on update restrict;

alter table ROL_MENU
   add constraint FK_ROL_MENU_ROL_MENUS_ROL foreign key (ID_ROL)
      references ROL (ID_ROL)
      on delete restrict on update restrict;

