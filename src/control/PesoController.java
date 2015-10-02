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

    // Checar qual o peso é atual
    public Peso PesoAtual(List<Peso> listaPeso) {
//        PesoDAO dao = new PesoDAO();
        Peso pesoAtual = new Peso();        
        
        for (int i = 0; i < listaPeso.size() - 1; i++) {
            if (listaPeso.get(i).getData().compareTo(listaPeso.get(i+1).getData()) > 0) {
                pesoAtual = listaPeso.get(i);
            }
        }
        
        return pesoAtual;
    }
}
