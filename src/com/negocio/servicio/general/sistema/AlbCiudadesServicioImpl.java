/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbCiudadesDao;
import com.negocio.dao.general.sistema.AlbProvinciaDao;
import com.persistencia.albergue.AlbAlbergue;
import com.persistencia.general.sistema.AlbAvanceImplementacion;
import com.persistencia.general.sistema.AlbCanton;
import com.persistencia.general.sistema.AlbParroquia;
import com.persistencia.general.sistema.AlbProvincia;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbCiudadesServicioImpl implements AlbCiudadesServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbCiudadesServicioImpl.class);
    AlbCiudadesDao albCiudadesDao;
    AlbProvinciaDao albProvinciaDao;

    @Transactional(readOnly = false)
    @Override
    public void guardarProvincia(List<AlbProvincia> listaProvincia) {
        try {
            for (AlbProvincia obj : listaProvincia) {
                getAlbCiudadesDao().guardarProvincia(obj);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional(readOnly = false)
    @Override
    public List<AlbProvincia> listarProvincias() {
        try {
            return getAlbCiudadesDao().listarProvincia();

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

    @Transactional(readOnly = false)
    @Override
    public List<AlbCanton> listarCantones() {
        try {
            return getAlbCiudadesDao().listarCanton();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbCiudadesDao getAlbCiudadesDao() {
        return albCiudadesDao;
    }

    public void setAlbCiudadesDao(AlbCiudadesDao albCiudadesDao) {
        this.albCiudadesDao = albCiudadesDao;
    }

    @Transactional(readOnly = false)
    @Override
    public List<AlbParroquia> listarParroquias() {
        try {
            return getAlbCiudadesDao().listarParroquia();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public List<AlbAvanceImplementacion> listarAvanceImplementacion() {
        try {
            return getAlbCiudadesDao().listarAvanceImplementacion();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void guardarSegProvincia(AlbAlbergue albAlbergue) {
        try {
            getAlbCiudadesDao().guardarSegUsuario(albAlbergue);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Override
    public List<AlbAlbergue> listarSegUsuario() {
        try {
            return getAlbCiudadesDao().listarSegUsuario();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Transactional
    @Override
    public void guardarSegUsuario(AlbAlbergue segUsuario) {
        try {
            getAlbCiudadesDao().guardarSegUsuario(segUsuario);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional
    @Override
    public List<AlbCanton> listarCantonCmbx(Long IsSeleccionCO) {
        try {
            return getAlbCiudadesDao().listarCantonCmbx(IsSeleccionCO);
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Transactional
    @Override
    public List<AlbParroquia> ListParroquiaCmbx(Long IsSeleccionCanton) {
        try {
            return getAlbCiudadesDao().listarParroquiaCmbx(IsSeleccionCanton);
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Transactional
    @Override
    public void guardarProvinciaEl(AlbProvincia albProvincia) {
        try {
            getAlbCiudadesDao().guardarProvincia(albProvincia);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarCanton(List<AlbCanton> listaCanton) {
        try {
            for (AlbCanton obj : listaCanton) {
                getAlbCiudadesDao().guardarCanton(obj);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional
    @Override
    public void guardarCantonEl(AlbCanton albCanton) {
        try {
            getAlbCiudadesDao().guardarCanton(albCanton);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarParroquia(List<AlbParroquia> listaParroquia) {
        try {
            for (AlbParroquia obj : listaParroquia) {
                getAlbCiudadesDao().guardarParroquia(obj);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional
    @Override
    public void guardarParroquiaEl(AlbParroquia albParroquia) {
         try {
            getAlbCiudadesDao().guardarParroquia(albParroquia);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

}
