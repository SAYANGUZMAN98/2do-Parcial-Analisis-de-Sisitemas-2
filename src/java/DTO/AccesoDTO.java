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
public class AccesoDTO {

    private Integer id_usuarios;
    private String usuario;
    private String pass;
    private Integer email_usuario;
    private Integer t_tipo_usuario_id_tipo_usuario;

    public Integer getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(Integer id_usuarios) {
        this.id_usuarios = id_usuarios;
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

    public Integer getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(Integer email_usuario) {
        this.email_usuario = email_usuario;
    }

    public Integer getT_tipo_usuario_id_tipo_usuario() {
        return t_tipo_usuario_id_tipo_usuario;
    }

    public void setT_tipo_usuario_id_tipo_usuario(Integer t_tipo_usuario_id_tipo_usuario) {
        this.t_tipo_usuario_id_tipo_usuario = t_tipo_usuario_id_tipo_usuario;
    }

}
