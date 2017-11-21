/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbMenu;
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
public class AlbMenuDaoImpl implements AlbMenuDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbMenuDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AlbMenu> listarMenu() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery(" select obj"
                            + " from AlbMenu obj  ").list();
            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void guardarMenu(AlbMenu albMenu) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albMenu);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

}
