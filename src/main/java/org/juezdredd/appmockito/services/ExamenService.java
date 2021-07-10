package org.juezdredd.appmockito.services;

import org.juezdredd.appmockito.models.Examen;

import java.util.Optional;

public interface ExamenService {
    Optional<Examen> findExamenByName(String nombre);
    Examen findExamenByNameWithAnswers(String nombre);
}
