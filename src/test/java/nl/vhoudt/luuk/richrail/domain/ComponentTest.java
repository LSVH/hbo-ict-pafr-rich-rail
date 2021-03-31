package nl.vhoudt.luuk.richrail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ComponentTest {
    @Mock
    Train mockedTrain;

    @Mock
    Type mockedType;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void constructsWithRequiredArgs() throws Exception {
        Integer expectedSpot = 1;
        Component target = new Component(expectedSpot, mockedTrain, mockedType);
        assertEquals(target.getSpot(), expectedSpot);
        assertEquals(target.getTrain(), mockedTrain);
        assertEquals(target.getType(), mockedType);
    }

    @Test
    void spotCannotBeNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new Component(null, mockedTrain, mockedType);
        });
    }

    @Test
    void trainCannotBeNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new Component(0, null, mockedType);
        });
    }

    @Test
    void typeCannotBeNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new Component(0, mockedTrain, null);
        });
    }
}
