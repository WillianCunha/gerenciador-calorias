/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Peso;
import entity.Usuario;

/**
 *
 * @author visitante
 */
public class RelatorioModel extends BindableModel {

    private Usuario registroEditado;
    private Peso peso;

    public Usuario getRegistroEditado() {
        return registroEditado;
    }

    public void setRegistroEditado(Usuario registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }
    
    public void setPesoAtual(Peso peso) {
        this.peso = peso;
        firePropertyChange("peso", null, peso);
    }

}
