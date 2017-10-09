/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbRangoDao;
import com.persistencia.general.sistema.AlbRango;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbRangoServicioImpl implements AlbRangoServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbRangoServicioImpl.class);
    AlbRangoDao albRangoDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbRango> listarRango() {
        try {
            return getAlbRangoDao().listarRango();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbRangoDao getAlbRangoDao() {
        return albRangoDao;
    }

    public void setAlbRangoDao(AlbRangoDao albRangoDao) {
        this.albRangoDao = albRangoDao;
    }
    
}
