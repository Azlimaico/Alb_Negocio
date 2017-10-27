/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.persistencia.general.sistema.AlbAvanceImplementacion;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbAvanceImplementacionServicio {

    public List<AlbAvanceImplementacion> listarAvanceImplementacion();

    public void guardarAvanceI(List<AlbAvanceImplementacion> avanceI);

    public void guardarAvanceIEl(AlbAvanceImplementacion albAvanceImplementacion);

}
