/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.general.sistema.AlbCarpa;
import com.persistencia.general.sistema.AlbTipoCarpa;
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
public class AlbCarpaDaoImpl  implements AlbCarpaDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbCarpaDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AlbCarpa> listarCarpas() {
         try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT carpa FROM AlbCarpa carpa "
                            + "  JOIN FETCH carpa.albTipoCarpa tipoCarpa "
                            + "  JOIN FETCH carpa.albAlbergue albergue "
                            + "  WHERE  carpa.carEstado = '" + 1 + "' order by carpa.carId desc").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<AlbTipoCarpa> listarTipoCarpa() {
      try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT tipoCarpa FROM AlbTipoCarpa tipoCarpa "
                    + "  WHERE  tipoCarpa.ticEstado = '" + 1 + "' order by tipoCarpa.ticId desc").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }  
    }

    @Override
    public void guardarCarpa(AlbCarpa AlbCarpa) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(AlbCarpa);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

    
    
}
