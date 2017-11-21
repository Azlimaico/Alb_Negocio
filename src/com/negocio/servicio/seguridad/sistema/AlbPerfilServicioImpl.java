/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.seguridad.sistema;

import com.negocio.dao.seguridad.sistema.AlbPerfilDao;
import com.persistencia.seguridad.sistema.AlbPantalla;
import com.persistencia.seguridad.sistema.AlbPerfil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbPerfilServicioImpl implements AlbPerfilServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbPerfilServicioImpl.class);
    AlbPerfilDao AlbPerfilDao;

    public AlbPerfilDao getAlbPerfilDao() {
        return AlbPerfilDao;
    }

    public void setAlbPerfilDao(AlbPerfilDao AlbPerfilDao) {
        this.AlbPerfilDao = AlbPerfilDao;
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<AlbPerfil> listarPerfil() {
        try {
            return getAlbPerfilDao().listarPerfil();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarPerfil(List<AlbPerfil> Perfil) {
         try {
            for (AlbPerfil obje : Perfil) {
                getAlbPerfilDao().guardarPerfil(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional
    @Override
    public void guardarPerfilEl(AlbPerfil albPerfil) {
         try {
            getAlbPerfilDao().guardarPerfil(albPerfil);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }
    
     @Transactional(readOnly = false)
    @Override
    public void guardarPerfilPantalla1(List<AlbPantalla> lista) {
        try {
            for (AlbPantalla obje : lista) {
                getAlbPerfilDao().guardarPerfilPantalla1(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

}
