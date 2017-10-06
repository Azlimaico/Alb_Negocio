/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.albergue.servicio.basico;

import com.persistencia.albergue.ServicioSituacionAlbergue;
import com.persistencia.albergue.servicio.AlbServicio;
import com.persistencia.albergue.servicio.AlbSituacion;
import com.persistencia.general.sistema.AlbEmpresa;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbServicioServicio {

    public List<AlbServicio> listarServicio();

    public void guardarEmpresa(List<AlbEmpresa> lista);

    public void guardarServicio(List<AlbServicio> lista);
    
    public void guardarServicioSituacionAlbergue(List<ServicioSituacionAlbergue> listaServicioSituacionAlbergue);
    
    public void guardarSituacion(List<AlbSituacion> listaSituacion);
    
    public void guardarServicioEliminar(AlbSituacion albSituacion);
}
