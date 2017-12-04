/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;

import com.persistencia.seguridad.sistema.PerAdministrativoAlberguePerfil;
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
public class PerAdministrativoAlberguePerfilDaoImpl implements PerAdministrativoAlberguePerfilDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(PerAdministrativoAlberguePerfilDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PerAdministrativoAlberguePerfil> listarUsuario() {
        try {
            List list = sessionFactory
                    .getCurrentSession().createQuery(" select usu from PerAdministrativoAlberguePerfil usu "
                            + " inner join fetch usu.albAlbergue albergue "
                            + " inner join fetch usu.albPersonalAdministrativo perAd "
                            + " inner join fetch usu.albPerfil perfil "
                            + "  WHERE  usu.padEstado = '" + 1 + "' order by usu.padId desc").list();
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
    public void guardarUsuario(PerAdministrativoAlberguePerfil perAdministrativoAlberguePerfil) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(perAdministrativoAlberguePerfil);
        } catch (HibernateException ex) {

            LOG.error("Error: Ya Existe el Usuario " + ex.getMessage());

        }
    }

    @Override
    public PerAdministrativoAlberguePerfil listarUsuContra(String nombre, String clave) {
        try {
            Object objectUsuario = sessionFactory
                    .getCurrentSession().createQuery(" select obj"
                            + " from PerAdministrativoAlberguePerfil obj join fetch obj.albPerfil perf "
                            + " join fetch obj.albAlbergue albergue "
                            + " join fetch obj.albPersonalAdministrativo perAdm "
                            + "where obj.padEstado=1 and obj.padUsuario='" + nombre + "' and obj.padContrasenia='" + clave + "'").uniqueResult();
            return (PerAdministrativoAlberguePerfil) objectUsuario;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

   

}
