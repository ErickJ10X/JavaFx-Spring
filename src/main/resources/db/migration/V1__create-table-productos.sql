create table productos(

                        id serial not null,
                        codigo integer not null,
                        nombre varchar(100) not null,
                        cantidad integer not null,
                        descripcion varchar(100),

                        primary key (id)

);