/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbDiscapacidadDao;
import com.persistencia.general.sistema.AlbDiscapacidad;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbDiscapacidadServicioImpl implements AlbDiscapacidadServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbDiscapacidadServicioImpl.class);
    AlbDiscapacidadDao albDiscapacidadDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbDiscapacidad> listarDiscapacidad() {
        try {
            return getAlbDiscapacidadDao().listarDiscapacidad();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbDiscapacidadDao getAlbDiscapacidadDao() {
        return albDiscapacidadDao;
    }

    public void setAlbDiscapacidadDao(AlbDiscapacidadDao albDiscapacidadDao) {
        this.albDiscapacidadDao = albDiscapacidadDao;
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarDisca(List<AlbDiscapacidad> Disca) {
       try {
            for (AlbDiscapacidad obje : Disca) {
                getAlbDiscapacidadDao().guardarDisca(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            
        } 
    }

    @Transactional
    @Override
    public void guardarDiscaEl(AlbDiscapacidad albDiscapacidad) {
        try {
            getAlbDiscapacidadDao().guardarDisca(albDiscapacidad);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            
        }
    }

}
