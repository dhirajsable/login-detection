create table public.table_name
(
	id serial not null,
	userid int not null,
	devicedetails varchar(100),
	location varchar(100),
	lastloggedin timestamp,
	createddate timestamp default now(),
	updatedate timestamp default now()
);

create unique index table_name_id_uindex
	on public.table_name (id);

alter table public.table_name
	add constraint table_name_pk
		primary key (id);

