/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AlimentoDAO;
import entity.Alimento;
import exception.BusinessException;
import model.AlimentoModel;

/**
 *
 * @author Aluca
 */
public class AlimentoController {
    
    private final AlimentoModel model;
    
    public AlimentoController(AlimentoModel model) {
        this.model = model;
    }
    
    public void saveAlimento(Alimento alimento) throws BusinessException {
        AlimentoDAO dao = new AlimentoDAO();
        dao.save(alimento);
    }
}
