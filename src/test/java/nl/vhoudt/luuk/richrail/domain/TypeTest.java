package nl.vhoudt.luuk.richrail.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TypeTest {
    @Test
    void constructsWithRequiredArgs() throws Exception {
        String expected = "foo";
        Type target = new Type(expected);
        assertEquals(target.getName(), expected);
    }

    @Test
    void nameCannotBeNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            new Type(null);
        });
    }

    @Test
    void numberOfSeatsHasDefault() throws Exception {
        Type target = new Type("foo");
        assertEquals(target.getNumberOfSeats(), 0);
    }
    @Test
    void payloadCapacityHasDefault() throws Exception {
        Type target = new Type("foo");
        assertEquals(target.getPayloadCapacity(), 0);
    }
}
