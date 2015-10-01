/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PesoDAO;
import entity.Peso;
import exception.BusinessException;
import java.util.List;
import model.PesoModel;

/**
 *
 * @author visitante
 */
public class PesoController {

    private final PesoModel model;

    public PesoController(PesoModel model) {
        this.model = model;
    }

    public void savePeso(Peso peso) throws BusinessException {
        PesoDAO dao = new PesoDAO();
        dao.save(peso);
    }

    // Checar contra o banco se o peso é realmente da data mais recente

    public boolean isPesoAtual(Peso peso) {
        PesoDAO dao = new PesoDAO();
        List<Peso> listaPeso = dao.findByUsuarioByPesoAtual(model.getPeso().getUsuario(), true);
        boolean isMaior = false;
        
        for (int i = 0; i < listaPeso.size(); i++) {
            if (peso.getData().compareTo(listaPeso.get(i).getData()) > 0) {
                isMaior = true;
            }
        }
        
        return isMaior;
    }
}
