package org.juezdredd.appmockito.services;

import org.juezdredd.appmockito.daos.ExamenDao;
import org.juezdredd.appmockito.daos.PreguntasDao;
import org.juezdredd.appmockito.models.Examen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.juezdredd.appmockito.services.DatosPrueba.EXAMENES;
import static org.juezdredd.appmockito.services.DatosPrueba.PREGUNTAS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class ExamenServiceImplTest {

    private ExamenDao examenDao;
    private ExamenService examenService;
    private PreguntasDao preguntasDao;

    @BeforeEach
    void setUp() {
        examenDao = mock(ExamenDao.class);
        preguntasDao = mock(PreguntasDao.class);
        examenService = new ExamenServiceImpl(examenDao, preguntasDao);
    }

    @Test
    void findExamenByName() {
        when(examenDao.findAll()).thenReturn(EXAMENES);
        Optional<Examen> examen = examenService.findExamenByName("Matematicas");

        assertTrue(examen.isPresent());
        assertEquals(1L, examen.orElseThrow().getId());
        assertEquals("Matematicas", examen.orElseThrow().getNombre());
    }

    @Test
    void findExamenByNameEmptyListExamns() {
        List<Examen> examenes = Collections.emptyList();

        when(examenDao.findAll()).thenReturn(examenes);
        Optional<Examen> examen = examenService.findExamenByName("Matematicas");

        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntasExamen() {
        when(examenDao.findAll()).thenReturn(EXAMENES);
        when(preguntasDao.findPreguntasByExamenId(anyLong())).thenReturn(PREGUNTAS);
        Examen examen = examenService.findExamenByNameWithAnswers("Matematicas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("integrales"));
    }

    @Test
    void testPreguntasExamenVerify() {
        when(examenDao.findAll()).thenReturn(EXAMENES);
        when(preguntasDao.findPreguntasByExamenId(anyLong())).thenReturn(PREGUNTAS);
        Examen examen = examenService.findExamenByNameWithAnswers("Matematicas");
        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("integrales"));
        verify(examenDao).findAll();
        verify(preguntasDao).findPreguntasByExamenId(anyLong());
    }
}