/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.albergue;

import com.negocio.dao.albergue.AlbAlbergueDao;
import com.persistencia.albergue.AlbAlbergue;
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
public class AlbAlbergueServicioImpl implements AlbAlbergueServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbAlbergueServicioImpl.class);
    AlbAlbergueDao albAlbergueDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbAlbergue> listarAlbergue() {
        try {
            return getAlbAlbergueDao().listarAlbergue();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbAlbergueDao getAlbAlbergueDao() {
        return albAlbergueDao;
    }

    public void setAlbAlbergueDao(AlbAlbergueDao albAlbergueDao) {
        this.albAlbergueDao = albAlbergueDao;
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarJuego(List<AlbAlbergue> lista) {
        try {
            for (AlbAlbergue obje : lista) {
                getAlbAlbergueDao().guardarAlbergue(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }


    @Override
    public List<AlbProvincia> listarItemsProvincia(Long IdSeleccion, String provincia) {
       try {
            return getAlbAlbergueDao().listarItemsProvincia(IdSeleccion, provincia);
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        } }

}
