/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Juan
 * @param <T>
 */
public interface CRUDGenerico<T> {

    boolean insertar(T dto);

    boolean modificar(T dto);

    boolean eliminar(Integer idDto);

    String allSeleccion();

    String allFiltroSeleccion(Integer idFiltro);

    Integer getUltimoCodigo();

}
