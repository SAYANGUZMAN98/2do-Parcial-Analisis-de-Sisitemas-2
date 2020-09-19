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
public class AnhoDTO {

    private Integer id_anho;
    private String descrip_anho;

    public Integer getId_anho() {
        return id_anho;
    }

    public void setId_anho(Integer id_anho) {
        this.id_anho = id_anho;
    }

    public String getDescrip_anho() {
        return descrip_anho;
    }

    public void setDescrip_anho(String descrip_anho) {
        this.descrip_anho = descrip_anho;
    }

    public AnhoDTO() {
    }

    public AnhoDTO(Integer id_anho, String descrip_anho) {
        this.id_anho = id_anho;
        this.descrip_anho = descrip_anho;
    }

}
