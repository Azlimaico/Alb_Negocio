/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.general.sistema;

import com.persistencia.general.sistema.AlbDiscapacidad;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbDiscapacidadServicio {

    public List<AlbDiscapacidad> listarDiscapacidad();

    public void guardarDisca(List<AlbDiscapacidad> Disca);

    public void guardarDiscaEl(AlbDiscapacidad albDiscapacidad);

}
