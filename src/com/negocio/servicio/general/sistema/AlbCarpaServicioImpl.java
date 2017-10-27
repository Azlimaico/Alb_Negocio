/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbCarpaDao;
import com.persistencia.general.sistema.AlbCarpa;
import com.persistencia.general.sistema.AlbTipoCarpa;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbCarpaServicioImpl implements AlbCarpaServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbCarpaServicioImpl.class);
    AlbCarpaDao albCarpaDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbCarpa> listarCarpa() {
        try {
            return getAlbCarpaDao().listarCarpas();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbCarpaDao getAlbCarpaDao() {
        return albCarpaDao;
    }

    public void setAlbCarpaDao(AlbCarpaDao albCarpaDao) {
        this.albCarpaDao = albCarpaDao;
    }

    @Transactional(readOnly = false)
    @Override
    public List<AlbTipoCarpa> listarTipoCarpa() {
        try {
            return getAlbCarpaDao().listarTipoCarpa();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarCarpa(List<AlbCarpa> albCarpa) {
        try {
            for (AlbCarpa obje : albCarpa) {
                getAlbCarpaDao().guardarCarpa(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional
    @Override
    public void guardarCarpaEl(AlbCarpa albCarpa) {
        try {
            getAlbCarpaDao().guardarCarpa(albCarpa);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

}
