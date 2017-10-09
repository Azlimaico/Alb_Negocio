/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.seguridad.sistema;

import com.negocio.dao.seguridad.sistema.AlbPersonalAdministrativoDao;
import com.persistencia.seguridad.sistema.AlbPersonalAdministrativo;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbPersonalAdministrativoServicioImpl implements AlbPersonalAdministrativoServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbPersonalAdministrativoServicioImpl.class);
    AlbPersonalAdministrativoDao albPersonalAdministrativoDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbPersonalAdministrativo> listarPersonalAdmin() {
        try {
            return getAlbPersonalAdministrativoDao().listarPersonalAdministrativo();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbPersonalAdministrativoDao getAlbPersonalAdministrativoDao() {
        return albPersonalAdministrativoDao;
    }

    public void setAlbPersonalAdministrativoDao(AlbPersonalAdministrativoDao albPersonalAdministrativoDao) {
        this.albPersonalAdministrativoDao = albPersonalAdministrativoDao;
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarPersonalAdmin(List<AlbPersonalAdministrativo> lista) {
        try {
            for (AlbPersonalAdministrativo obje : lista) {
                getAlbPersonalAdministrativoDao().guardarPersonalAdministrativo(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

}
