/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.general.sistema.AlbInstruccion;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbInstruccionDao {

    public List<AlbInstruccion> listarInstruccion();

    public void guardarInstruccion(AlbInstruccion albInstruccion);
}
