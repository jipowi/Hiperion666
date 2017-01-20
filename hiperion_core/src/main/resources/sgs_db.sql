/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     14/12/2013 20:29:34                          */
/*==============================================================*/


drop index ASEGURADORA_PK;

drop table ASEGURADORA;

drop index CATALOGO_PK;

drop table CATALOGO;

drop index RELATIONSHIP_8_FK;

drop index RELATIONSHIP_5_FK;

drop index CLIENTE_PK;

drop table CLIENTE;

drop index CATALOGO_DETALLECATALOGO_FK;

drop index DETALLE_CATALOGO_PK;

drop table DETALLE_CATALOGO;

drop index PERSONA_PK;

drop table PERSONA;

drop index PERSONA_ASEGURADORA2_FK;

drop index PERSONA_ASEGURADORA_FK;

drop index PERSONA_ASEGURADORA_PK;

drop table PERSONA_ASEGURADORA;

drop index PERSONA_USUARIO_FK;

drop index USUARIO_PK;

drop table USUARIO;

/*==============================================================*/
/* Table: ASEGURADORA                                           */
/*==============================================================*/
create table ASEGURADORA (
   ID_ASEGURADORA       SERIAL               not null,
   CODIGO_ASEGURADORA   TEXT                 null,
   NOMBRE               TEXT                 null,
   RUC                  TEXT                 null,
   DIRECION             TEXT                 null,
   EMAIL                TEXT                 null,
   TELEFONO             TEXT                 null,
   constraint PK_ASEGURADORA primary key (ID_ASEGURADORA)
);

/*==============================================================*/
/* Index: ASEGURADORA_PK                                        */
/*==============================================================*/
create unique index ASEGURADORA_PK on ASEGURADORA (
ID_ASEGURADORA
);

/*==============================================================*/
/* Table: CATALOGO                                              */
/*==============================================================*/
create table CATALOGO (
   ID_CATALOGO          SERIAL               not null,
   DESCRIPCION          TEXT                 null,
   constraint PK_CATALOGO primary key (ID_CATALOGO)
);

/*==============================================================*/
/* Index: CATALOGO_PK                                           */
/*==============================================================*/
create unique index CATALOGO_PK on CATALOGO (
ID_CATALOGO
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   ID_CLIENTE           SERIAL               not null,
   ID_USUARIO           INT4                 null,
   ID_PERSONA           INT4                 null,
   TIPO_PERSONA         INT4                 null,
   PROVINCIA            TEXT                 null,
   RAZON_SOCIAL         TEXT                 null,
   DIRECCION_COBRO      TEXT                 null,
   TELEFONO_COBRO       TEXT                 null,
   DIRECCION_OFICINA    TEXT                 null,
   TELEFONO_OFICINA     TEXT                 null,
   EMAIL                TEXT                 null,
   ACTIVIDAD_PROFECION  TEXT                 null,
   GIRO_NEGOCIO         TEXT                 null,
   CIUDAD               TEXT                 null,
   constraint PK_CLIENTE primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Index: CLIENTE_PK                                            */
/*==============================================================*/
create unique index CLIENTE_PK on CLIENTE (
ID_CLIENTE
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on CLIENTE (
ID_USUARIO
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_8_FK on CLIENTE (
ID_PERSONA
);

/*==============================================================*/
/* Table: DETALLE_CATALOGO                                      */
/*==============================================================*/
create table DETALLE_CATALOGO (
   ID_DETALLECATALOGO   SERIAL               not null,
   ID_CATALOGO          INT4                 null,
   COD_DETALLE_CATALOGO TEXT                 null,
   COD_DEP_CATALOGO     TEXT                 null,
   DESCRIPCION          TEXT                 null,
   constraint PK_DETALLE_CATALOGO primary key (ID_DETALLECATALOGO)
);

/*==============================================================*/
/* Index: DETALLE_CATALOGO_PK                                   */
/*==============================================================*/
create unique index DETALLE_CATALOGO_PK on DETALLE_CATALOGO (
ID_DETALLECATALOGO
);

/*==============================================================*/
/* Index: CATALOGO_DETALLECATALOGO_FK                           */
/*==============================================================*/
create  index CATALOGO_DETALLECATALOGO_FK on DETALLE_CATALOGO (
ID_CATALOGO
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   ID_PERSONA           SERIAL               not null,
   TIPOIDENTIFICACION   TEXT                 null,
   IDENTIFICACION       TEXT                 null,
   NOMBRE               TEXT                 null,
   APELLIDO_PATERNO     TEXT                 null,
   APELLIDO_MATERNO     TEXT                 null,
   FECHA_NACIMIENTO     DATE                 null,
   DIRECCION            TEXT                 null,
   TELEFONO_DOMICILLO   TEXT                 null,
   TELEFONO_MOVIL       TEXT                 null,
   EMAIL                TEXT                 null,
   constraint PK_PERSONA primary key (ID_PERSONA)
);

/*==============================================================*/
/* Index: PERSONA_PK                                            */
/*==============================================================*/
create unique index PERSONA_PK on PERSONA (
ID_PERSONA
);

/*==============================================================*/
/* Table: PERSONA_ASEGURADORA                                   */
/*==============================================================*/
create table PERSONA_ASEGURADORA (
   ID_ASEGURADORA       INT4                 not null,
   ID_PERSONA           INT4                 not null,
   constraint PK_PERSONA_ASEGURADORA primary key (ID_ASEGURADORA, ID_PERSONA)
);

/*==============================================================*/
/* Index: PERSONA_ASEGURADORA_PK                                */
/*==============================================================*/
create unique index PERSONA_ASEGURADORA_PK on PERSONA_ASEGURADORA (
ID_ASEGURADORA,
ID_PERSONA
);

/*==============================================================*/
/* Index: PERSONA_ASEGURADORA_FK                                */
/*==============================================================*/
create  index PERSONA_ASEGURADORA_FK on PERSONA_ASEGURADORA (
ID_ASEGURADORA
);

/*==============================================================*/
/* Index: PERSONA_ASEGURADORA2_FK                               */
/*==============================================================*/
create  index PERSONA_ASEGURADORA2_FK on PERSONA_ASEGURADORA (
ID_PERSONA
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   ID_USUARIO           SERIAL               not null,
   ID_PERSONA           INT4                 null,
   NOMBRE_USUARIO       TEXT                 null,
   CLAVE                TEXT                 null,
   CARGO                TEXT                 null,
   constraint PK_USUARIO primary key (ID_USUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
ID_USUARIO
);

/*==============================================================*/
/* Index: PERSONA_USUARIO_FK                                    */
/*==============================================================*/
create  index PERSONA_USUARIO_FK on USUARIO (
ID_PERSONA
);

alter table CLIENTE
   add constraint FK_CLIENTE_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table CLIENTE
   add constraint FK_CLIENTE_RELATIONS_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
      on delete restrict on update restrict;

alter table DETALLE_CATALOGO
   add constraint FK_DETALLE__CATALOGO__CATALOGO foreign key (ID_CATALOGO)
      references CATALOGO (ID_CATALOGO)
      on delete restrict on update restrict;

alter table PERSONA_ASEGURADORA
   add constraint FK_PERSONA__PERSONA_A_ASEGURAD foreign key (ID_ASEGURADORA)
      references ASEGURADORA (ID_ASEGURADORA)
      on delete restrict on update restrict;

alter table PERSONA_ASEGURADORA
   add constraint FK_PERSONA__PERSONA_A_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
      on delete restrict on update restrict;

alter table USUARIO
   add constraint FK_USUARIO_PERSONA_U_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
      on delete restrict on update restrict;

