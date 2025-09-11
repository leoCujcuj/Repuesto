-- Drop database if exists DB_Repuesto;
create database DB_Repuesto;
use DB_Repuesto;

Create table cliente (
    id_cliente int auto_increment,
    nombre varchar(100) not null,
    telefono varchar(20) unique,
    correo varchar(100) unique not null,
    direccion varchar(150),
    primary key pk_id_cliente(id_cliente)
);

Insert into cliente (nombre, telefono, correo, direccion) values
('Carlos López', '555-1234', 'carlos@gmail.com', 'Zona 1'),
('Ana Martínez', '555-5678', 'ana@gmail.com', 'Zona 5'),
('Luis Pérez', '555-8765', 'luis@gmail.com', 'Zona 11'),
('María González', '555-3333', 'maria@gmail.com', 'Mixco'),
('Pedro Ramírez', '555-9999', 'pedro@gmail.com', 'Villa Nueva'),
('Jorge Herrera', '555-1122', 'jorge@gmail.com', 'San Cristóbal'),
('Sofía Morales', '555-2211', 'sofia@gmail.com', 'Amatitlán'),
('Fernando Castro', '555-8899', 'fernando@gmail.com', 'Antigua'),
('Lucía Díaz', '555-4455', 'lucia@gmail.com', 'Chimaltenango'),
('Daniel Ortiz', '555-6677', 'daniel@gmail.com', 'Zona 10');

Create table empleado (
    id_empleado int auto_increment,
    nombre varchar(100) not null,
    puesto varchar(50),
    salario decimal(10,2),
    primary key pk_id_empleado(id_empleado)
);

Insert into empleado (nombre, puesto, salario) values
('Juan Morales', 'Vendedor', 3500),
('Karla Pérez', 'Vendedor', 3400),
('Miguel Ruiz', 'Cajero', 3200),
('Andrea López', 'Administrador', 5000),
('Roberto Díaz', 'Bodega', 3000),
('Laura García', 'Bodega', 2900),
('Diego Fernández', 'Vendedor', 3600),
('Carmen Soto', 'Cajero', 3100),
('Pablo Torres', 'Bodega', 2800),
('Elena Ramírez', 'Vendedor', 3550);

Create table proveedor (
    id_proveedor int auto_increment,
    nombre varchar(100) not null,
    telefono varchar(20) unique,
    correo varchar(100) unique,
    direccion varchar(150),
    primary key pk_id_proveedor(id_proveedor)
);

Insert into proveedor (nombre, telefono, correo, direccion) values
('Repuestos Centro', '444-1111', 'ventas@centro.com', 'Zona 1'),
('Autopartes GT', '444-2222', 'info@autopartesgt.com', 'Zona 8'),
('Mecánica Total', '444-3333', 'contacto@total.com', 'Villa Nueva'),
('Motores y Más', '444-4444', 'motores@gmail.com', 'Chimaltenango'),
('Distribuidora Norte', '444-5555', 'ventas@norte.com', 'Mixco'),
('Automanía', '444-6666', 'info@automania.com', 'Zona 11'),
('Importadora Carros', '444-7777', 'import@carros.com', 'Antigua'),
('Full Repuestos', '444-8888', 'ventas@full.com', 'Zona 5'),
('GuateParts', '444-9999', 'info@guateparts.com', 'Zona 10'),
('CarFix', '444-0000', 'ventas@carfix.com', 'Amatitlán');

Create table producto (
    id_producto int auto_increment,
    nombre varchar(100) not null,
    precio decimal(10,2),
    stock int,
    id_proveedor int,
    primary key pk_id_producto(id_producto),
    constraint fk_id_proveedor foreign key (id_proveedor) 
		references proveedor(id_proveedor)
);

Insert into producto (nombre, precio, stock, id_proveedor) values
('Filtro de aceite', 75, 50, 1),
('Pastillas de freno', 250, 40, 2),
('Bujía', 40, 200, 3),
('Batería 12V', 950, 15, 4),
('Amortiguador', 600, 20, 5),
('Filtro de aire', 120, 60, 6),
('Aceite 10W40', 180, 100, 7),
('Correa de distribución', 850, 12, 8),
('Radiador', 1100, 8, 9),
('Balatas traseras', 270, 35, 10);

Create table factura (
    id_factura int auto_increment,
    fecha date,
    id_cliente int,
    id_empleado int,
    total decimal(10,2),
    primary key pk_id_factura(id_factura),
    constraint fk_id_cliente foreign key (id_cliente) 
		references cliente(id_cliente),
    constraint fk_id_empleado foreign key (id_empleado) 
		references empleado(id_empleado)
);

Insert into factura (fecha, id_cliente, id_empleado, total) values
('2025-09-01', 1, 1, 500),
('2025-09-02', 2, 2, 750),
('2025-09-03', 3, 3, 1200),
('2025-09-04', 4, 4, 980),
('2025-09-05', 5, 5, 1500),
('2025-09-06', 6, 6, 340),
('2025-09-07', 7, 7, 875),
('2025-09-08', 8, 8, 640),
('2025-09-09', 9, 9, 2150),
('2025-09-10', 10, 10, 495);