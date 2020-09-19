/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author !mX
 */
public class V_CalificacionesDTO {

    public Integer getId_puntajes() {
        return id_puntajes;
    }

    public void setId_puntajes(Integer id_puntajes) {
        this.id_puntajes = id_puntajes;
    }

    public Integer getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }

    public Integer getCod_alumno() {
        return cod_alumno;
    }

    public void setCod_alumno(Integer cod_alumno) {
        this.cod_alumno = cod_alumno;
    }

    public String getNombres_alumno() {
        return nombres_alumno;
    }

    public void setNombres_alumno(String nombres_alumno) {
        this.nombres_alumno = nombres_alumno;
    }

    public String getApellidos_alumno() {
        return apellidos_alumno;
    }

    public void setApellidos_alumno(String apellidos_alumno) {
        this.apellidos_alumno = apellidos_alumno;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public Integer getT_alumnos_id_alumno() {
        return t_alumnos_id_alumno;
    }

    public void setT_alumnos_id_alumno(Integer t_alumnos_id_alumno) {
        this.t_alumnos_id_alumno = t_alumnos_id_alumno;
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

    public Integer getT_anho_id_anho() {
        return t_anho_id_anho;
    }

    public void setT_anho_id_anho(Integer t_anho_id_anho) {
        this.t_anho_id_anho = t_anho_id_anho;
    }

    public Integer getPuntaje_tp() {
        return puntaje_tp;
    }

    public void setPuntaje_tp(Integer puntaje_tp) {
        this.puntaje_tp = puntaje_tp;
    }

    public Integer getPuntaje_ep() {
        return puntaje_ep;
    }

    public void setPuntaje_ep(Integer puntaje_ep) {
        this.puntaje_ep = puntaje_ep;
    }

    public Integer getPuntaje_ef() {
        return puntaje_ef;
    }

    public void setPuntaje_ef(Integer puntaje_ef) {
        this.puntaje_ef = puntaje_ef;
    }

    public Integer getPuntaje_total() {
        return puntaje_total;
    }

    public void setPuntaje_total(Integer puntaje_total) {
        this.puntaje_total = puntaje_total;
    }

    public Integer getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(Integer id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getCi_alumno() {
        return ci_alumno;
    }

    public void setCi_alumno(String ci_alumno) {
        this.ci_alumno = ci_alumno;
    }

    public Date getFecha_nac_alumno() {
        return fecha_nac_alumno;
    }

    public void setFecha_nac_alumno(Date fecha_nac_alumno) {
        this.fecha_nac_alumno = fecha_nac_alumno;
    }

    public V_CalificacionesDTO(Integer id_alumno, Integer cod_alumno, String nombres_alumno, String apellidos_alumno, String nombre_asignatura, String nombre_carrera, Integer t_alumnos_id_alumno, Integer t_carreras_id_carrera, Integer id_asignatura, Integer t_anho_id_anho, Integer puntaje_tp, Integer puntaje_ep, Integer puntaje_ef, Integer puntaje_total, Integer id_carrera, String ci_alumno, Date fecha_nac_alumno) {
        this.id_alumno = id_alumno;
        this.cod_alumno = cod_alumno;
        this.nombres_alumno = nombres_alumno;
        this.apellidos_alumno = apellidos_alumno;
        this.nombre_asignatura = nombre_asignatura;
        this.nombre_carrera = nombre_carrera;
        this.t_alumnos_id_alumno = t_alumnos_id_alumno;
        this.t_carreras_id_carrera = t_carreras_id_carrera;
        this.id_asignatura = id_asignatura;
        this.t_anho_id_anho = t_anho_id_anho;
        this.puntaje_tp = puntaje_tp;
        this.puntaje_ep = puntaje_ep;
        this.puntaje_ef = puntaje_ef;
        this.puntaje_total = puntaje_total;
        this.id_carrera = id_carrera;
        this.ci_alumno = ci_alumno;

    }

    public V_CalificacionesDTO(String ci_alumno, Integer id_carrera, String nombre_carrera) {
        this.ci_alumno = ci_alumno;
        this.id_carrera = id_carrera;
        this.nombre_carrera = nombre_carrera;

    }

    public V_CalificacionesDTO(Integer id_carrera, String nombre_carrera) {
        this.id_carrera = id_carrera;
        this.nombre_carrera = nombre_carrera;
    }

    public V_CalificacionesDTO(int id_alumno, int cod_alumno, String nombres_alumno, String apellidos_alumno) {
        this.id_alumno = id_alumno;
        this.cod_alumno = cod_alumno;
        this.nombres_alumno = nombres_alumno;
        this.apellidos_alumno = apellidos_alumno;

    }

    public V_CalificacionesDTO(int id_puntajes, int id_alumno, int cod_alumno, String nombres_alumno, String apellidos_alumno, String ci_alumno, int id_carrera, int id_asignatura, int t_anho_id_anho, Integer puntaje_tp, Integer puntaje_ep, Integer puntaje_ef) {
        this.id_puntajes = id_puntajes;
        this.id_alumno = id_alumno;
        this.cod_alumno = cod_alumno;
        this.nombres_alumno = nombres_alumno;
        this.apellidos_alumno = apellidos_alumno;
        this.ci_alumno = ci_alumno;
        this.id_carrera = id_carrera;
        this.id_asignatura = id_asignatura;
        this.t_anho_id_anho = t_anho_id_anho;
        this.puntaje_tp = puntaje_tp;
        this.puntaje_ep = puntaje_ep;
        this.puntaje_ef = puntaje_ef;
    }

    public V_CalificacionesDTO() {
    }

    private Integer id_puntajes;
    private Integer id_alumno;
    private Integer cod_alumno;
    private String nombres_alumno;
    private String apellidos_alumno;
    private String nombre_asignatura;
    private String nombre_carrera;
    private Integer t_alumnos_id_alumno;
    private Integer t_carreras_id_carrera;
    private Integer id_asignatura;
    private Integer t_anho_id_anho;
    private Integer puntaje_tp;
    private Integer puntaje_ep;
    private Integer puntaje_ef;
    private Integer puntaje_total;
    private Integer id_carrera;
    private String ci_alumno;
    private Date fecha_nac_alumno;

}
