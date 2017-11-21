/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.dao.seguridad.sistema;

import com.persistencia.seguridad.sistema.AlbMenu;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbMenuDao {

    public List<AlbMenu> listarMenu();

    public void guardarMenu(AlbMenu albMenu);
}
