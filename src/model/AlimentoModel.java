/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Alimento;

/**
 *
 * @author Aluca
 */
public class AlimentoModel extends BindableModel {
    private Alimento alimento;
    
    public AlimentoModel() {
        alimento = new Alimento();
    }
    
    public Alimento getAlimento() {
        return alimento;
    }
    
    public void setAlimento(Alimento alimento) {
        Alimento oldValue = this.alimento;
        this.alimento = alimento;
        firePropertyChange("alimento", alimento, alimento);
    }
}
