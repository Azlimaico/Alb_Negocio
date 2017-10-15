/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbPersonalAdministrativo;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbPersonalAdministrativoServicio {
    
    public List<AlbPersonalAdministrativo> listarPersonalAdmin();
    
    public void guardarPersonalAdmin(List<AlbPersonalAdministrativo> lista);
    
    public void guardarPerAdmin(AlbPersonalAdministrativo albPersonalAdministrativo);
}
