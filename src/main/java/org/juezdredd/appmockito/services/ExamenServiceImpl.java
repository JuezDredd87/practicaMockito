package org.juezdredd.appmockito.services;

import org.juezdredd.appmockito.daos.ExamenDao;
import org.juezdredd.appmockito.daos.PreguntasDao;
import org.juezdredd.appmockito.models.Examen;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{
    private ExamenDao examenDao;
    private PreguntasDao preguntasDao;

    public ExamenServiceImpl(ExamenDao examenDao, PreguntasDao preguntasDao) {
        this.examenDao = examenDao;
        this.preguntasDao = preguntasDao;
    }

    @Override
    public Optional<Examen> findExamenByName(String nombre) {
        return examenDao.findAll()
                .stream()
                .filter(e -> e.getNombre().contains(nombre))
                .findFirst();
    }

    @Override
    public Examen findExamenByNameWithAnswers(String nombre) {
        Optional<Examen> examenOptional = findExamenByName(nombre);

        Examen examen = null;
        if (examenOptional.isPresent()){
            examen = examenOptional.orElseThrow();
            List<String> preguntas = preguntasDao.findPreguntasByExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }

        return examen;
    }
}
