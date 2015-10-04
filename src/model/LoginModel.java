/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Usuario;

/**
 *
 * @author visitante
 */
public class LoginModel extends BindableModel {

    private Usuario usuario;

    /**
     *
     */
    public LoginModel() {
        usuario = new Usuario();
    }

    /**
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        Usuario oldValue = this.usuario;
        this.usuario = usuario;
        firePropertyChange("usuario", usuario, usuario);
    }

}
