/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.general.sistema.AlbAvanceImplementacion;
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
public class AlbAvanceImplementacionDaoImpl implements AlbAvanceImplementacionDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbAvanceImplementacionDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AlbAvanceImplementacion> listarAvanceI() {
         try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT avaIm FROM AlbAvanceImplementacion avaIm"
                            + "  WHERE  avaIm.avaEstado = '" + 1 + "' order by avaIm.avaId desc ").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void guardarAvanceI(AlbAvanceImplementacion albAvanceImplementacion) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albAvanceImplementacion);
        } catch (HibernateException ex) {
            LOG.error("Error YA EXISTE EL AVENCE DE IMPLEMENTACIÓN: " + ex.getMessage());
        }
    }

    

}
