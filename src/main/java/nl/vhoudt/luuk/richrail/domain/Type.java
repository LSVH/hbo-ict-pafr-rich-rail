package nl.vhoudt.luuk.richrail.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class Type extends Entity {
    @NonNull
    @Getter
    private String name;

    @Getter
    private Integer numberOfSeats = 0;

    @Getter
    private Integer payloadCapacity = 0;
}
