/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.persistencia.albergue.AlbAlbergue;
import com.persistencia.general.sistema.AlbAvanceImplementacion;
import com.persistencia.general.sistema.AlbCanton;
import com.persistencia.general.sistema.AlbParroquia;
import com.persistencia.general.sistema.AlbProvincia;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbCiudadesServicio {

    public List<AlbProvincia> listarProvincias();

    public List<AlbCanton> listarCantones();

    public List<AlbParroquia> listarParroquias();

    public List<AlbAvanceImplementacion> listarAvanceImplementacion();

    public void guardarProvincia(List<AlbProvincia> listaProvincia); //sirve para modificar y guardar

    public void eliminarProvincia(List<AlbProvincia> listaProvincia);

    public void guardarSegProvincia(AlbAlbergue albAlbergue);

    public List<AlbAlbergue> listarSegUsuario();
    
    public void guardarSegUsuario(AlbAlbergue segUsuario);
    
    //Listar contons combobox
     public List<AlbCanton> listarCantonCmbx (Long IsSeleccionCO);
     
     public List<AlbParroquia> ListParroquiaCmbx(Long IsSeleccionCanton);

}
