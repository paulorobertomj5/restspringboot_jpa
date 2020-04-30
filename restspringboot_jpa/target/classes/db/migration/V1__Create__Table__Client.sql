create table client
(
	id serial not null,
	first_name varchar(80) NOT NULL,
	last_name varchar(80) NOT NULL,
	cpf varchar(11) NOT NULL,
	birth_date DATE NOT NULL,
	address varchar(100) NOT NULL,
	gender varchar(1) NOT NULL
);

create unique index client_id_uindex
	on client (id);

alter table client
	add constraint client_pk
		primary key (id);


ALTER SEQUENCE client_id_seq RESTART WITH 3;