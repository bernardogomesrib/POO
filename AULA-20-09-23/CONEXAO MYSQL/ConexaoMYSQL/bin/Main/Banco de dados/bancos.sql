use test;
create table usuario(
    cpf char(14) PRIMARY KEY,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null
);

CREATE Table produto(
    codigo int PRIMARY KEY,
    descricao TINYtext not null,
    valor DECIMAL(10,2) not null
);