/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbProfesionDao;
import com.persistencia.general.sistema.AlbProfesion;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbProfesionServicioImpl implements AlbProfesionServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbProfesionServicioImpl.class);
    AlbProfesionDao albProfesionDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbProfesion> listarProfesion() {
        try {
            return getAlbProfesionDao().listarProfesion();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbProfesionDao getAlbProfesionDao() {
        return albProfesionDao;
    }

    public void setAlbProfesionDao(AlbProfesionDao albProfesionDao) {
        this.albProfesionDao = albProfesionDao;
    }
    

}
