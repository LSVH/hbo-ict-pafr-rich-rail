package nl.vhoudt.luuk.richrail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TrainTest {
    @Mock
    Component mockedComponent;

    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void constructsWithRequiredArgs() throws Exception {
        String expected = "foo";
        Train target = new Train(expected);
        assertEquals(target.getName(), expected);
    }

    @Test
    void nameCannotBeNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new Train(null);
        });
    }

    @Test
    void canAddComponent() throws Exception {
        this.initMocks();
        Train target = new Train("foo");

        target.addComponent(mockedComponent);

        assertEquals(target.getComponents().get(0), mockedComponent);
    }

    @Test
    void canRemoveComponent() throws Exception {
        this.initMocks();
        List<Component> components = new ArrayList<Component>();
        components.add(mockedComponent);
        Train target = new Train("foo", components);

        assertEquals(target.getComponents().size(), 1);

        target.removeComponent(mockedComponent);

        assertEquals(target.getComponents().size(), 0);
    }    
}
