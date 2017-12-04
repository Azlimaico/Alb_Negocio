/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.seguridad.sistema;

import com.negocio.dao.seguridad.sistema.PantallaPerfilDao;
import com.persistencia.seguridad.sistema.AlbPantalla;
import com.persistencia.seguridad.sistema.PantallaPerfil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class PantallaPerfilServicioImpl implements PantallaPerfilServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(PantallaPerfilServicioImpl.class);
    
    PantallaPerfilDao pantallaPerfilDao;
    

    public PantallaPerfilDao getPantallaPerfilDao() {
        return pantallaPerfilDao;
    }

    public void setPantallaPerfilDao(PantallaPerfilDao pantallaPerfilDao) {
        this.pantallaPerfilDao = pantallaPerfilDao;
    }

    @Transactional
    @Override
    public void guardarPantallaPerfil(PantallaPerfil pantallaPerfil) {
         try {
            getPantallaPerfilDao().guardarPantallaPerfil(pantallaPerfil);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }
    
    

    @Transactional(readOnly = true)
    @Override
    public List<PantallaPerfil> listarPantallaPerfil(Long perfil) {
         try {
            return getPantallaPerfilDao().listarPantallaPerfil(perfil);
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<PantallaPerfil> listarPantallaPerfilByPerfilId(Long idPerfil) {
         try {
            return getPantallaPerfilDao().listarPantallaPerfilByPerfilId(idPerfil);
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

   
    
    
}
