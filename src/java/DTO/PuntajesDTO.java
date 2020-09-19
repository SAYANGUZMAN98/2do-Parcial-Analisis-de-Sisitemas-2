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
public class PuntajesDTO {

    private Integer id_puntajes;
    private Integer t_asignatura_id_asignatura;
    private Integer t_alumnos_id_alumno;
    private Integer t_anho_id_anho;
    private String puntaje_tp;
    private String puntaje_ep;
    private String puntaje_ef;
    private String puntaje_total;
    private String id_usuario;

    public PuntajesDTO(Integer t_asignatura_id_asignatura, Integer t_alumnos_id_alumno, Integer id_puntajes) {
        this.t_asignatura_id_asignatura = t_asignatura_id_asignatura;
        this.t_alumnos_id_alumno = t_alumnos_id_alumno;
        this.id_puntajes = id_puntajes;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_puntajes() {
        return id_puntajes;
    }

    public void setId_puntajes(Integer id_puntajes) {
        this.id_puntajes = id_puntajes;
    }

    public Integer getT_asignatura_id_asignatura() {
        return t_asignatura_id_asignatura;
    }

    public void setT_asignatura_id_asignatura(Integer t_asignatura_id_asignatura) {
        this.t_asignatura_id_asignatura = t_asignatura_id_asignatura;
    }

    public Integer getT_alumnos_id_alumno() {
        return t_alumnos_id_alumno;
    }

    public void setT_alumnos_id_alumno(Integer t_alumnos_id_alumno) {
        this.t_alumnos_id_alumno = t_alumnos_id_alumno;
    }

    public Integer getT_anho_id_anho() {
        return t_anho_id_anho;
    }

    public void setT_anho_id_anho(Integer t_anho_id_anho) {
        this.t_anho_id_anho = t_anho_id_anho;
    }

    public String getPuntaje_tp() {
        return puntaje_tp;
    }

    public void setPuntaje_tp(String puntaje_tp) {
        this.puntaje_tp = puntaje_tp;
    }

    public String getPuntaje_ep() {
        return puntaje_ep;
    }

    public void setPuntaje_ep(String puntaje_ep) {
        this.puntaje_ep = puntaje_ep;
    }

    public String getPuntaje_ef() {
        return puntaje_ef;
    }

    public void setPuntaje_ef(String puntaje_ef) {
        this.puntaje_ef = puntaje_ef;
    }

    public String getPuntaje_total() {
        return puntaje_total;
    }

    public void setPuntaje_total(String puntaje_total) {
        this.puntaje_total = puntaje_total;
    }

    public PuntajesDTO(Integer t_asignatura_id_asignatura, Integer t_alumnos_id_alumno, Integer t_anho_id_anho, String puntaje_tp, String puntaje_ep, String puntaje_ef, String puntaje_total) {
        this.t_asignatura_id_asignatura = t_asignatura_id_asignatura;
        this.t_alumnos_id_alumno = t_alumnos_id_alumno;
        this.t_anho_id_anho = t_anho_id_anho;
        this.puntaje_tp = puntaje_tp;
        this.puntaje_ep = puntaje_ep;
        this.puntaje_ef = puntaje_ef;
        this.puntaje_total = puntaje_total;
    }

    public PuntajesDTO() {
    }

}
