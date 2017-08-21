/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

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
public interface AlbCiudadesDao {

    public List<AlbProvincia> listarProvincia();

    public List<AlbCanton> listarCanton();

    public List<AlbParroquia> listarParroquia();

    public List<AlbAvanceImplementacion> listarAvanceImplementacion();

    public void guardarProvincia(AlbProvincia albProvincia);

    public void guardarSegUsuario(AlbAlbergue albAlbergue);

    public List<AlbAlbergue> listarSegUsuario();
    
    //LISTAR EN EL COMBOBOX
    public List<AlbCanton> listarCantonCmbx(Long IsSeleccionCO);
    
     public List<AlbParroquia> listarParroquiaCmbx(Long IsSeleccionCanton);

}
