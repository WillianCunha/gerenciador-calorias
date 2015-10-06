/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.CaracteristicaAlimentoDAO;
import model.CaracteristicaAlimentoModel;

/**
 *
 * @author visitante
 */
public class CaracteristicaAlimentoController {
    
    private CaracteristicaAlimentoDAO caracteristicaAlimentoDAO;
    private final CaracteristicaAlimentoModel model;
    
    public CaracteristicaAlimentoController(CaracteristicaAlimentoModel model) {
        this.model = model;
    }
    
    public CaracteristicaAlimentoModel getModel() {
        return model;
    }
}
