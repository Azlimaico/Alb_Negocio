/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbPantalla;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbPantallaDao {
    
    public List<AlbPantalla> listarPantalla();
    
    public void guardarPantalla(AlbPantalla albPantalla);
    
    public void guardarPantallaPerfil(AlbPantalla pantallaPerfil);
}
