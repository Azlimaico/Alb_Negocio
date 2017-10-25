/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.general.sistema.AlbFamilia;
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
public class AlbFamiliaDaoImpl implements AlbFamiliaDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbFamiliaDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AlbFamilia> listarFamilia() {
       try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT flia FROM AlbFamilia flia"
                     + "  WHERE  flia.famEstado = '" + 1 + "' order by flia.famId desc").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }  }

    @Override
    public void guardarFlia(AlbFamilia albFamilia) {
         try {
            sessionFactory.getCurrentSession().saveOrUpdate(albFamilia);
        } catch (HibernateException ex) {
            LOG.error("Error YA EXISTE LA FLIA: " + ex.getMessage());
        }  
    }

    
}
