package nl.vhoudt.luuk.richrail.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.vhoudt.luuk.richrail.common.BaseEntity;

@Log4j2
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
@Entity
@Table(name = Train.TABLE_NAME)
public class Train extends BaseEntity {
    public static final String TABLE_NAME = "trains";

    @NonNull
    @Getter
    @Column(name = "title")
    private String title;

    @Getter
    @OneToMany(mappedBy = "train")
    protected List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        this.components.add(component);
        log.info("A component was added to the train: \"" + this.getTitle() + "\".");
    }

    public void removeComponent(Component component) {
        this.components.remove(component);
        log.info("A component was removed from the train: \"" + this.getTitle() + "\".");
    }
}
