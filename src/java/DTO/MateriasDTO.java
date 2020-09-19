/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author !mX
 */
public class MateriasDTO {

    private Integer id_asignatura;
    private String nombre_asignatura;
    private Integer t_carreras_id_carrera;

    public MateriasDTO(Integer id_asignatura, String nombre_asignatura, Integer t_carreras_id_carrera) {
        this.id_asignatura = id_asignatura;
        this.nombre_asignatura = nombre_asignatura;
        this.t_carreras_id_carrera = t_carreras_id_carrera;
    }

    public Integer getT_carreras_id_carrera() {
        return t_carreras_id_carrera;
    }

    public void setT_carreras_id_carrera(Integer t_carreras_id_carrera) {
        this.t_carreras_id_carrera = t_carreras_id_carrera;
    }

    public Integer getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Integer id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

    public MateriasDTO(Integer id_asignatura, String nombre_asignatura) {
        this.id_asignatura = id_asignatura;
        this.nombre_asignatura = nombre_asignatura;
    }

    public MateriasDTO() {
    }

}
