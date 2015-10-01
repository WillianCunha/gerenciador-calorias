/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Peso;
import entity.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Aluca
 */
public class PesoModel extends BindableModel {
    private Peso peso;
    
    public PesoModel() {
        peso = new Peso();        
    }
    
    public Peso getPeso() {
        return peso;
    }
    
    public void setPeso(Peso peso) {
        Peso oldValue = this.peso;
        this.peso = peso;
        firePropertyChange("peso", peso, peso);
    }
    
    // Conversão de uma data em String para Date
    public void convertData(String dataString) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        peso.setData(df.parse(dataString));
//        return data;
    }
    
    // Não sei se funciona
    public void setUsuario(Usuario usuario) {
        this.peso.setUsuario(usuario);
    }
}
