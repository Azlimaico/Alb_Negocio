/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.seguridad.sistema;

import com.persistencia.seguridad.sistema.PerAdministrativoAlberguePerfil;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface PerAdministrativoAlberguePerfilServicio {

    public List<PerAdministrativoAlberguePerfil> listarUsuario();
    
    public void guardarUsuario(PerAdministrativoAlberguePerfil perAdministrativoAlberguePerfil);
}
