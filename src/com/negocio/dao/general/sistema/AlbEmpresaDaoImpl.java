/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.general.sistema;

import com.negocio.dao.albergue.AlbAlbergueDao;
import com.negocio.dao.albergue.AlbAlbergueDaoImpl;
import com.persistencia.general.sistema.AlbEmpresa;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;



public class AlbEmpresaDaoImpl  implements AlbEmpresaDao, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbAlbergueDaoImpl.class
    );
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AlbEmpresa> listarEmpresa() {
       try {
            List list = sessionFactory
                    .getCurrentSession().createQuery("SELECT empresa FROM AlbEmpresa empresa "
                                                     + "  WHERE  empresa.empEstado = '" + 1 + "' order by empEstado.empId desc").list();
            return list;
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        } }
     public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    
}
