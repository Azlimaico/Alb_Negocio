/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbPantalla;
import com.persistencia.seguridad.sistema.AlbPerfil;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbPerfilDao {

    public List<AlbPerfil> listarPerfil();
    
    public void guardarPerfil(AlbPerfil albPerfil);
    
    public void guardarPerfilPantalla1(AlbPantalla perfilPantalla);

}
