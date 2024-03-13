create table tb_categories(
    id  BIGINT GENERATED ALWAYS AS IDENTITY,
    name varchar(60) not null,
    primary key (id)

);