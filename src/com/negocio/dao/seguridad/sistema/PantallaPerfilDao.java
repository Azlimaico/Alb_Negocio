/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;


import com.persistencia.seguridad.sistema.AlbPantalla;
import com.persistencia.seguridad.sistema.PantallaPerfil;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface PantallaPerfilDao {

    public void guardarPantallaPerfil(PantallaPerfil pantallaPerfil);

    public List<PantallaPerfil> listarPantallaPerfil(Long perfil);
    
    public List<PantallaPerfil> listarPantallaPerfilByPerfilId(Long idPerfil);
    
}
