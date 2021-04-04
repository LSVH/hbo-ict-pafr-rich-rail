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

import nl.vhoudt.luuk.richrail.domain.Component;
import nl.vhoudt.luuk.richrail.domain.Train;
import nl.vhoudt.luuk.richrail.domain.Type;
import nl.vhoudt.luuk.richrail.repositories.ComponentRepository;

public class ComponentServiceTest {
    @InjectMocks
    ComponentService service;

    @Mock
    ComponentRepository repository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void canSave() throws Exception {
        Component expected = new Component(1, new Train(), new Type());

        when(repository.save(expected)).thenReturn(expected);

        Component actual = service.save(expected);

        assertEquals(expected, actual);
        verify(repository, times(1)).save(expected);
    }
}
