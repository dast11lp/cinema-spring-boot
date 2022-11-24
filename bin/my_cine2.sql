-- drop database my_cine2;
create database my_cine2;
use my_cine2;

create table movies(
	id_mov int auto_increment,
	name_mov varchar(70) not null unique,
    description_mov text,
    country_mov varchar(50),
    director varchar (50),
    protagonists_mov text,
    language_mov varchar(50),
    poster_mov varchar(255),
    primary key(id_mov)
);
select * from movies;
create table function_movie(
	id_fuc int auto_increment,
	hour_time_mov varchar(5) not null,
    room_fun_mov varchar(255),
    id_mov int,
    foreign key (id_mov) references movies(id_mov),
    primary key (id_fuc)
);

create table users(
	id_use int auto_increment,
    username_use varchar(15) not null unique,
    password_use varchar(60) not null,
    primary key (id_use)
);

create table function_reservation(
	id_fun_res int auto_increment,
    id_fuc int,
    id_use int,
    foreign key (id_fuc) references function_movie(id_fuc),
    foreign key (id_use) references users(id_use) ,
	primary key (id_fun_res)
);

create table function_chair(
	id_fun_cha int auto_increment,
    number_cha int,
	id_fun_mov int,
    id_fun_res int,
    available_fun_cha boolean default true,
    foreign key (id_fun_mov) references function_movie(id_fuc),
	foreign key (id_fun_res) references function_reservation(id_fun_res),
    primary key(id_fun_cha)
);


create table card (
	id_car int auto_increment,
    card_name varchar (20),
    number_car varchar(50) not null unique,
    expiration_date_car date not null,
    cvv_csc_car varchar(45) not null unique,
    id_use int,
    foreign key (id_use) references users (id_use),
    primary key (id_car)
);

create table authorities ( -- roles
	id_auth int auto_increment not null,
	id_use int not null,
	authority varchar(45) not null unique,
	constraint fk_authorities_users
	foreign key(id_use) references users(id_use) on delete cascade on update cascade,
	primary key(id_auth)
);


insert into movies 
(name_mov, description_mov, country_mov, director_mov, protagonists_mov, language_mov, poster_mov) values 
("El Señor de los Anillos la Comunidad del Anillo", 
"En la Tierra Media, el Señor Oscuro Sauron forjó los Grandes Anillos del Poder y creó uno con el poder de esclavizar a toda la Tierra Media. Frodo Bolsón es un hobbit al que su tío Bilbo hace portador del poderoso Anillo Único con la misión de destruirlo. Acompañado de sus amigos, Frodo emprende un viaje hacia Mordor, el único lugar donde el anillo puede ser destruido. Sin embargo, Sauron ordena la persecución del grupo para recuperar el anillo y acabar con la Tierra Media.",
"Estados Unidos",
"Peter Jackson",
"Elijah Wood, Viggo Mortensen, Ian McKellen",
"Español Latino",
"https://m.media-amazon.com/images/M/MV5BMzgyNjdjOWMtMjAyYy00NzQ4LWIwYTQtZDk2ZDQzYWVlN2IwXkEyXkFqcGdeQXVyMTYzMDM0NTU@._V1_.jpg"
), 

("Las Crónicas de Narnia el León la Bruja y el Ropero", 
"Durante la Segunda Guerra Mundial, cuatro hermanos ingleses son enviados a una casa en el campo donde van a estar a salvo de los bombardeos. Un día, Lucy, la hermana pequeña, descubre un armario que la transporta a un mundo mágico llamado Narnia. Después de volver, pronto vuelve a Narnia con sus hermanos, Peter, Edmund y Susan. Allí, los cuatro se unirán al león mágico Aslan y lucharán contra la Bruja Blanca.",
"Reino Unido",
"Andrew Adamson",
"Anna Popplewell, William Moseley, Skandar Keynes, Liam Neeson, Georgie Henley",
"Español Latino",
"https://m.media-amazon.com/images/M/MV5BN2YzOTk3MmItOTA5NS00ZjQxLTllM2YtNTZjNmVkZWFiZTdlXkEyXkFqcGdeQXVyMTYzMDM0NTU@._V1_FMjpg_UY480_.jpg"
), 

("Harry Potter la Piedra Filosofal", 
"El día en que cumple once años, Harry Potter descubre que es hijo de dos conocidos hechiceros, de los que ha heredado poderes mágicos. Deberá acudir entonces a una famosa escuela de magia y hechicería: Howards.",
"Reino Unido",
"Chris Columbus",
"Daniel Radcliffe, Emma Watson, Rupert Grint",
"Español Latino",
"https://m.media-amazon.com/images/M/MV5BMzFiZjhjODUtMWJhZi00ZDk5LThjY2ItZjNjYjc0OGVjY2FmXkEyXkFqcGdeQXVyMTYzMDM0NTU@._V1_.jpg");


insert into function_movie(hour_time_mov, id_mov) 
values 
("10:55",1),
("07:35",1),
("04:50",1),
("10:55",2),
("07:35",2),
("04:50",3),
("10:55",3),
("07:35",3);



insert into users( username_use, password_use) values ("daniel@mail.com", "12345");


insert into function_chair(id_fun_mov,number_cha)
values
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),
(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),
(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),
(1,31),(1,32),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),
(1,41),(1,42),(1,43),(1,44),(1,45),(1,46),(1,47),(1,48),(1,49),(1,50),
(1,51),(1,52),(1,53),(1,54),(1,55),(1,56),(1,57),(1,58),(1,59),(1,60);

