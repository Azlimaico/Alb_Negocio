/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.persistencia.general.sistema.AlbCarpa;
import com.persistencia.general.sistema.AlbTipoCarpa;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbCarpaServicio {

    public List<AlbCarpa> listarCarpa();
    
     public List<AlbTipoCarpa> listarTipoCarpa();
     
     public void guardarCarpa(List<AlbCarpa> albCarpa);
     
     public void guardarCarpaEl(AlbCarpa albCarpa);
}
