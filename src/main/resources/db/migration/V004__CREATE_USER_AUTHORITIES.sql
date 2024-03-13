
create table if not exists tb_authorities_users(
    id  BIGINT GENERATED ALWAYS AS IDENTITY,
    user_id bigint,
    authority_id bigint,

    constraint fk_user foreign key (user_id) references tb_users(id),
    constraint fk_authority foreign key (authority_id) references tb_authorities(id),

    primary key(id)
)