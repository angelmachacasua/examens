CREATE TABLE IF NOT EXISTS producto ( -- solo para ejercicio
	id			INTEGER PRIMARY KEY AUTOINCREMENT,
	nombres		TEXT	NOT NULL,
    cod  		TEXT	NULL,
    precio		REAL	NULL,
    fecha_ven   datetime NULL,
    date_created datetime default current_timestamp
);

CREATE TABLE IF NOT EXISTS lote ( -- solo para examen
	id			INTEGER PRIMARY KEY AUTOINCREMENT,
	numero		TEXT	NOT NULL,
    direccion  		TEXT	NULL,
    valor_venta		REAL	NULL,
    fecha_venta   datetime NULL,
    date_created datetime default current_timestamp
);


CREATE TABLE IF NOT EXISTS user (
	id		INTEGER PRIMARY KEY AUTOINCREMENT,
	rol		INTEGER	NOT NULL,
	username		TEXT	NOT NULL,
    pin		TEXT	NOT NULL
);


CREATE TABLE IF NOT EXISTS cliente (
	id			INTEGER PRIMARY KEY AUTOINCREMENT,
	nombres		TEXT	NOT NULL,
    infoadic	TEXT	NULL
);


CREATE TABLE IF NOT EXISTS venta (
	id			INTEGER PRIMARY KEY AUTOINCREMENT,
	fecha		datetime	NOT NULL,
    clie_id	    INTEGER		NOT	NULL,
	clie_nom	TEXT			NULL,
	total_base		REAL	NULL,
	total_descto		REAL	NULL,
	total_igv		REAL	NULL,
	total_final		REAL	NULL,
	activo		INTEGER		default 1,

	date_created datetime default current_timestamp,

	FOREIGN KEY (clie_id) REFERENCES cliente (id) 
	ON UPDATE RESTRICT  ON DELETE RESTRICT 
);

CREATE TABLE IF NOT EXISTS item (
	id			INTEGER PRIMARY KEY AUTOINCREMENT,
	nombre		TEXT	NOT NULL,
    precio		REAL	NULL
);

CREATE TABLE IF NOT EXISTS venta_det (
	id			INTEGER PRIMARY KEY AUTOINCREMENT,
	comp_id	INTEGER		NOT	NULL,
	item_id	INTEGER		NOT	NULL,
	cant		REAL		NOT	NULL,
	precio		REAL	NOT NULL,
	igv		    REAL	 NULL,
	descto		REAL	 NULL,
	subtotal		REAL	 NULL, -- st=cant*precio- cant*descto + cant*igv
   
	activo		INTEGER		default 1
	-- ,FOREIGN KEY (comp_id) REFERENCES compra (id) 
	-- ON UPDATE RESTRICT ON DELETE RESTRICT,
	-- ,FOREIGN KEY (item_id) REFERENCES item (id) 
	-- ON UPDATE RESTRICT ON DELETE RESTRICT
);

