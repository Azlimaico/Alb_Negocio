/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.albergue.AlbAlbergue;
import com.persistencia.general.sistema.AlbAvanceImplementacion;
import com.persistencia.general.sistema.AlbCanton;
import com.persistencia.general.sistema.AlbParroquia;
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
public class AlbCiudadesDaoImpl implements AlbCiudadesDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbCiudadesDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarProvincia(AlbProvincia albProvincia) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albProvincia);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<AlbProvincia> listarProvincia() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT pro FROM AlbProvincia pro").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<AlbCanton> listarCanton() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT canton FROM AlbCanton canton").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<AlbParroquia> listarParroquia() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT parroquia FROM AlbParroquia parroquia").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<AlbAvanceImplementacion> listarAvanceImplementacion() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT avaIm FROM AlbAvanceImplementacion avaIm").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void guardarSegUsuario(AlbAlbergue albAlbergue) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albAlbergue);
        } catch (HibernateException ex) {

            LOG.error("Error: Ya Existe el Albergue" + ex.getMessage());

        }}

    @Override
    public List<AlbAlbergue> listarSegUsuario() {
       try {
            List list = sessionFactory
                    .getCurrentSession().createQuery(" select su from AlbAlbergue su "
                            + " inner join fetch su.albProvincia sp "
                            + "  WHERE  su.albEstado = '" + 1 + "' order by su.albId desc").list();
            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }}

    @Override
    public List<AlbCanton> listarCantonCmbx(Long IsSeleccionCO) {
         try {
             List list = sessionFactory
                    .getCurrentSession().createQuery(" select canton from AlbCanton canton "
                            + " where canton.albProvincia.proId  ='"
                            + IsSeleccionCO + "' and canton.canEstado=1").list();

            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }
    

    @Override
    public List<AlbParroquia> listarParroquiaCmbx(Long IsSeleccionCanton) {
       try {
            List list = sessionFactory
                    .getCurrentSession().createQuery(" select parroquia from AlbParroquia parroquia "
                            + " where parroquia.albCanton.canId  ='"
                            + IsSeleccionCanton + "' and parroquia.parEstado=1").list();

            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }}

   }
