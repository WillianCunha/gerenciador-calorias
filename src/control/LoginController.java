/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.UsuarioDAO;
import entity.Usuario;
import exception.BusinessException;
import model.LoginModel;
import session.SessionManager;

/**
 *
 * @author visitante
 */
public class LoginController {
    
    private final LoginModel model;
    
    /**
     *
     * @param model
     */
    public LoginController(LoginModel model) {
        this.model = model;
    }
    
    /**
     *
     * @param usuario
     * @throws BusinessException
     */
    public void doLogin(Usuario usuario) throws BusinessException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioLogado = dao.findByLoginSenha(usuario.getLogin(), usuario.getSenha());
        if (usuarioLogado == null) {
            throw new BusinessException(BusinessException.USUARIO_NAO_CADASTRADO);
        }
        model.setUsuario(usuarioLogado);
        SessionManager.setUsuarioLogado(usuarioLogado);
    }
    
}
