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
public class UsuariosDTO {

    private Integer id_usuario;
    private String usuario;
    private String pass;
    private String email_usuario;
    private Integer t_tipo_usuario_id_tipo_usuario;

    public UsuariosDTO(int id_usuario, String usuario) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public Integer getT_tipo_usuario_id_tipo_usuario() {
        return t_tipo_usuario_id_tipo_usuario;
    }

    public void setT_tipo_usuario_id_tipo_usuario(Integer t_tipo_usuario_id_tipo_usuario) {
        this.t_tipo_usuario_id_tipo_usuario = t_tipo_usuario_id_tipo_usuario;
    }

    public UsuariosDTO(Integer id_usuario, String usuario, String pass, String email_usuario, Integer t_tipo_usuario_id_tipo_usuario) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.pass = pass;
        this.email_usuario = email_usuario;
        this.t_tipo_usuario_id_tipo_usuario = t_tipo_usuario_id_tipo_usuario;
    }

    public UsuariosDTO() {
    }

}
