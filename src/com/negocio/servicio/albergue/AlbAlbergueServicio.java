/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.albergue;

import com.persistencia.albergue.AlbAlbergue;
import com.persistencia.general.sistema.AlbProvincia;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbAlbergueServicio {
    public List<AlbAlbergue> listarAlbergue();
    public void guardarJuego(List<AlbAlbergue> lista);
    public List<AlbProvincia> listarItemsProvincia(Long IdSeleccion, String provincia);
   
}
