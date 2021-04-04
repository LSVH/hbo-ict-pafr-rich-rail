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

import nl.vhoudt.luuk.richrail.domain.TypeAttributeKey;
import nl.vhoudt.luuk.richrail.repositories.TypeAttributeKeyRepository;

public class TypeAttributeKeyServiceTest {
    @InjectMocks
    TypeAttributeKeyService service;

    @Mock
    TypeAttributeKeyRepository repository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void canSave() throws Exception {
        TypeAttributeKey expected = new TypeAttributeKey("foo");

        when(repository.save(expected)).thenReturn(expected);

        TypeAttributeKey actual = service.save(expected);

        assertEquals(expected, actual);
        verify(repository, times(1)).save(expected);
    }
}
