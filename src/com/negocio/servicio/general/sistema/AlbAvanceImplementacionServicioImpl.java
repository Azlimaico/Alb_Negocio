/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;


import com.negocio.dao.general.sistema.AlbAvanceImplementacionDao;
import com.persistencia.general.sistema.AlbAvanceImplementacion;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbAvanceImplementacionServicioImpl implements AlbAvanceImplementacionServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbCiudadesServicioImpl.class);
    AlbAvanceImplementacionDao AlbAvanceImplementacionDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbAvanceImplementacion> listarAvanceImplementacion() {
        try {
            return getAlbAvanceImplementacionDao().listarAvanceI();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbAvanceImplementacionDao getAlbAvanceImplementacionDao() {
        return AlbAvanceImplementacionDao;
    }

    public void setAlbAvanceImplementacionDao(AlbAvanceImplementacionDao AlbAvanceImplementacionDao) {
        this.AlbAvanceImplementacionDao = AlbAvanceImplementacionDao;
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarAvanceI(List<AlbAvanceImplementacion> avanceI) {
        try {
            for (AlbAvanceImplementacion obje : avanceI) {
                getAlbAvanceImplementacionDao().guardarAvanceI(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            
        } 
    }

    @Transactional
    @Override
    public void guardarAvanceIEl(AlbAvanceImplementacion albAvanceImplementacion) {
    try {
            getAlbAvanceImplementacionDao().guardarAvanceI(albAvanceImplementacion);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            
        }    
    }
    
    
    
}
