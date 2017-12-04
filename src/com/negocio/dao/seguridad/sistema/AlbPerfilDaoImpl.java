/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbPantalla;
import com.persistencia.seguridad.sistema.AlbPerfil;
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
public class AlbPerfilDaoImpl implements AlbPerfilDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbPerfilDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AlbPerfil> listarPerfil() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery(" select perfil"
                            + " from AlbPerfil perfil "
                    + "  WHERE  perfil.perEstado = '" + 1 + "' order by perfil.perId desc").list();
            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void guardarPerfil(AlbPerfil albPerfil) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albPerfil);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

    @Override
    public void guardarPerfilPantalla1(AlbPantalla perfilPantalla) {
        try {
            sessionFactory.getCurrentSession().save(perfilPantalla);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }
}
