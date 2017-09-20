/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.albergue.servicio;

import com.persistencia.albergue.servicio.AlbSituacion;
import com.persistencia.general.sistema.AlbTipoEmpresa;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbSituacionDao {
    public List<AlbSituacion> listarAlbSituacion();
    
    public List<AlbTipoEmpresa> listarTipoEmpresa();
}
