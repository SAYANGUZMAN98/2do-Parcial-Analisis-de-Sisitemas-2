/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PuntajesDTO;

/**
 *
 * @author !mX
 */
public interface PuntajesDAO extends CRUDGenerico<PuntajesDTO> {

    String FiltroID(Integer idFiltro);

    String ComboCarreras();

    String ComboMaterias();

    String ComboAno();

    String ComboUsuario();

}
