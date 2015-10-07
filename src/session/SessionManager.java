/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Alimento;
import entity.Usuario;

/**
 *
 * @author visitante
 */
public class SessionManager {
    
    private static Usuario usuarioLogado;
    private static Alimento alimentoAtivo;
    
    private SessionManager(){
        
    }
    
    /**
     *
     * @return
     */
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    /**
     *
     * @param usuario
     */
    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }
    
    public static Alimento getAlimentoAtivo() {
        return alimentoAtivo;
    }
    
    public static void setAlimentoAtivo(Alimento alimento) {
        alimentoAtivo = alimento;
    }
    
}
