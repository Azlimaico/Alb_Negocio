/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.albergue.servicio.basico;

import com.persistencia.albergue.servicio.AlbSituacion;
import com.persistencia.general.sistema.AlbTipoEmpresa;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbSituacionServicio {
    public List<AlbSituacion> listarAlbSituacion();
    public List<AlbTipoEmpresa> listarTipoEmpresa();
}
