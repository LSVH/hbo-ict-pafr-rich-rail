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