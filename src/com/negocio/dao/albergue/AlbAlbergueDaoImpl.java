/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.albergue;

import com.persistencia.albergue.AlbAlbergue;
import com.persistencia.general.sistema.AlbProvincia;
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
public class AlbAlbergueDaoImpl implements AlbAlbergueDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbAlbergueDaoImpl.class
    );
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AlbAlbergue> listarAlbergue() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT lab FROM AlbAlbergue lab "
                            + "JOIN fetch lab.albCanton canton "
                            + "JOIN fetch lab.albParroquia parroquia "
                            + "JOIN fetch lab.albProvincia provincia "
                            + "JOIN fetch lab.albAvanceImplementacion avanceImplementacion "
                            + "JOIN fetch lab.albTipoAlbergue tipA"
                            + "  WHERE  lab.albEstado = '" + 1 + "' order by lab.albId desc").list();
            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void guardarAlbergue(AlbAlbergue albAlbergue) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albAlbergue);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

   
    @Override
    public List<AlbProvincia> listarItemsProvincia(Long IdSeleccion, String provincia) {
        try {

            List list = sessionFactory
                    .getCurrentSession().
                    createQuery(" select cjuo from AlbProvincia cjuo "
                            + " where cjuo.AlbAlbergue.albId ="
                            + IdSeleccion + " and cjuo.proNombre='" + provincia + "' and cjuo.proEstado=1 ").list();

            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }
    
     public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
