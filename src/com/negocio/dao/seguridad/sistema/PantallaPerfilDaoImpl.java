/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;

import com.persistencia.albergue.AlbAlbergue;
import com.persistencia.seguridad.sistema.AlbPantalla;
import com.persistencia.seguridad.sistema.PantallaPerfil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Zulay
 */
public class PantallaPerfilDaoImpl implements PantallaPerfilDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(PantallaPerfilDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void guardarPantallaPerfil(PantallaPerfil pantallaPerfil) {
         try {
            sessionFactory.getCurrentSession().saveOrUpdate(pantallaPerfil);
        } catch (HibernateException ex) {

            LOG.error("Error: " + ex.getMessage());

        }
    }

        
    @Override
    public List<PantallaPerfil> listarPantallaPerfil(Long perfil) {
         try {
            List list = sessionFactory
                    .getCurrentSession().createQuery(" select pantPerf"
                            + " from PantallaPerfil pantPerf "
                            + " inner join fetch pantPerf.albPantalla pantalla "
                            + " inner join fetch pantPerf.albPerfil perf "
                            + " where perf.perId ='" + perfil + "' ").list();
            return list;
            
            
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<PantallaPerfil> listarPantallaPerfilByPerfilId(Long idPerfil) {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery(" select obj"
                            + " from PantallaPerfil obj join fetch obj.albPantalla pam "
                            + " join fetch pam.albMenu men "
                            + " where obj.albPerfil.perId=" + idPerfil + " ").list();
            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    
    
}
