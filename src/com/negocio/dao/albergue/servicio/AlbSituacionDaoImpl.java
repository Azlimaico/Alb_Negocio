/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.albergue.servicio;

import com.persistencia.albergue.servicio.AlbSituacion;
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
public class AlbSituacionDaoImpl implements AlbSituacionDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbSituacionDaoImpl.class
    );
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AlbSituacion> listarAlbSituacion() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT situacion FROM AlbSituacion situacion "
                            + "JOIN fetch situacion.servicioSituacionAlbergue serSitAlb "
                            + "  WHERE situacion.sitEstado = '" + 1 + "' order by situacion.sitId desc").list();
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