insert into function_chair(id_fun_mov,number_cha)
values
(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,8),(2,9),(2,10),
(2,11),(2,12),(2,13),(2,14),(2,15),(2,16),(2,17),(2,18),(2,19),(2,20),
(2,21),(2,22),(2,23),(2,24),(2,25),(2,26),(2,27),(2,28),(2,29),(2,30),
(2,31),(2,32),(2,33),(2,34),(2,35),(2,36),(2,37),(2,38),(2,39),(2,40),
(2,41),(2,42),(2,43),(2,44),(2,45),(2,46),(2,47),(2,48),(2,49),(2,50),
(2,51),(2,52),(2,53),(2,54),(2,55),(2,56),(2,57),(2,58),(2,59),(2,60);

insert into function_chair(id_fun_mov,number_cha)
values
(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8),(3,9),(3,10),
(3,11),(3,12),(3,13),(3,14),(3,15),(3,16),(3,17),(3,18),(3,19),(3,20),
(3,31),(3,32),(3,33),(3,34),(3,35),(3,36),(3,37),(3,38),(3,39),(3,30),
(3,1),(3,32),(3,33),(3,34),(3,35),(3,36),(3,37),(3,38),(3,39),(3,40),
(3,41),(3,42),(3,43),(3,44),(3,45),(3,46),(3,47),(3,48),(3,49),(3,50),
(3,51),(3,52),(3,53),(3,54),(3,55),(3,56),(3,57),(3,58),(3,59),(3,60);

insert into function_chair(id_fun_mov,number_cha)
values
(4,1),(4,4),(4,3),(4,4),(4,5),(4,6),(4,7),(4,8),(4,9),(4,10),
(4,11),(4,12),(4,13),(4,14),(4,15),(4,16),(4,17),(4,18),(4,19),(4,20),
(4,21),(4,22),(4,23),(4,24),(4,25),(4,26),(4,27),(4,28),(4,29),(4,30),
(4,31),(4,32),(4,33),(4,34),(4,35),(4,36),(4,37),(4,38),(4,39),(4,40),
(4,41),(4,42),(4,43),(4,44),(4,45),(4,46),(4,47),(4,48),(4,49),(4,50),
(4,51),(4,52),(4,53),(4,54),(4,55),(4,56),(4,57),(4,58),(4,59),(4,60);

insert into function_chair(id_fun_mov,number_cha)
values
(5,1),(5,2),(5,3),(5,4),(5,5),(5,6),(5,7),(5,8),(5,9),(5,10),
(5,11),(5,12),(5,13),(5,14),(5,15),(5,16),(5,17),(5,18),(5,19),(5,20),
(5,51),(5,52),(5,53),(5,54),(5,55),(5,56),(5,57),(5,58),(5,59),(5,30),
(5,31),(5,32),(5,33),(5,34),(5,35),(5,36),(5,37),(5,38),(5,39),(5,40),
(5,41),(5,42),(5,43),(5,44),(5,45),(5,46),(5,47),(5,48),(5,49),(5,50),
(5,51),(5,52),(5,53),(5,54),(5,55),(5,56),(5,57),(5,58),(5,59),(5,60);


insert into function_chair(id_fun_mov,number_cha)
values
(6,1),(6,2),(6,3),(6,4),(6,5),(6,6),(6,7),(6,8),(6,9),(6,10),
(6,11),(6,12),(6,13),(6,14),(6,15),(6,16),(6,17),(6,18),(6,19),(6,20),
(6,21),(6,22),(6,23),(6,24),(6,25),(6,26),(6,27),(6,28),(6,29),(6,30),
(6,31),(6,32),(6,33),(6,34),(6,35),(6,36),(6,37),(6,38),(6,39),(6,40),
(6,41),(6,42),(6,43),(6,44),(6,45),(6,46),(6,47),(6,48),(6,49),(6,50),
(6,51),(6,52),(6,53),(6,54),(6,55),(6,56),(6,57),(6,58),(6,59),(6,60); 

insert into function_chair(id_fun_mov,number_cha)
values
(7,1),(7,2),(7,3),(7,4),(7,5),(7,7),(7,6),(7,8),(7,9),(7,10),
(7,11),(7,12),(7,13),(7,14),(7,15),(7,16),(7,17),(7,18),(7,19),(7,20),
(7,21),(7,22),(7,23),(7,24),(7,25),(7,26),(7,27),(7,28),(7,29),(7,30),
(7,31),(7,32),(7,33),(7,34),(7,35),(7,36),(7,37),(7,38),(7,39),(7,40),
(7,41),(7,42),(7,43),(7,44),(7,45),(7,46),(7,47),(7,48),(7,49),(7,50),
(7,51),(7,52),(7,53),(7,54),(7,55),(7,56),(7,57),(7,58),(7,59),(7,60); 

insert into function_chair(id_fun_mov,number_cha)
values
(8,1),(8,2),(8,3),(8,4),(8,5),(8,8),(8,6),(8,7),(8,9),(8,10),
(8,11),(8,12),(8,13),(8,14),(8,15),(8,16),(8,17),(8,18),(8,19),(8,20),
(8,21),(8,22),(8,23),(8,24),(8,25),(8,26),(8,27),(8,28),(8,29),(8,30),
(8,31),(8,32),(8,33),(8,34),(8,35),(8,36),(8,37),(8,38),(8,39),(8,40),
(8,41),(8,42),(8,43),(8,44),(8,45),(8,46),(8,47),(8,48),(8,49),(8,50),
(8,51),(8,52),(8,53),(8,54),(8,55),(8,56),(8,57),(8,58),(8,59),(8,60); 


insert into function_reservation(id_fuc, id_use)
values(1,1);
insert into function_reservation(id_fuc, id_use)
values(6,1);


















