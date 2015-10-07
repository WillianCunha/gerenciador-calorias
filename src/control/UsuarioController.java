/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.UsuarioDAO;
import entity.Usuario;
import exception.BusinessException;
import java.util.List;
import model.UsuarioModel;

/**
 *
 * @author winston.sonnesen
 */
public class UsuarioController implements IController {

    private UsuarioDAO usuarioDAO;
    private final UsuarioModel model;

    /**
     *
     * @param model
     */
    public UsuarioController(UsuarioModel model) {
        this.model = model;
    }

    /**
     * Efetua carga a partir dos registros da tabela inscricao
     *
     */
    public void carregarUsuarios() {
        usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.findAll();
        model.setUsuarios(usuarios);
    }

    /**
     *
     * @param usuario
     * @throws BusinessException
     */
    public void remove(Usuario usuario) throws BusinessException {
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.remove(usuario);
        model.removeUsuario(usuario);
    }

    /**
     *
     * @param usuario
     * @throws BusinessException
     */
    public void save(Usuario usuario) throws BusinessException {
        usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.save(usuario);
        Usuario u = new Usuario(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha());
        u.setAltura(usuario.getAltura());
        u.setDataNascimento(usuario.getDataNascimento());
        u.setGenero(usuario.getGenero());
        model.removeUsuario(usuario);
        model.addUsuario(u);
    }

    /**
     *
     * @return
     */
    public UsuarioModel getModel() {
        return model;
    }

}
