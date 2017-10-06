/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.albergue.servicio;

import com.persistencia.albergue.ServicioSituacionAlbergue;
import com.persistencia.albergue.servicio.AlbServicio;
import com.persistencia.albergue.servicio.AlbSituacion;
import com.persistencia.general.sistema.AlbEmpresa;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbServicioDao {

    public List<AlbServicio> listarServicio();

    public void guardarEmpresa(AlbEmpresa albEmpresa);

    public void guardarServicio(AlbServicio albServicio);
    
    public void guardarServicioSituacionAlbergue(ServicioSituacionAlbergue servicioSituacionAlbergue);
    
    public void guardarSituacion(AlbSituacion albSituacion);
    
    public void guardarSituacionEliminar(AlbSituacion albSituacion);
    
}
