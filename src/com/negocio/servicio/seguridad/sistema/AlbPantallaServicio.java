/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbPantalla;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbPantallaServicio {
    
    public List<AlbPantalla> listarPantalla();
    
    public void guardarPantalla(List<AlbPantalla> Pantalla);
    
    public void guardarPantallaEl(AlbPantalla albPantalla);
    
    public void guardarPantallaPerfil(List<AlbPantalla> lista);
    
}
