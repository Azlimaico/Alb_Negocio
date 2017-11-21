/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbPantalla;
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
public class AlbPantallaDaoImpl implements AlbPantallaDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbPantallaDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AlbPantalla> listarPantalla() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery(" select pantalla"
                            + " from AlbPantalla pantalla "
                             + " JOIN fetch pantalla.albMenu menu ").list();
            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void guardarPantalla(AlbPantalla albPantalla) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albPantalla);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

    @Override
    public void guardarPantallaPerfil(AlbPantalla pantallaPerfil) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(pantallaPerfil);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

}
