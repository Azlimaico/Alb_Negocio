/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.damnificado;

import com.negocio.dao.damnificado.AlbDamnificadoDao;
import com.persistencia.albergue.AlbAlbergue;
import com.persistencia.damnificado.AlbDamnificado;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbDamnificadoServicioImpl implements AlbDamnificadoServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbDamnificadoServicioImpl.class);
    AlbDamnificadoDao albDamnificadoDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbDamnificado> listarDamnificado() {
        try {
            return getAlbDamnificadoDao().listarDamnificado();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarDamnificado(List<AlbDamnificado> lista) {
        try {
            for (AlbDamnificado obje : lista) {
                getAlbDamnificadoDao().guardarDamnificado(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    public AlbDamnificadoDao getAlbDamnificadoDao() {
        return albDamnificadoDao;
    }

    public void setAlbDamnificadoDao(AlbDamnificadoDao albDamnificadoDao) {
        this.albDamnificadoDao = albDamnificadoDao;
    }

    @Transactional
    @Override
    public void guardarEliminarDamnificado(AlbDamnificado segDamnificado) {
        try {
            getAlbDamnificadoDao().guardarEliminarDamnificado(segDamnificado);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }
    
    @Transactional
    @Override
    public void guardarDamnificadoAlbergue(List<AlbAlbergue> lista) {
       try {
            for (AlbAlbergue obje : lista) {
                getAlbDamnificadoDao().guardarDamnificadoAlbergue(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }}

   

}
