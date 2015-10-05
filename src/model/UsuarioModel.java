<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de doações
 *
 * @author winston.sonnesen
 */
public class UsuarioModel extends BindableModel {

    private Usuario registroSelecionado;
    private Usuario backupRegistro;
    private Usuario registroEditado;
    private List<Usuario> usuarios;
    private List<Usuario> backupUsuarios;
    private Boolean isEnabled;

    /**
     * Construtor da classe
     */
    public UsuarioModel() {

    }

    /**
     *
     * @return
     */
    public Usuario getRegistroSelecionado() {
        return registroSelecionado;
    }

    /**
     *
     * @param usuario
     */
    public void setRegistroSelecionado(Usuario usuario) {
        this.registroSelecionado = usuario;
        firePropertyChange("registroSelecionado", null, usuario);
    }

    /**
     *
     * @return
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param usuarios
     */
    public void setUsuarios(List<Usuario> usuarios) {
        usuarios.sort(new UsuarioComparator());
        this.usuarios = ObservableCollections.observableList(usuarios);
        firePropertyChange("usuarios", null, Collections.unmodifiableList(usuarios));
    }

    /**
     *
     * @param usuario
     */
    public void removeUsuario(Usuario usuario) {
        if (usuarios != null) {
            usuarios.remove(usuario);
            usuarios.sort(new UsuarioComparator());
            firePropertyChange("usuarios", null, Collections.unmodifiableList(usuarios));
        }
    }

    /**
     *
     * @param usuario
     */
    public void addUsuario(Usuario usuario) {
        if (usuarios != null) {
            usuarios.add(usuario);
            usuarios.sort(new UsuarioComparator());
            firePropertyChange("usuarios", null, Collections.unmodifiableList(usuarios));
        }
    }

    /**
     *
     * @return
     */
    public Usuario getBackupRegistro() {
        return backupRegistro;
    }

    /**
     *
     * @param backupRegistro
     */
    public void setBackupRegistro(Usuario backupRegistro) {
        if (backupRegistro == null) {
            this.backupRegistro = null;
        } else {
            this.backupRegistro = backupRegistro;
        }
    }

    /**
     *
     * @return
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     *
     * @param isEnabled
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        firePropertyChange("isEnabled", null, isEnabled);
    }

    /**
     *
     * @return
     */
    public Usuario getRegistroEditado() {
        return registroEditado;
    }

    /**
     *
     * @param registroEditado
     */
    public void setRegistroEditado(Usuario registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }

    /**
     *
     * @return
     */
    public List<Usuario> getBackupUsuarios() {
        return backupUsuarios;
    }

    /**
     *
     * @param backupUsuarios
     */
    public void setBackupUsuarios(List<Usuario> backupUsuarios) {
        this.backupUsuarios = new ArrayList();
        this.backupUsuarios.addAll(backupUsuarios);
    }

}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de doações
 *
 * @author winston.sonnesen
 */
public class UsuarioModel extends BindableModel {

    private Usuario registroSelecionado;
    private Usuario backupRegistro;
    private Usuario registroEditado;
    private List<Usuario> usuarios;
    private List<Usuario> backupUsuarios;
    private Boolean isEnabled;

    /**
     * Construtor da classe
     */
    public UsuarioModel() {

    }

    /**
     *
     * @return
     */
    public Usuario getRegistroSelecionado() {
        return registroSelecionado;
    }

    /**
     *
     * @param usuario
     */
    public void setRegistroSelecionado(Usuario usuario) {
        this.registroSelecionado = usuario;
        firePropertyChange("registroSelecionado", null, usuario);
    }

    /**
     *
     * @return
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param usuarios
     */
    public void setUsuarios(List<Usuario> usuarios) {
        usuarios.sort(new UsuarioComparator());
        this.usuarios = ObservableCollections.observableList(usuarios);
        firePropertyChange("usuarios", null, Collections.unmodifiableList(usuarios));
    }

    /**
     *
     * @param usuario
     */
    public void removeUsuario(Usuario usuario) {
        if (usuarios != null) {
            usuarios.remove(usuario);
            usuarios.sort(new UsuarioComparator());
            firePropertyChange("usuarios", null, Collections.unmodifiableList(usuarios));
        }
    }

    /**
     *
     * @param usuario
     */
    public void addUsuario(Usuario usuario) {
        if (usuarios != null) {
            usuarios.add(usuario);
            usuarios.sort(new UsuarioComparator());
            firePropertyChange("usuarios", null, Collections.unmodifiableList(usuarios));
        }
    }

    /**
     *
     * @return
     */
    public Usuario getBackupRegistro() {
        return backupRegistro;
    }

    /**
     *
     * @param backupRegistro
     */
    public void setBackupRegistro(Usuario backupRegistro) {
        if (backupRegistro == null) {
            this.backupRegistro = null;
        } else {
            this.backupRegistro = backupRegistro;
        }
    }

    /**
     *
     * @return
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     *
     * @param isEnabled
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        firePropertyChange("isEnabled", null, isEnabled);
    }

    /**
     *
     * @return
     */
    public Usuario getRegistroEditado() {
        return registroEditado;
    }

    /**
     *
     * @param registroEditado
     */
    public void setRegistroEditado(Usuario registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }

    /**
     *
     * @return
     */
    public List<Usuario> getBackupUsuarios() {
        return backupUsuarios;
    }

    /**
     *
     * @param backupUsuarios
     */
    public void setBackupUsuarios(List<Usuario> backupUsuarios) {
        this.backupUsuarios = new ArrayList();
        this.backupUsuarios.addAll(backupUsuarios);
    }

}
>>>>>>> 0925dd2439598a0ae34773ff8b39981c0e9f469e
