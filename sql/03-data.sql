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