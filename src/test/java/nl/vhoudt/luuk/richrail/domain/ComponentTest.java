package nl.vhoudt.luuk.richrail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ComponentTest {
    @Mock
    Type mockedType;

    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void constructsWithRequiredArgs() throws Exception {
        this.initMocks();
        Integer expectedOrder = 1;
        Component target = new Component(expectedOrder, mockedType);
        assertEquals(target.getOrder(), expectedOrder);
        assertEquals(target.getType(), mockedType);
    }

    @Test
    void orderCannotBeNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new Component(null, null);
        });
    }

    @Test
    void typeCannotBeNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new Component(0, null);
        });
    }
}
