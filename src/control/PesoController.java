/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PesoDAO;
import entity.Peso;
import exception.BusinessException;
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
}
