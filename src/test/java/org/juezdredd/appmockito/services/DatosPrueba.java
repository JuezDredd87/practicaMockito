package org.juezdredd.appmockito.services;

import org.juezdredd.appmockito.models.Examen;

import java.util.Arrays;
import java.util.List;

public class DatosPrueba {
    public final static List<Examen> EXAMENES = Arrays.asList(new Examen(1L, "Matematicas"),
            new Examen(2L, "Lenguaje"),
            new Examen(3L, "Historia"));

    public final static List<String> PREGUNTAS = Arrays.asList("aritmetica", "integrales", "derivadas", "integrales", "trigonometria");
}
