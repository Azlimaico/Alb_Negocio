/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.persistencia.general.sistema.AlbRango;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbRangoServicio {

    public List<AlbRango> listarRango();

    public void guardarRango(List<AlbRango> Rango);

    public void guardarRangoEl(AlbRango albRango);
}
