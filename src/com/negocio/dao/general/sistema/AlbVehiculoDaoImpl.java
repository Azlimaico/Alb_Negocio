/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.persistencia.general.sistema.AlbTipoVehiculo;
import com.persistencia.general.sistema.AlbVehiculo;
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
public class AlbVehiculoDaoImpl implements AlbVehiculoDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbVehiculoDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<AlbVehiculo> listarVehiculos() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT vehi FROM AlbVehiculo vehi "
                            + "  JOIN FETCH vehi.albTipoVehiculo tipoVehi "
                            + "  JOIN FETCH vehi.albAlbergue albergue "
                            + "  WHERE  vehi.vehEstado = '" + 1 + "' order by vehi.vehId desc").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<AlbTipoVehiculo> listarTipoVehiculo() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT tipoVehi FROM AlbTipoVehiculo tipoVehi "
                    + "  WHERE  tipoVehi.tivEstado = '" + 1 + "' order by tipoVehi.tivId desc").list();
            return list;

        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void guardarVehiculo(AlbVehiculo albVehiculo) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(albVehiculo);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
        }
    }
    
}
