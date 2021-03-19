package nl.vhoudt.luuk.richrail.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@AllArgsConstructor
public class Train extends Entity {
    @NonNull
    @Getter
    private String name;
    
    @Getter
    private List<Component> components = new ArrayList<Component>();

    public void addComponent(Component c) {
        this.components.add(c);
        log.info("Train \"" + name + "\": an component was added.");
    }

    public void removeComponent(Component c) {
        Component[] newComponents = new Component[this.components.size()];
        newComponents = this.components.toArray(newComponents);
        newComponents = Stream.of(newComponents).filter(i -> !i.equals(c)).toArray(Component[]::new);
        this.components = Arrays.asList(newComponents);
        log.info("Train \"" + name + "\": an component was removed.");
    }
}
