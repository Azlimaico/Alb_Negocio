/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.general.sistema.AlbAvanceImplementacion;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbAvanceImplementacionDao {
    
    public List<AlbAvanceImplementacion> listarAvanceI();
    
    public void guardarAvanceI(AlbAvanceImplementacion albAvanceImplementacion);
}
