/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbFamiliaDao;
import com.persistencia.general.sistema.AlbFamilia;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbFamiliaServicioImpl implements AlbFamiliaServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbFamiliaServicioImpl.class);
    AlbFamiliaDao albFamiliaDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbFamilia> listarFamilia() {
        try {
            return getAlbFamiliaDao().listarFamilia();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbFamiliaDao getAlbFamiliaDao() {
        return albFamiliaDao;
    }

    public void setAlbFamiliaDao(AlbFamiliaDao albFamiliaDao) {
        this.albFamiliaDao = albFamiliaDao;
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarFlia(List<AlbFamilia> Flia) {
         try {
            for (AlbFamilia obje : Flia) {
                getAlbFamiliaDao().guardarFlia(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            
        }
    }

    @Transactional
    @Override
    public void guardarFliaEl(AlbFamilia albFamilia) {
        try {
            getAlbFamiliaDao().guardarFlia(albFamilia);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            
        }
    }
    

}
