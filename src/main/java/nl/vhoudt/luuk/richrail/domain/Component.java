package nl.vhoudt.luuk.richrail.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import nl.vhoudt.luuk.richrail.common.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@Entity
@Table(name = Component.TABLE_NAME)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
public class Component extends BaseEntity {
    public static final String TABLE_NAME = "components";

    @NonNull
    @Getter
    @Column(name = "spot")
    private Integer spot;

    @NonNull
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "train_id")
    @JsonIgnore
    private Train train;

    @NonNull
    @Getter
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
}
