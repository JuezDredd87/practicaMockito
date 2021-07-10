package org.juezdredd.appmockito.daos;

import org.juezdredd.appmockito.models.Examen;

import java.util.Arrays;
import java.util.List;

public class ExamenDaoImpl implements ExamenDao{
    @Override
    public List<Examen> findAll() {
        return Arrays.asList(new Examen(1L, "Matematicas"),
                new Examen(2L, "Lenguaje"),
                new Examen(3L, "Historia"));
    }
}
