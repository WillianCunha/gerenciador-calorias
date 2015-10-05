/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Alimento;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Aluca
 */
public class AlimentoModel extends BindableModel {
    
    private Alimento registroSelecionado;
    private Alimento backupRegistro;
    private Alimento registroEditado;
    private List<Alimento> alimentos;
    private List<Alimento> backupAlimentos;
    private Boolean isEnabled;
    private String filterValue = null;
    private String filterCriteria = "Nome";

    /**
     * Construtor da classe
     */
    public AlimentoModel() {

    }

    /**
     *
     * @return
     */
    public Alimento getRegistroSelecionado() {
        return registroSelecionado;
    }

    /**
     *
     * @param alimento
     */
    public void setRegistroSelecionado(Alimento alimento) {
        this.registroSelecionado = alimento;
        firePropertyChange("registroSelecionado", null, alimento);
    }

    /**
     *
     * @return
     */
    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    /**
     *
     * @param alimentos
     */
    public void setAlimentos(List<Alimento> alimentos) {
        alimentos.sort(new AlimentoComparator());
        this.alimentos = ObservableCollections.observableList(alimentos);
        firePropertyChange("alimentos", null, Collections.unmodifiableList(alimentos));
    }

    /**
     *
     * @param alimento
     */
    public void removeAlimento(Alimento alimento) {
        this.alimentos.remove(alimento);
        this.alimentos.sort(new AlimentoComparator());
        firePropertyChange("alimentos", null, Collections.unmodifiableList(alimentos));
    }

    /**
     *
     * @param alimento
     */
    public void addAlimento(Alimento alimento) {
        this.alimentos.add(alimento);
        this.alimentos.sort(new AlimentoComparator());
        firePropertyChange("alimentos", null, Collections.unmodifiableList(alimentos));
    }

    /**
     *
     * @return
     */
    public Alimento getBackupRegistro() {
        return backupRegistro;
    }

    /**
     *
     * @param backupRegistro
     */
    public void setBackupRegistro(Alimento backupRegistro) {
        if (backupRegistro == null) {
            this.backupRegistro = null;
        } else {
            this.backupRegistro = backupRegistro;
        }
    }

    /**
     *
     * @return
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     *
     * @param isEnabled
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        firePropertyChange("isEnabled", null, isEnabled);
    }

    /**
     *
     * @return
     */
    public Alimento getRegistroEditado() {
        return registroEditado;
    }

    /**
     *
     * @param registroEditado
     */
    public void setRegistroEditado(Alimento registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }

    /**
     *
     * @return
     */
    public String getFilterValue() {
        return filterValue;
    }

    /**
     *
     * @param filterValue
     */
    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
        firePropertyChange("filterValue", null, filterValue);
    }

    /**
     *
     * @return
     */
    public String getFilterCriteria() {
        return filterCriteria;
    }

    /**
     *
     * @param filterCriteria
     */
    public void setFilterCriteria(String filterCriteria) {
        this.filterCriteria = filterCriteria;
        firePropertyChange("filterCriteria", null, filterCriteria);
    }

    /**
     *
     * @return
     */
    public List<Alimento> getBackupAlimentos() {
        return backupAlimentos;
    }

    /**
     *
     * @param backupAlimentos
     */
    public void setBackupAlimentos(List<Alimento> backupAlimentos) {
        this.backupAlimentos = new ArrayList();
        this.backupAlimentos.addAll(backupAlimentos);
    }
}
