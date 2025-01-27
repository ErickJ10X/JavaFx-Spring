create table productos(

                        codigo serial not null,
                        nombre varchar(100) not null,
                        cantidad integer not null,
                        descripcion varchar(100) not null,

                        primary key (codigo)

);