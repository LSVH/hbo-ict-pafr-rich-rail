package nl.vhoudt.luuk.richrail.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nl.vhoudt.luuk.richrail.domain.Type;
import nl.vhoudt.luuk.richrail.domain.TypeAttribute;
import nl.vhoudt.luuk.richrail.domain.TypeAttributeKey;
import nl.vhoudt.luuk.richrail.repositories.TypeAttributeRepository;

public class TypeAttributeServiceTest {
    @InjectMocks
    TypeAttributeService service;

    @Mock
    TypeAttributeRepository repository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void canSave() throws Exception {
        String expectedValue = "foo";
        Integer expectedId = 1;
        TypeAttribute expected = new TypeAttribute(expectedValue, new Type(), new TypeAttributeKey());

        when(repository.save(expected)).thenReturn(expected);

        TypeAttribute actual = service.save(expectedValue, expectedId, expectedId);

        assertEquals(expected.getValue(), actual.getValue());
        verify(repository, times(1)).save(expected);
    }
}
