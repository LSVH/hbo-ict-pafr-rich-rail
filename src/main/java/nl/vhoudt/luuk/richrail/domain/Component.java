package nl.vhoudt.luuk.richrail.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Component extends Entity {
    @NonNull
    @Getter
    private Integer order;

    @NonNull
    @Getter
    private Type type;
}
