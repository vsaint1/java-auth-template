
create table if not exists tb_authorities(
    id  BIGINT GENERATED ALWAYS AS IDENTITY,
    name varchar(255),
    description varchar(255),

    primary key(id)
)