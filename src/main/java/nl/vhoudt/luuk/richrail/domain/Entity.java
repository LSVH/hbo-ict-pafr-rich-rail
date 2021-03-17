package nl.vhoudt.luuk.richrail.domain;

import org.springframework.data.annotation.Id;

import lombok.Setter;

public abstract class Entity {
    @Id @Setter private Integer id;

    @Override
    public int hashCode() {
        if (this.id != null) {
            return this.id;
        }

        return super.hashCode();
    }
}
