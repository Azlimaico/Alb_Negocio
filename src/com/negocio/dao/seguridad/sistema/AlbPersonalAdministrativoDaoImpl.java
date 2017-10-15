/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbPersonalAdministrativo;
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
public class AlbPersonalAdministrativoDaoImpl implements AlbPersonalAdministrativoDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbPersonalAdministrativoDaoImpl.class
    );

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AlbPersonalAdministrativo> listarPersonalAdministrativo() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT perAdm FROM AlbPersonalAdministrativo as perAdm "
                            + "inner join fetch perAdm.albEstadoCivil as estadoCivil "
                            + "inner join fetch perAdm.albFuerza as fuerza "
                            + "inner join fetch perAdm.albProfesion as profesion "
                            + "inner join fetch perAdm.albRango as rango"
                            + "  WHERE  perAdm.peaEstado = '" + 1 + "' order by perAdm.peaId desc").list();
            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void guardarPersonalAdministrativo(AlbPersonalAdministrativo albPersonalAdministrativo) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albPersonalAdministrativo);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }

    @Override
    public void guardarPerAdmin(AlbPersonalAdministrativo albPersonalAdministrativo) {
       try {
            sessionFactory.getCurrentSession().saveOrUpdate(albPersonalAdministrativo);
        } catch (HibernateException ex) {

            LOG.error(ex.getMessage());

        }}

}
