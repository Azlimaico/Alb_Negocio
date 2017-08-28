/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbInstruccionDao;
import com.persistencia.general.sistema.AlbInstruccion;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbInstruccionServicioImpl implements AlbInstruccionServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbInstruccionServicioImpl.class);
    AlbInstruccionDao albInstruccionDao;

    @Transactional(readOnly = false)
    @Override
    public List<AlbInstruccion> listarInstruccion() {
        try {
            return getAlbInstruccionDao().listarInstruccion();

        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    public AlbInstruccionDao getAlbInstruccionDao() {
        return albInstruccionDao;
    }

    public void setAlbInstruccionDao(AlbInstruccionDao albInstruccionDao) {
        this.albInstruccionDao = albInstruccionDao;
    }

}
