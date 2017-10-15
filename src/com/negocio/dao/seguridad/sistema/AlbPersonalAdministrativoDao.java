/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbPersonalAdministrativo;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbPersonalAdministrativoDao {
    
    public List<AlbPersonalAdministrativo> listarPersonalAdministrativo();
    
    public void guardarPersonalAdministrativo(AlbPersonalAdministrativo albPersonalAdministrativo);
    
    public void guardarPerAdmin(AlbPersonalAdministrativo albPersonalAdministrativo);
}
