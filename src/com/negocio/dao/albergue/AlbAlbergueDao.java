/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.albergue;

import com.persistencia.albergue.AlbAlbergue;
import com.persistencia.general.sistema.AlbProvincia;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbAlbergueDao {
    public List<AlbAlbergue> listarAlbergue();
     public void guardarAlbergue(AlbAlbergue albAlbergue);
      public List<AlbProvincia> listarItemsProvincia(Long IdSeleccion, String provincia);
     

}
