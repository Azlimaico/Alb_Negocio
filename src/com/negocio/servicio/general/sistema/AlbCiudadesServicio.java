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

    //MANTENIMIENTO PROVINCIA
    public List<AlbProvincia> listarProvincias();

    public void guardarProvincia(List<AlbProvincia> listaProvincia);
    
    public void guardarProvinciaEl(AlbProvincia albProvincia);
    
    //MANTENIMIENTO CANTÓN
    public List<AlbCanton> listarCantones();
    
    public void guardarCanton(List<AlbCanton> listaCanton);
    
    public void guardarCantonEl(AlbCanton albCanton);
    
    //MANTENIMIENTO PARROQUIA
    public List<AlbParroquia> listarParroquias();
    
    public void guardarParroquia(List<AlbParroquia> listaParroquia);
    
    public void guardarParroquiaEl(AlbParroquia albParroquia);
    

    public List<AlbAvanceImplementacion> listarAvanceImplementacion();

    public void guardarSegProvincia(AlbAlbergue albAlbergue);

    public List<AlbAlbergue> listarSegUsuario();

    public void guardarSegUsuario(AlbAlbergue segUsuario);

    //Listar contons combobox
    public List<AlbCanton> listarCantonCmbx(Long IsSeleccionCO);

    public List<AlbParroquia> ListParroquiaCmbx(Long IsSeleccionCanton);

}
