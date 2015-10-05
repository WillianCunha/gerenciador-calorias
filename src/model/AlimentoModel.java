/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Alimento;
import entity.CaracteristicaAlimento;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Aluca
 */
public class AlimentoModel extends BindableModel {

    private Alimento alimento;
    private List<Alimento> alimentos;
    private List<CaracteristicaAlimento> caracteristicas;
    private CaracteristicaAlimento backupRegistroCaracteristicaAlimento;
    private Alimento backupRegistro;
    private CaracteristicaAlimento registroSelecionadoCaracteristicaAlimento;
    private Alimento registroSelecionado;
    private String filterValue = null;
    private String filterCriteria = "Nome";
    private List<Alimento> backupAlimentos;
    private Alimento registroEditado;

    /**
     *
     */
    public AlimentoModel() {
        alimento = new Alimento();
    }

    /**
     *
     * @return
     */
    public Alimento getAlimento() {
        return alimento;
    }

    /**
     *
     * @param alimento
     */
    public void setAlimento(Alimento alimento) {
        Alimento oldValue = this.alimento;
        this.alimento = alimento;
        firePropertyChange("alimento", alimento, alimento);
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
//        alimentos.sort(null);
        this.alimentos = ObservableCollections.observableList(alimentos);
        firePropertyChange("alimentos", null, Collections.unmodifiableList(alimentos));
    }

    public void removeAlimento(Alimento alimento) {
        this.alimentos.remove(alimento);
//        this.alimentos.sort(new AlimentoComparator());
        firePropertyChange("alimentos", null, Collections.unmodifiableList(alimentos));
    }

    public void setBackupRegistro(Alimento backupRegistro) {
        if (backupRegistro == null) {
            this.backupRegistro = null;
        } else {
            this.backupRegistro = backupRegistro;
        }
    }

    public void setRegistroSelecionado(Alimento alimento) {
        this.registroSelecionado = alimento;
        firePropertyChange("registroSelecionado", null, alimento);
    }
    
    public void setRegistroSelecionadoCaracteristicaAlimento(CaracteristicaAlimento caracteristica) {
        this.registroSelecionadoCaracteristicaAlimento = caracteristica;
        firePropertyChange("registroSelecionadoCaracteristicaAlimento", null, caracteristica);
    }

    public void setFilterCriteria(String filterCriteria) {
        this.filterCriteria = filterCriteria;
        firePropertyChange("filterCriteria", null, filterCriteria);
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
        firePropertyChange("filterValue", null, filterValue);
    }

    public void setBackupAlimentos(List<Alimento> backupAlimentos) {
        this.backupAlimentos = new ArrayList();
        this.backupAlimentos.addAll(backupAlimentos);
    }

    public String getFilterCriteria() {
        return filterCriteria;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public Alimento getRegistroSelecionado() {
        return registroSelecionado;
    }
    
    public Alimento getRegistroEditado() {
        return registroEditado;
    }

    public void setRegistroEditado(Alimento registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }

    public List<CaracteristicaAlimento> getCaracteristicaAlimentos() {
        return caracteristicas;
    }
    
    public CaracteristicaAlimento getBackupRegistroCaracteristicaAlimento() {
        return backupRegistroCaracteristicaAlimento;
    }
    
    public void setBackupRegistroCaracteristicaAlimento(CaracteristicaAlimento backupRegistroCaracteristicaAlimento) {
        if (backupRegistroCaracteristicaAlimento == null) {
            this.backupRegistroCaracteristicaAlimento = null;
        } else {
            this.backupRegistroCaracteristicaAlimento = backupRegistroCaracteristicaAlimento;
        }
    }

    public void addAlimento(Alimento alimento) {
        this.alimentos.add(alimento);
//        this.alimentos.sort(null);
        firePropertyChange("alimentos", null, Collections.unmodifiableList(alimentos));
    }
}
