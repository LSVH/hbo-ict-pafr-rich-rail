create table trains (
    id int generated always as identity primary key,
    title varchar not null
);

create table types (
    id int generated always as identity primary key,
    title varchar not null
);

create table type_attributes (
    id int generated always as identity primary key,
    type_id int not null,
    key_id int not null,
    val varchar not null
);

create table type_attribute_keys (
    id int generated always as identity primary key,
    title varchar not null
);

create table components (
    id int generated always as identity primary key,
    spot int default 0,
    train_id int not null,
    type_id int not null
);

