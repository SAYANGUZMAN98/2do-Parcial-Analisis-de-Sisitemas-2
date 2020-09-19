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
public class AlumnoDTO {

    private Integer id_alumno;
    private Integer cod_alumno;
    private String nombres_alumno;
    private String apellidos_alumno;
    private String ci_alumno;

    private String fecha_nac_alumno;
    //private Date fecha_nac_alumno;


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

    public String getCi_alumno() {
        return ci_alumno;
    }

    public void setCi_alumno(String ci_alumno) {
        this.ci_alumno = ci_alumno;
    }

    public String getFecha_nac_alumno() {
        return fecha_nac_alumno;
    }

    public void setFecha_nac_alumno(String fecha_nac_alumno) {
        this.fecha_nac_alumno = fecha_nac_alumno;
    }

//    public Date getFecha_nac_alumno() {
//        return fecha_nac_alumno;
//    }
//
//    public void setFecha_nac_alumno(Date fecha_nac_alumno) {
//        this.fecha_nac_alumno = fecha_nac_alumno;
//    }
    public AlumnoDTO(Integer id_alumno, Integer cod_alumno, String nombres_alumno, String apellidos_alumno, String ci_alumno, String fecha_nac_alumno) {
        this.id_alumno = id_alumno;
        this.cod_alumno = cod_alumno;
        this.nombres_alumno = nombres_alumno;
        this.apellidos_alumno = apellidos_alumno;
        this.ci_alumno = ci_alumno;
        this.fecha_nac_alumno = fecha_nac_alumno;
    }

    public AlumnoDTO(Integer id_alumno, Integer cod_alumno, String nombres_alumno, String apellidos_alumno, String ci_alumno) {
        this.id_alumno = id_alumno;
        this.cod_alumno = cod_alumno;
        this.nombres_alumno = nombres_alumno;
        this.apellidos_alumno = apellidos_alumno;
        this.ci_alumno = ci_alumno;

    }

    public AlumnoDTO(Integer cod_alumno, String nombres_alumno) {
        this.cod_alumno = cod_alumno;
        this.nombres_alumno = nombres_alumno;
    }

    public AlumnoDTO() {
    }

}
