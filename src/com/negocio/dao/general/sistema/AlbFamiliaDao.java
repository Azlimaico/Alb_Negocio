/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.general.sistema.AlbFamilia;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbFamiliaDao {

    public List<AlbFamilia> listarFamilia();

    public void guardarFlia(AlbFamilia albFamilia);

}
