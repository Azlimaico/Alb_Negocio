/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbFuerzaDao;
import com.persistencia.general.sistema.AlbFuerza;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbFuerzaServicioImpl implements AlbFuerzaServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbFuerzaServicioImpl.class);
    AlbFuerzaDao albFuerzaDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbFuerza> listarFuerza() {
        try {
            return getAlbFuerzaDao().listarFuerza();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbFuerzaDao getAlbFuerzaDao() {
        return albFuerzaDao;
    }

    public void setAlbFuerzaDao(AlbFuerzaDao albFuerzaDao) {
        this.albFuerzaDao = albFuerzaDao;
    }

}
