/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbProvinciaDao;
import com.persistencia.general.sistema.AlbProvincia;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbProvinciaServicioImpl implements AlbProvinciaServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbProvinciaServicioImpl.class);
    AlbProvinciaDao albProvinciaDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbProvincia> listarProvincia() {
       try {
            return getAlbProvinciaDao().listarProvincia();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbProvinciaDao getAlbProvinciaDao() {
        return albProvinciaDao;
    }

    public void setAlbProvinciaDao(AlbProvinciaDao albProvinciaDao) {
        this.albProvinciaDao = albProvinciaDao;
    }
    
    
}
