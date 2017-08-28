/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbEstadoCivilDao;
import com.persistencia.general.sistema.AlbEstadoCivil;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbEstadoCivilServicioImpl implements AlbEstadoCivilServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbEstadoCivilServicioImpl.class);
    AlbEstadoCivilDao albEstadoCivilDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbEstadoCivil> listarEstadoCivil() {
        try {
            return getAlbEstadoCivilDao().listarEstadoCivil();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbEstadoCivilDao getAlbEstadoCivilDao() {
        return albEstadoCivilDao;
    }

    public void setAlbEstadoCivilDao(AlbEstadoCivilDao albEstadoCivilDao) {
        this.albEstadoCivilDao = albEstadoCivilDao;
    }
    

}
