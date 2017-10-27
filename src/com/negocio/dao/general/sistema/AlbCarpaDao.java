/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.general.sistema.AlbCarpa;
import com.persistencia.general.sistema.AlbTipoCarpa;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbCarpaDao {

    public List<AlbCarpa> listarCarpas();

    public List<AlbTipoCarpa> listarTipoCarpa();

    public void guardarCarpa(AlbCarpa AlbCarpa);
}
