/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.seguridad.sistema;

import com.negocio.dao.seguridad.sistema.PerAdministrativoAlberguePerfilDao;
import com.persistencia.seguridad.sistema.PerAdministrativoAlberguePerfil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class PerAdministrativoAlberguePerfilServicioImpl implements PerAdministrativoAlberguePerfilServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(PerAdministrativoAlberguePerfilServicioImpl.class);
    PerAdministrativoAlberguePerfilDao perAdministrativoAlberguePerfilDao;

    public PerAdministrativoAlberguePerfilDao getPerAdministrativoAlberguePerfilDao() {
        return perAdministrativoAlberguePerfilDao;
    }

    public void setPerAdministrativoAlberguePerfilDao(PerAdministrativoAlberguePerfilDao perAdministrativoAlberguePerfilDao) {
        this.perAdministrativoAlberguePerfilDao = perAdministrativoAlberguePerfilDao;
    }

    @Transactional(readOnly = false)
    @Override
    public List<PerAdministrativoAlberguePerfil> listarUsuario() {
         try {
            return getPerAdministrativoAlberguePerfilDao().listarUsuario();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }
    
    @Transactional
    @Override
    public void guardarUsuario(PerAdministrativoAlberguePerfil perAdministrativoAlberguePerfil) {
        try {
            getPerAdministrativoAlberguePerfilDao().guardarUsuario(perAdministrativoAlberguePerfil);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }
    
    
    
}
