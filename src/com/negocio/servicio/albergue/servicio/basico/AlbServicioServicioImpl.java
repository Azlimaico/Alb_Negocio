/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.albergue.servicio.basico;

import com.negocio.dao.albergue.servicio.AlbServicioDao;
import com.persistencia.albergue.ServicioSituacionAlbergue;
import com.persistencia.albergue.servicio.AlbServicio;
import com.persistencia.albergue.servicio.AlbSituacion;
import com.persistencia.general.sistema.AlbEmpresa;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbServicioServicioImpl implements AlbServicioServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbServicioServicioImpl.class);
    AlbServicioDao albServicioDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbServicio> listarServicio() {
        try {
            return getAlbServicioDao().listarServicio();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbServicioDao getAlbServicioDao() {
        return albServicioDao;
    }

    public void setAlbServicioDao(AlbServicioDao albServicioDao) {
        this.albServicioDao = albServicioDao;
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarServicio(List<AlbServicio> lista) {
        try {
            for (AlbServicio obje : lista) {
                getAlbServicioDao().guardarServicio(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarEmpresa(List<AlbEmpresa> lista) {
        try {
            for (AlbEmpresa obje : lista) {
                getAlbServicioDao().guardarEmpresa(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarServicioSituacionAlbergue(List<ServicioSituacionAlbergue> listaServicioSituacionAlbergue) {
        try {
            for (ServicioSituacionAlbergue obje : listaServicioSituacionAlbergue) {
                getAlbServicioDao().guardarServicioSituacionAlbergue(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarSituacion(List<AlbSituacion> listaSituacion) {
        try {
            for (AlbSituacion obje : listaSituacion) {
                getAlbServicioDao().guardarSituacion(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional
    @Override
    public void guardarServicioEliminar(AlbSituacion albSituacion) {
        try {
            getAlbServicioDao().guardarSituacionEliminar(albSituacion);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

}
