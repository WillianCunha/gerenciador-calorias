/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Peso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de doações
 *
 * @author winston.sonnesen
 */
public class PesoUsuarioModel extends BindableModel {

    private Peso registroSelecionado;
    private Peso backupRegistro;
    private Peso registroEditado;
    private List<Peso> pesos;
    private List<Peso> backupPesos;
    private Boolean isEnabled;
    private String filterValue = null;
    private String filterCriteria = "Data";

    /**
     * Construtor da classe
     */
    public PesoUsuarioModel() {

    }

    /**
     *
     * @return
     */
    public Peso getRegistroSelecionado() {
        return registroSelecionado;
    }

    /**
     *
     * @param peso
     */
    public void setRegistroSelecionado(Peso peso) {
        this.registroSelecionado = peso;
        firePropertyChange("registroSelecionado", null, peso);
    }

    /**
     *
     * @return
     */
    public List<Peso> getPesos() {
        return pesos;
    }

    /**
     *
     * @param pesos
     */
    public void setPesos(List<Peso> pesos) {
        pesos.sort(new PesoComparator());
        this.pesos = ObservableCollections.observableList(pesos);
        firePropertyChange("pesos", null, Collections.unmodifiableList(pesos));
    }

    /**
     *
     * @param peso
     */
    public void removePeso(Peso peso) {
        this.pesos.remove(peso);
        this.pesos.sort(new PesoComparator());
        firePropertyChange("pesos", null, Collections.unmodifiableList(pesos));
    }

    /**
     *
     * @param peso
     */
    public void addPeso(Peso peso) {
        this.pesos.add(peso);
        this.pesos.sort(new PesoComparator());
        firePropertyChange("pesos", null, Collections.unmodifiableList(pesos));
    }

    /**
     *
     * @return
     */
    public Peso getBackupRegistro() {
        return backupRegistro;
    }

    /**
     *
     * @param backupRegistro
     */
    public void setBackupRegistro(Peso backupRegistro) {
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
    public Peso getRegistroEditado() {
        return registroEditado;
    }

    /**
     *
     * @param registroEditado
     */
    public void setRegistroEditado(Peso registroEditado) {
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
    public List<Peso> getBackupPesos() {
        return backupPesos;
    }

    /**
     *
     * @param backupPesos
     */
    public void setBackupPesos(List<Peso> backupPesos) {
        this.backupPesos = new ArrayList();
        this.backupPesos.addAll(backupPesos);
    }

}
