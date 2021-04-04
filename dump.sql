/*
 * SCHEMAS
 */
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

/*
 * CONSTRAINTS
 */
alter table components
    add constraint fk_components_to_trains
    foreign key (train_id)
    references trains (id);

alter table components
    add constraint fk_components_to_types
    foreign key (type_id)
    references types (id);

alter table type_attributes
    add constraint fk_type_attributes_to_types
    foreign key (type_id)
    references types (id);

alter table type_attributes
    add constraint fk_type_attributes_to_type_attribute_keys
    foreign key (key_id)
    references type_attribute_keys (id);

/*
 * DATA
 */
insert into trains (title) VALUES
    ('Inter-City'),
    ('Freighter');

insert into types (title) VALUES
    ('Cabin'),
    ('Tanker');

insert into components (train_id, spot, type_id) VALUES
    (1, 1, 1), (1, 2, 1), (1, 3, 1), (1, 4, 1),
    (2, 1, 2), (2, 2, 2), (2, 3, 2), (2, 4, 2);

insert into type_attribute_keys (title) VALUES
    ('Number of seats'),
    ('Dry weight (kg)'),
    ('Payload capacity (kg)');

insert into type_attributes (type_id, val, key_id) VALUES
    (1, '100', 1), (1, '3000', 2),
    (2, '2500', 3), (2, '1500', 2);