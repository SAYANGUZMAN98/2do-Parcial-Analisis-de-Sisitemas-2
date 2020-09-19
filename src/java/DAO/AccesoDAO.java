/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.AccesoDTO;
import Genericos.Mierror;

/**
 *
 * @author !mX
 */
public interface AccesoDAO {

    boolean verificarUsuario(AccesoDTO accesoDTO) throws Mierror;

}
