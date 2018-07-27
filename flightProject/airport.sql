drop table airport;

create table airport(
port_continent varchar(5) not null,
port_country varchar2(20)not null,
port_code varchar2(5) primary key not null,
port_name varchar2(20) not null
);

insert into airport (port_continent, port_country, port_code, port_name) values ('asia', 'South Korea', 'ICN', '인천공항');
insert into airport (port_continent, port_country, port_code, port_name) values ('asia', 'South Korea', 'GMP', '김포공항');

commit;