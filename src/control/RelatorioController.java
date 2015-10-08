/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PesoUsuarioDAO;
import dao.UsuarioDAO;
import entity.Peso;
import entity.Usuario;
import model.RelatorioModel;

/**
 *
 * @author visitante
 */
public class RelatorioController implements IController {
    
    private UsuarioDAO usuarioDAO;
    private PesoUsuarioDAO pesoUsuarioDAO;
    private final RelatorioModel model;
    
    public RelatorioController(RelatorioModel model) {
        this.model = model;
    }
    
    public RelatorioModel getModel() {
        return model;
    }
    
    public void carregarPesoAtual(Usuario usuario) {
        pesoUsuarioDAO = new PesoUsuarioDAO();
        Peso pesoAtual = pesoUsuarioDAO.findPesoAtualUsuario(usuario);
        model.setPesoAtual(pesoAtual);
    }
    
}
