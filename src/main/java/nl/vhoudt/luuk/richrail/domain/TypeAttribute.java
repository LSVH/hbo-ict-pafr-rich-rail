package nl.vhoudt.luuk.richrail.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import nl.vhoudt.luuk.richrail.common.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE, onConstructor = @__(@PersistenceConstructor))
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
@Entity
@Table(name = TypeAttribute.TABLE_NAME)
public class TypeAttribute extends BaseEntity {
    public static final String TABLE_NAME = "type_attributes";

    @NonNull
    @Getter
    @Column(name = "val")
    private String value;
    
    @NonNull
    @Getter
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @NonNull
    @Getter
    @ManyToOne
    @JoinColumn(name = "key_id")
    private TypeAttributeKey key;

    @Override
    public String toString() {
        return this.value;
    }
}
