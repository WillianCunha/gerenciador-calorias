/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.CaracteristicaAlimentoDAO;
import entity.CaracteristicaAlimento;
import java.util.List;
import model.CaracteristicaAlimentoModel;

/**
 *
 * @author visitante
 */
public class CaracteristicaAlimentoController {
    
    private CaracteristicaAlimentoDAO caracAlimentoDAO;
    private final CaracteristicaAlimentoModel model;
    
    public CaracteristicaAlimentoController(CaracteristicaAlimentoModel model) {
        this.model = model;
    }
    
    public void carregarCaracteristicas() {
        model.setFilterCriteria("Descrição");
        model.setFilterValue("");
        caracAlimentoDAO = new CaracteristicaAlimentoDAO();
        List<CaracteristicaAlimento> caracteristicas = caracAlimentoDAO.findAll();
        model.setCaracsAlimentos(caracteristicas);
    }
    
    public CaracteristicaAlimentoModel getModel() {
        return model;
    }
}
