
drop database if exists BD_Reserva;

create database BD_Reserva;

use BD_Reserva;

create table tb_categoria
(
 idcategoria char(5) not null primary key,
 nombrecategoria varchar(30),
 descripcion varchar(50),
 estado boolean
);

create table tb_proveedores
(
  idproveedor char(5) not null primary key,
  nombreEmp varchar(50),
  nombreCargo varchar(50),
  direccion varchar(50),
  telefono varchar(20),
  estado boolean
);

create table tb_productos
(
  idprod char(5) not null primary key,
  nombrepro varchar(30),
  idproveedor char(5),
  idcategoria char(5),
  precio decimal (8,2),
  stock int,
  estado boolean,
  foreign key (idproveedor) references tb_proveedores(idproveedor),
  foreign key (idcategoria) references tb_categoria(idcategoria)

);

create table tb_distritos
(
  iddistrito int primary key,
  nombredistrito varchar(50) not null

);

create table tb_tipo_usu
(
   idtipousu int primary key,
   destipousu varchar(30) not null

);

create table tb_usuarios
(
  idusuario char(5) not null primary key,
  clave varchar(10) not null,
  nombreusu varchar(30),
  apepaterno varchar(30),
  apematerno varchar(30),
  fechanac date,
  correo varchar(30),
  direccion varchar(50),
  iddistrito int,
  telefono varchar(20),
  idtipousu int not null,
  estado boolean,
  foreign key (iddistrito) references tb_distritos(iddistrito),
  foreign key (idtipousu) references tb_tipo_usu(idtipousu)
);

create table tb_pedidos
(
  idpedido char(7) not null,
  idprod char(5) not null,
  cantidad int,
  precio decimal(8,2),
  
  foreign key (idprod) references tb_productos(idprod)

);

create table tb_detalle_pedido
(
  iddetalle char(7) not null primary key,
  idpedido char(7) not null,
  idusuario char(5) not null,
  distrito int,
  direccion varchar(50),
  fechapedido date,
  fechaentrega date,
  cantidadtotal int,
  preciototal decimal(8,2),
  
  foreign key (idusuario) references tb_usuarios(idusuario)

);


insert into tb_categoria values('D0001','Paracas','Pueblo costeño del departamento de Ica',true);
insert into tb_categoria values('D0002','Lunahuana','Pueblo famoso por sus deportes extremo',true);
insert into tb_categoria values('D0003','Huaral','Pueblo del Norte',true);
insert into tb_categoria values('D0004','Churin','Pueblo Famoso por sus baños termales',true);
insert into tb_categoria values('D0005','San Jeronimo','Pueblo de las 10 Cataratas',true);

select *from tb_categoria;

insert into tb_proveedores values('PR001','Beteta','Humberto Lazo','Av.Lima','12345678',true);
insert into tb_proveedores values('PR002','Soyus','Mary Umeres','Av.Grau','12345678',true);
insert into tb_proveedores values('PR003','VIP Peru','Jenny Villanueva','Av.Arequipa','12345678',true);

select *from tb_proveedores;

insert into tb_productos values('P0001','Paracas-Ica','PR001','D0001',15,50,true);
insert into tb_productos values('P0002','Paracas-Ica-Nazca','PR001','D0001',20,50,true);
insert into tb_productos values('P0003','Songos','PR002','D0005',10,50,true);
insert into tb_productos values('P0004','Huanano','PR002','D0005',15,50,true);
insert into tb_productos values('P0005','Huaral-Chancay','PR003','D0003',15,50,true);
insert into tb_productos values('P0006','Churin','PR003','D0004',20,50,true);
insert into tb_productos values('P0007','Baños de Tingo','PR003','D0004',10,50,true);
insert into tb_productos values('P0008','Lunahuana Gastronómico','PR003','D0002',15,50,true);
insert into tb_productos values('P0009','Lunahuana Aventura','PR003','D0002',15,50,true);
insert into tb_productos values('P0010','Ica Nazca','PR003','D0001',20,50,true);
insert into tb_productos values('P0011','Ya no sé','PR003','D0005',20,50,false);

select * from tb_productos;

