/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.albergue.servicio;

import com.persistencia.albergue.ServicioSituacionAlbergue;
import com.persistencia.albergue.servicio.AlbServicio;
import com.persistencia.albergue.servicio.AlbSituacion;
import com.persistencia.general.sistema.AlbEmpresa;
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
public class AlbServicioDaoImpl implements AlbServicioDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbServicioDaoImpl.class
    );
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AlbServicio> listarServicio() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT serv FROM AlbServicio serv "
                            + "JOIN fetch serv.albEmpresa empresa "
                            + "JOIN fetch empresa.albTipoEmpresa tipoEmpresa "
                            + "  WHERE  serv.serEstado = '" + 1 + "' order by serv.serId desc").list();
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

    @Override
    public void guardarServicio(AlbServicio albServicio) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albServicio);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

    @Override
    public void guardarEmpresa(AlbEmpresa albEmpresa) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albEmpresa);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

    @Override
    public void guardarServicioSituacionAlbergue(ServicioSituacionAlbergue servicioSituacionAlbergue) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(servicioSituacionAlbergue);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

    @Override
    public void guardarSituacion(AlbSituacion albSituacion) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albSituacion);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

    @Override
    public void guardarSituacionEliminar(AlbSituacion albSituacion) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albSituacion);
        } catch (HibernateException ex) {

            LOG.error("Error: Ya Existe el Servicio" + ex.getMessage());

        }
    }

}
