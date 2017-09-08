/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.damnificado;

import com.persistencia.damnificado.AlbDamnificado;
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
public class AlbDamnificadoDaoImpl implements AlbDamnificadoDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbDamnificadoDaoImpl.class
    );

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AlbDamnificado> listarDamnificado() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT dam FROM AlbDamnificado as dam "
                            + "inner join fetch dam.albDiscapacidad as discapacidad "
                            + "inner join fetch dam.albEstadoCivil as estadoCivil "
                            + "inner join fetch dam.albFamilia as familia "
                            + "inner join fetch dam.albInstruccion as instruccion"
                            + "inner join fetch dam.albProfesion as profesion"
                            + "  WHERE  dam.damEstado = '" + 1 + "' order by dam.damId desc").list();
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
    public void guardarDamnificado(AlbDamnificado albDamnificado) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albDamnificado);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

    @Override
    public void guardarEliminarDamnificado(AlbDamnificado albDamnificado) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albDamnificado);
        } catch (HibernateException ex) {

            LOG.error("Error: Ya Existe el Albergue" + ex.getMessage());

        }
    }

    @Override
    public void guardarDamnificadoAlbergue(AlbDamnificado damnificadoAlbergue) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(damnificadoAlbergue);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }
}
