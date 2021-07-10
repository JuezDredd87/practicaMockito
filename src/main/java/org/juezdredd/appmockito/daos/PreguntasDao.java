package org.juezdredd.appmockito.daos;

import java.util.List;

public interface PreguntasDao {
    List<String> findPreguntasByExamenId(Long id);
}
