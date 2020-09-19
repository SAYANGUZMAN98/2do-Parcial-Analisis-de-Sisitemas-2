/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.AlumnoDTO;
import Genericos.Mierror;

/**
 *
 * @author ManuXpy
 */
public interface AccesoADAO {

    boolean verificarUsuario(AlumnoDTO alumnoDTO) throws Mierror;

    String getAlumno(Integer idFiltro) throws Mierror;

}
