/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.albergue;

import com.persistencia.albergue.ServicioSituacionAlbergue;
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
public class ServicioSituacionAlbergueDaoImpl implements ServicioSituacionAlbergueDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(ServicioSituacionAlbergueDaoImpl.class
    );
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ServicioSituacionAlbergue> listarServicioSituacionAlbergue() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT serSit FROM ServicioSituacionAlbergue serSit "
                            + "JOIN fetch serSit.albAlbergue albergue "
                            + "JOIN fetch serSit.albServicio servicio "
                            + "JOIN fetch servicio.albEmpresa empresa "
                            + "JOIN fetch empresa.albTipoEmpresa tipoEmpresa "
                            + "  WHERE serSit.serAlbEstado = '" + 1 + "' order by serSit.serAlbId desc").list();
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
