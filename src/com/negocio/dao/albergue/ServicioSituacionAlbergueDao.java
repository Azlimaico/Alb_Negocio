/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.albergue;

import com.persistencia.albergue.ServicioSituacionAlbergue;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface ServicioSituacionAlbergueDao {
    public List<ServicioSituacionAlbergue> listarAlbergue();
    
}
