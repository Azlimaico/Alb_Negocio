/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.servicio.damnificado;

import com.persistencia.damnificado.AlbDamnificado;
import com.persistencia.general.sistema.AlbEstadoCivil;
import java.util.List;

/**
 *
 * @author Zulay
 */
public interface AlbDamnificadoServicio {

    public List<AlbDamnificado> listarDamnificado();

    public void guardarDamnificado(List<AlbDamnificado> lista);

    public void guardarEliminarDamnificado(AlbDamnificado segDamnificado);

    public void guardarDamnificadoAlbergue(List<AlbDamnificado> lista);

}
