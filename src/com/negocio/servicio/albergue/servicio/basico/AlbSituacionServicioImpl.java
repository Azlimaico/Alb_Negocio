/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.albergue.servicio.basico;

import com.negocio.dao.albergue.servicio.AlbSituacionDao;
import com.persistencia.albergue.servicio.AlbSituacion;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbSituacionServicioImpl implements AlbSituacionServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbSituacionServicioImpl.class);
    AlbSituacionDao albSituacionDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbSituacion> listarAlbSituacion() {
        try {
            return getAlbSituacionDao().listarAlbSituacion();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }


public AlbSituacionDao getAlbSituacionDao() {
        return albSituacionDao;
    }

    public void setAlbSituacionDao(AlbSituacionDao albSituacionDao) {
        this.albSituacionDao = albSituacionDao;
    }
    
    
}
