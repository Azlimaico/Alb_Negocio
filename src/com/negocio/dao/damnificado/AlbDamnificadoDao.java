/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.damnificado;

import com.persistencia.damnificado.AlbDamnificado;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbDamnificadoDao {

    public List<AlbDamnificado> listarDamnificado();

    public void guardarDamnificado(AlbDamnificado albDamnificado);

    public void guardarEliminarDamnificado(AlbDamnificado albDamnificado);
}
