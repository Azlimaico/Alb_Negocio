/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.general.sistema.AlbTipoAlbergue;
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
public class AlbTipoAlbergueDaoImpl implements AlbTipoAlbergueDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbTipoAlbergueDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AlbTipoAlbergue> listarTipoAlbergue() {
         try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT tipA FROM AlbTipoAlbergue tipA"
                            + "  WHERE  tipA.tiaEstado = '" + 1 + "' order by tipA.tiaId desc ").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }
    
}
