create table trains (
    train_id int generated always as identity primary key
    train_name varchar not null,
);

create table types (
    type_id int generated always as identity primary key,
    type_name varchar not null,
    type_number_of_seats int default 0,
    type_payload_capacity int default 0
);

create table components (
    component_id int generated always as identity primary key,
    component_order int default 0,
    component_train int not null,
    component_type int not null
);

alter table components
    add constraint fk_components_trains
    foreign key (component_trains)
    references trains (train_id);

alter table components
    add constraint fk_components_types
    foreign key (component_type)
    references types (type_id);