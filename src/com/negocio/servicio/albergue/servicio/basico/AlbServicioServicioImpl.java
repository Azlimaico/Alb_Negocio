/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.albergue.servicio.basico;

import com.negocio.dao.albergue.servicio.AlbServicioDao;
import com.persistencia.albergue.servicio.AlbServicio;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbServicioServicioImpl implements AlbServicioServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbServicioServicioImpl.class);
    AlbServicioDao albServicioDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbServicio> listarServicio() {
        try {
            return getAlbServicioDao().listarServicio();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbServicioDao getAlbServicioDao() {
        return albServicioDao;
    }

    public void setAlbServicioDao(AlbServicioDao albServicioDao) {
        this.albServicioDao = albServicioDao;
    }
    
    

}
