/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.RefeicaoDAO;
import entity.Refeicao;
import exception.BusinessException;
import model.RefeicaoModel;

/**
 *
 * @author visitante
 */
public class RefeicaoController {
    
    private final RefeicaoModel model;
    
    public RefeicaoController(RefeicaoModel model) {
        this.model = model;
    }
    
    public void saveRefeicao(Refeicao refeicao) throws BusinessException {
        RefeicaoDAO dao = new RefeicaoDAO();
        dao.save(refeicao);
    }
    
}
