/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.persistencia.general.sistema.AlbTipoVehiculo;
import com.persistencia.general.sistema.AlbVehiculo;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbVehiculoServicio {

    public List<AlbVehiculo> listarVehiculo();

    public List<AlbTipoVehiculo> listarTipoVehiculo();
    
    public void guardarVehiculo(List<AlbVehiculo> albVehiculo);
    
    public void guardarVehiculoEl(AlbVehiculo albVehiculo);
}
