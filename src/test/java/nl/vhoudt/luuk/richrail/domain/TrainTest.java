package nl.vhoudt.luuk.richrail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(target.getTitle(), expected);
    }

    @Test
    void nameCannotBeNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new Train(null);
        });
    }
}
