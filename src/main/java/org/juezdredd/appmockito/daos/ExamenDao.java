package org.juezdredd.appmockito.daos;

import org.juezdredd.appmockito.models.Examen;

import java.util.List;

public interface ExamenDao {

    List<Examen> findAll();
}
