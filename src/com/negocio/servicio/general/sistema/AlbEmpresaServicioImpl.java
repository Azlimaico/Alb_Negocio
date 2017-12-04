/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.negocio.dao.general.sistema.AlbEmpresaDao;
import com.persistencia.general.sistema.AlbEmpresa;
import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Zulay
 */
public class AlbEmpresaServicioImpl implements AlbEmpresaServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbEmpresaServicioImpl.class);
    AlbEmpresaDao albEmpresaDao;

   
    @Transactional
    @Override
    public List<AlbEmpresa> listarEmpresaCmbx(Long IdSeleccion) {
     try {
            return getAlbEmpresaDao().listarEmpresaCmbx(IdSeleccion);
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }    
    }

    public AlbEmpresaDao getAlbEmpresaDao() {
        return albEmpresaDao;
    }

    public void setAlbEmpresaDao(AlbEmpresaDao albEmpresaDao) {
        this.albEmpresaDao = albEmpresaDao;
    }

    
    
    
}