insert into tb_distritos VALUES (1,'Ancon');
insert into tb_distritos VALUES (2,'Ate');
insert into tb_distritos VALUES (3,'Barranco');
insert into tb_distritos VALUES (4,'Breña');
insert into tb_distritos VALUES (5,'Carabayllo');
insert into tb_distritos VALUES (6,'Chaclacayo');
insert into tb_distritos VALUES (7,'Chorrillos');
insert into tb_distritos VALUES (8,'Cieneguilla');
insert into tb_distritos VALUES (9,'Comas');
insert into tb_distritos VALUES (10,'El Agustino');
insert into tb_distritos VALUES (11,'Independencia');
insert into tb_distritos VALUES (12,'Jesus Maria');
insert into tb_distritos VALUES (13,'La Molina');
insert into tb_distritos VALUES (14,'La Victoria');
insert into tb_distritos VALUES (15,'Lima (Cercado)');
insert into tb_distritos VALUES (16,'Lince');
insert into tb_distritos VALUES (17,'Los Olivos');
insert into tb_distritos VALUES (18,'Lurigancho');
insert into tb_distritos VALUES (19,'Lurin');
insert into tb_distritos VALUES (20,'Magdalena del Mar');
insert into tb_distritos VALUES (21,'Miraflores');
insert into tb_distritos VALUES (22,'Pachacamac');
insert into tb_distritos VALUES (23,'Pucusana');
insert into tb_distritos VALUES (24,'Pueblo Libre');
insert into tb_distritos VALUES (25,'Puente Piedra');
insert into tb_distritos VALUES (26,'Punta Hermosa');
insert into tb_distritos VALUES (27,'Punta Negra');
insert into tb_distritos VALUES (28,'Rimac');
insert into tb_distritos VALUES (29,'San Bartolo');
insert into tb_distritos VALUES (30,'San Borja');
insert into tb_distritos VALUES (31,'San Isidro');
insert into tb_distritos VALUES (32,'San Juan de Lurigancho');
insert into tb_distritos VALUES (33,'San Juan de Miraflores');
insert into tb_distritos VALUES (34,'San Luis');
insert into tb_distritos VALUES (35,'San Martin de Porres');
insert into tb_distritos VALUES (36,'San Miguel');
insert into tb_distritos VALUES (37,'Santa Anita');
insert into tb_distritos VALUES (38,'Santa Maria del Mar');
insert into tb_distritos VALUES (39,'Santa Rosa');
insert into tb_distritos VALUES (40,'Santiago de Surco');
insert into tb_distritos VALUES (41,'Surquillo');
insert into tb_distritos VALUES (42,'Villa El Salvador');
insert into tb_distritos VALUES (43,'Villa MarÃ­a del Triunfo');
insert into tb_distritos VALUES (44,'Callao (Cercado)');
insert into tb_distritos VALUES (45,'Bellavista');
insert into tb_distritos VALUES (46,'Carmen de La Legua-Reynoso');
insert into tb_distritos VALUES (47,'La Perla');
insert into tb_distritos VALUES (48,'La Punta');
insert into tb_distritos VALUES (49,'Chosica');
insert into tb_distritos VALUES (50,'Ventanilla');

select * from tb_distritos;
select * from tb_distritos;

insert into tb_tipo_usu values(1,'Admin');
insert into tb_tipo_usu values(2,'Cliente');

select * from tb_tipo_usu;

insert into tb_usuarios values('ADMIN','1234','Admin','Admin','Admin','2000/01/01','admin@gmail.com','Av.Lima 1234',10,12345678,1,true);
insert into tb_usuarios values('U0001','1111','Sebas','Tito','Vargas','2005/05/05','juan@gmail.com','Av.Los Campos 1234',20,12345678,2,true);
insert into tb_usuarios values('U0002','pedro','Pedro','Picapiedra','Picaroca','2010/10/10','pedro@gmail.com','Av.Buenos Aires 1234',30,12345678,2,true);
insert into tb_usuarios values('U0003','prueba','Prueba','Prueba','Prueba','2010/10/10','prueba@gmail.com','prueba',30,12345678,2,false);


select * from tb_usuarios;

insert into tb_pedidos values ('PE00001','P0001',10,150);
insert into tb_pedidos values ('PE00001','P0002',20,400);
insert into tb_pedidos values ('PE00002','P0003',5,50);
insert into tb_pedidos values ('PE00002','P0004',15,225);

select * from tb_pedidos;


