/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.seguridad.sistema;

import com.negocio.dao.seguridad.sistema.AlbPantallaDao;
import com.persistencia.seguridad.sistema.AlbPantalla;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Zulay
 */
public class AlbPantallaServicioImpl implements AlbPantallaServicio, Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger LOG = Logger.getLogger(AlbPantallaServicioImpl.class);
    AlbPantallaDao albPantallaDao;

    public AlbPantallaDao getAlbPantallaDao() {
        return albPantallaDao;
    }

    public void setAlbPantallaDao(AlbPantallaDao albPantallaDao) {
        this.albPantallaDao = albPantallaDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<AlbPantalla> listarPantalla() {
        try {
            return getAlbPantallaDao().listarPantalla();
        } catch (Exception ex) {
            LOG.error("Error: " + ex.getMessage());
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarPantalla(List<AlbPantalla> Pantalla) {
        try {
            for (AlbPantalla obje : Pantalla) {
                getAlbPantallaDao().guardarPantalla(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional
    @Override
    public void guardarPantallaEl(AlbPantalla albPantalla) {
        try {
            getAlbPantallaDao().guardarPantalla(albPantalla);
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarPantallaPerfil(List<AlbPantalla> lista) {
        try {
            for (AlbPantalla obje : lista) {
                getAlbPantallaDao().guardarPantallaPerfil(obje);
            }
        } catch (HibernateException ex) {
            LOG.error("Error: " + ex.getMessage());

        }
    }

}
