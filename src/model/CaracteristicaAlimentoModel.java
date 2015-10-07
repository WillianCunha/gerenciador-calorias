/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.CaracteristicaAlimento;
import java.util.List;

/**
 *
 * @author visitante
 */
public class CaracteristicaAlimentoModel extends BindableModel {
    
    private CaracteristicaAlimento caracAlimento;
    private CaracteristicaAlimento backupRegistro;
    private CaracteristicaAlimento registroEditado;
    private List<CaracteristicaAlimento> caracsAlimentos;
    private String filterCriteria = "Descrição";
    
    public CaracteristicaAlimentoModel() {
        caracAlimento = new CaracteristicaAlimento();
    }
    
    public CaracteristicaAlimento getCaracteristicaAlimento() {
        return caracAlimento;
    }
    
    public void setCaracteristicaAlimento(CaracteristicaAlimento caractAlimento) {
        CaracteristicaAlimento oldValue = this.caracAlimento;
        this.caracAlimento = caractAlimento;
        firePropertyChange("caracteristicaalimento", caractAlimento, caractAlimento);
    }
    
    public List<CaracteristicaAlimento> getCaracteristicasAlimentos() {
        return caracsAlimentos;
    }
    
    public CaracteristicaAlimento getRegistroSelecionado() {
        return caracAlimento;
    }
    
    public void setBackupRegistro(CaracteristicaAlimento backupRegistro) {
        if (backupRegistro == null) {
            this.backupRegistro = null;
        } else {
            this.backupRegistro = backupRegistro;
        }
    }
    
    public void setRegistroEditado(CaracteristicaAlimento registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }

    public void setFilterCriteria(String filterCriteria) {
        this.filterCriteria = filterCriteria;
        firePropertyChange("filterCriteria", null, filterCriteria);
    }

    public void setFilterValue(String filterValue) {
//        this.filterValue = filterValue;
    }

    public void setCaracsAlimentos(List<CaracteristicaAlimento> caracteristicas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
