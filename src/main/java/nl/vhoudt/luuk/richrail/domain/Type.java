package nl.vhoudt.luuk.richrail.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nl.vhoudt.luuk.richrail.common.BaseEntity;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
@Entity
@Table(name = Type.TABLE_NAME)
public class Type extends BaseEntity {
    public static final String TABLE_NAME = "types";

    @NonNull
    @Getter
    @Column(name = "title")
    private String title;

    @Getter
    @OneToMany(mappedBy = "type")
    @JsonIgnore
    protected List<Component> components = new ArrayList<>();
    
    @Getter
    @OneToMany(mappedBy = "type")
    private List<TypeAttribute> attributes = new ArrayList<>();
}
