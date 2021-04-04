package nl.vhoudt.luuk.richrail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TypeTest {
    @Mock
    Component mockedComponent;

    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void constructsWithRequiredArgs() throws Exception {
        String expected = "foo";
        Type target = new Type(expected);
        assertEquals(target.getTitle(), expected);
    }

    @Test
    void nameCannotBeNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new Type(null);
        });
    }
}
