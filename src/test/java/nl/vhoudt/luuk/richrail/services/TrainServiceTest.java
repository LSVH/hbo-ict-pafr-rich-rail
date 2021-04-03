package nl.vhoudt.luuk.richrail.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nl.vhoudt.luuk.richrail.domain.Train;
import nl.vhoudt.luuk.richrail.repositories.TrainRepository;

public class TrainServiceTest {
    @InjectMocks
    TrainService service;

    @Mock
    TrainRepository repository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void canFindAll() throws Exception {
        List<Train> expected = new ArrayList<Train>();
        Train train = new Train("foo");
        expected.add(train);

        when(repository.findAll()).thenReturn(expected);

        List<Train> actual = service.findAll();

        assertEquals(expected, actual);
        verify(repository, times(1)).findAll();
    }

    @Test
    void canSave() throws Exception {
        Train expected = new Train("foo");

        when(repository.save(expected)).thenReturn(expected);

        Train actual = service.save(expected);

        assertEquals(expected, actual);
        verify(repository, times(1)).save(expected);
    }

    @Test
    void canDeleteById() throws Exception {
        service.deleteById(1);
        verify(repository, times(1)).deleteById(1);
    }
}
