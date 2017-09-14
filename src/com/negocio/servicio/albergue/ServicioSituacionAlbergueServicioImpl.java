/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.albergue;

import com.negocio.dao.albergue.ServicioSituacionAlbergueDao;
import com.persistencia.albergue.ServicioSituacionAlbergue;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class ServicioSituacionAlbergueServicioImpl implements ServicioSituacionAlbergueServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(ServicioSituacionAlbergueServicioImpl.class);
    ServicioSituacionAlbergueDao servicioSituacionAlbergueDao;

    @Transactional(readOnly = false)
    @Override
    public List<ServicioSituacionAlbergue> listarServicioSituacionAlbergue() {
        try {
            return getServicioSituacionAlbergueDao().listarServicioSituacionAlbergue();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public ServicioSituacionAlbergueDao getServicioSituacionAlbergueDao() {
        return servicioSituacionAlbergueDao;
    }

    public void setServicioSituacionAlbergueDao(ServicioSituacionAlbergueDao servicioSituacionAlbergueDao) {
        this.servicioSituacionAlbergueDao = servicioSituacionAlbergueDao;
    }

}