insert into tb_detalle_pedido values('DP00001','PE00001','U0001',20,'Av.Los Campos 1234','2019/01/10','2019/02/10',30,550);
insert into tb_detalle_pedido values('DP00002','PE00002','U0002',30,'Av.Buenos Aires 1234','2019/03/20','2019/04/20',20,275);

select * from tb_detalle_pedido;

select count(*) as numero from tb_usuarios

DELIMiTER $$
create procedure usp_validaAcceso2 (usr char(5), pas varchar(10))
begin
select * from tb_usuarios where idusuario = usr and clave = pas and estado=true;
end$$
DELIMiTER ;

call usp_validaAcceso2 ('U0001','juan')

DELIMiTER $$
create procedure usp_validaAcceso3 (usr char(5), pas varchar(10))
begin
select idusuario,clave,nombreusu,apepaterno,apematerno,fechanac,correo,direccion,nombredistrito,telefono from
tb_usuarios u inner join tb_distritos d on u.iddistrito=d.iddistrito 
where idusuario = usr and clave = pas and estado=true;
end$$
DELIMiTER ;

call usp_validaAcceso3 ('U0005','prueba');

select * from tb_usuarios;

DELIMiTER $$
create procedure usp_validaAcceso4 (usr char(5), pas varchar(10))
begin
select idusuario,clave,nombreusu,apepaterno,apematerno,fechanac,correo,direccion,nombredistrito,telefono,idtipousu from
tb_usuarios u inner join tb_distritos d on u.iddistrito=d.iddistrito 
where idusuario = usr and clave = pas and estado=true;
end$$
DELIMiTER ;

call usp_validaAcceso4 ('U0001','juan');

DELIMiTER $$
create procedure usp_validaAcceso5 (usr char(5), pas varchar(10))
begin
select idusuario,clave,nombreusu,apepaterno,apematerno,fechanac,correo,direccion,u.iddistrito,nombredistrito,telefono,idtipousu from
tb_usuarios u inner join tb_distritos d on u.iddistrito=d.iddistrito 
where idusuario = usr and clave = pas and estado=true;
end$$
DELIMiTER ;

call usp_validaAcceso5 ('U0001','juan');


DELIMiTER $$
create procedure usp_ProductoRe ()
begin
select idprod,nombrepro,nombreEmp,nombrecategoria,precio,stock from tb_productos p inner join tb_proveedores pro
on p.idproveedor=pro.idproveedor inner join tb_categoria c on p.idcategoria=c.idcategoria where p.estado=true;
end$$
DELIMiTER ;

call usp_ProductoRe();

select * from tb_productos;


DELIMiTER $$
create procedure usp_ProductoRexcat (cat char(5))
begin
select idprod,nombrepro,nombreEmp,nombrecategoria,precio,stock from tb_productos p inner join tb_proveedores pro
on p.idproveedor=pro.idproveedor inner join tb_categoria c on p.idcategoria=c.idcategoria where p.idcategoria=cat and p.estado=true; 
end$$
DELIMiTER ;

call usp_ProductoRexcat('C0004');


DELIMITER $$
create procedure usp_UsuarioRe()
begin
select idusuario,nombreusu,apepaterno,apematerno,fechanac,correo,direccion,nombredistrito,telefono,destipousu from
tb_usuarios u inner join tb_distritos d on u.iddistrito=d.iddistrito inner join tb_tipo_usu t on u.idtipousu=t.idtipousu
where destipousu!='Admin' and  estado=true;
end$$
DELIMITER ;

call usp_UsuarioRe();

drop procedure usp_UsuarioRe;

select * from tb_usuarios where estado=false;

DELIMITER $$
create procedure usp_UsuarioRextipo(tipo int)
begin
select idusuario,nombreusu,apepaterno,apematerno,fechanac,correo,direccion,nombredistrito,telefono,destipousu from
tb_usuarios u inner join tb_distritos d on u.iddistrito=d.iddistrito inner join tb_tipo_usu t on u.idtipousu=t.idtipousu
where u.idtipousu=tipo and estado=true;
end$$
DELIMITER ;

call usp_UsuarioRextipo(2);

select * from tb_productos where idprod='P0001';

SELECT COUNT(*) as numero FROM tb_productos;


select * from tb_usuarios;
select * from tb_productos;

select *from tb_distritos;

select * from tb_categoria;
select * from tb_proveedores;

select * from tb_proveedores;
select * from tb_proveedores where idproveedor='PR004';
