/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbPantalla;
import com.persistencia.seguridad.sistema.AlbPerfil;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbPerfilServicio {

    public List<AlbPerfil> listarPerfil();
    
    public void guardarPerfil(List<AlbPerfil> Perfil);
    
    public void guardarPerfilEl(AlbPerfil albPerfil);
    
    public void guardarPerfilPantalla1(List<AlbPantalla> lista);
}
