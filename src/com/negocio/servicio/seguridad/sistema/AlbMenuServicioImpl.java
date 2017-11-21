/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.seguridad.sistema;

import com.negocio.dao.seguridad.sistema.AlbMenuDao;
import com.persistencia.seguridad.sistema.AlbMenu;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbMenuServicioImpl implements AlbMenuServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbMenuServicioImpl.class);
    AlbMenuDao albMenuDao;

    @Transactional(readOnly = true)
    @Override
    public List<AlbMenu> listarMenu() {
        try {
            return getAlbMenuDao().listarMenu();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbMenuDao getAlbMenuDao() {
        return albMenuDao;
    }

    public void setAlbMenuDao(AlbMenuDao albMenuDao) {
        this.albMenuDao = albMenuDao;
    }
    
    @Transactional(readOnly = false)
    @Override
    public void guardarMenu(List<AlbMenu> Menu) {
        try {
            for (AlbMenu obje : Menu) {
                getAlbMenuDao().guardarMenu(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional
    @Override
    public void guardarMenuEl(AlbMenu albMenu) {
     try {
            getAlbMenuDao().guardarMenu(albMenu);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }    
    }

    
}
