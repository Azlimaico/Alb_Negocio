/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbTipoAlbergueDao;
import com.persistencia.general.sistema.AlbTipoAlbergue;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbTipoAlbergueServicioImpl  implements AlbTipoAlbergueServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbTipoAlbergueServicioImpl.class);
    AlbTipoAlbergueDao albTipoAlbergueDao;

    public AlbTipoAlbergueDao getAlbTipoAlbergueDao() {
        return albTipoAlbergueDao;
    }

    public void setAlbTipoAlbergueDao(AlbTipoAlbergueDao albTipoAlbergueDao) {
        this.albTipoAlbergueDao = albTipoAlbergueDao;
    }

    @Transactional(readOnly = false)
    @Override
    public List<AlbTipoAlbergue> listarTipoAlbergue() {
     try {
            return getAlbTipoAlbergueDao().listarTipoAlbergue();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }    
    }
    
    
}
