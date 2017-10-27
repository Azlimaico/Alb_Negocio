/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.general.sistema.AlbTipoVehiculo;
import com.persistencia.general.sistema.AlbVehiculo;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbVehiculoDao {

    public List<AlbVehiculo> listarVehiculos();
    
    public List<AlbTipoVehiculo> listarTipoVehiculo();
    
    public void guardarVehiculo(AlbVehiculo albVehiculo);
}
