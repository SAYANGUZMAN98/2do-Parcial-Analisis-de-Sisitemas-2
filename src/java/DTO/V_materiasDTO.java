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
public class V_materiasDTO {

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

    public Integer getT_carreras_id_carrera() {
        return t_carreras_id_carrera;
    }

    public void setT_carreras_id_carrera(Integer t_carreras_id_carrera) {
        this.t_carreras_id_carrera = t_carreras_id_carrera;
    }

    public Integer getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(Integer id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public V_materiasDTO() {
    }

    public V_materiasDTO(Integer id_asignatura, String nombre_asignatura, Integer t_carreras_id_carrera, Integer id_carrera, String nombre_carrera) {
        this.id_asignatura = id_asignatura;
        this.nombre_asignatura = nombre_asignatura;
        this.t_carreras_id_carrera = t_carreras_id_carrera;
        this.id_carrera = id_carrera;
        this.nombre_carrera = nombre_carrera;
    }

    public V_materiasDTO(Integer id_asignatura, String nombre_asignatura, String nombre_carrera, Integer id_carrera) {
        this.id_asignatura = id_asignatura;
        this.nombre_asignatura = nombre_asignatura;
        this.nombre_carrera = nombre_carrera;
        this.id_carrera = id_carrera;
    }

    private Integer id_asignatura;
    private String nombre_asignatura;
    private Integer t_carreras_id_carrera;
    private Integer id_carrera;
    private String nombre_carrera;

}
