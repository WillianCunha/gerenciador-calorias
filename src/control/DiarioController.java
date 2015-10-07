/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DiarioDAO;
import entity.Diario;
import entity.Usuario;
import exception.BusinessException;
import model.DiarioModel;

/**
 *
 * @author Aluca
 */
public class DiarioController implements IController {
    
    private DiarioDAO diarioDAO;
    private final DiarioModel model;
    
    public DiarioController(DiarioModel model) {
        this.model = model;
    }
    
    public void carregarDiario(Usuario usuario) {
//        model.setFilterCriteria("Data");
//        model.setFilterValue("");
        diarioDAO = new DiarioDAO();
        Diario diario = diarioDAO.findByUsuario(usuario);
    }
    
    public void remove(Diario diario) throws BusinessException {
        diarioDAO = new DiarioDAO();
        diarioDAO.remove(diario);
        model.removeDiario(diario);
    }
    
    public void save(Diario diario) throws BusinessException {
        diarioDAO = new DiarioDAO();
        diario = diarioDAO.save(diario);
        Diario d = new Diario(diario.getId());
        d.setNome(diario.getNome());
        d.setRegistroList(diario.getRegistroList());
        d.setUsuario(diario.getUsuario());
        model.removeDiario(diario);
        model.addDiario(d);
    }
}
