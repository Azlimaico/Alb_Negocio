/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbVehiculoDao;
import com.persistencia.general.sistema.AlbTipoVehiculo;
import com.persistencia.general.sistema.AlbVehiculo;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbVehiculoServicioImpl implements AlbVehiculoServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbVehiculoServicioImpl.class);
    AlbVehiculoDao albVehiculoDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbVehiculo> listarVehiculo() {
        try {
            return getAlbVehiculoDao().listarVehiculos();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbVehiculoDao getAlbVehiculoDao() {
        return albVehiculoDao;
    }

    public void setAlbVehiculoDao(AlbVehiculoDao albVehiculoDao) {
        this.albVehiculoDao = albVehiculoDao;
    }

    @Transactional(readOnly = false)
    @Override
    public List<AlbTipoVehiculo> listarTipoVehiculo() {
        try {
            return getAlbVehiculoDao().listarTipoVehiculo();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarVehiculo(List<AlbVehiculo> albVehiculo) {
        try {
            for (AlbVehiculo obje : albVehiculo) {
                getAlbVehiculoDao().guardarVehiculo(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional
    @Override
    public void guardarVehiculoEl(AlbVehiculo albVehiculo) {
        try {
            getAlbVehiculoDao().guardarVehiculo(albVehiculo);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

}
