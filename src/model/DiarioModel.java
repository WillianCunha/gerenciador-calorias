/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Diario;
import entity.Refeicao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Aluca
 */
public class DiarioModel extends BindableModel {

    private Diario registroSelecionado;
    private Diario backupRegistro;
    private Diario registroEditado;
    private Diario diario;
    private List<Refeicao> refeicoes;
    private List<Refeicao> backupRefeicoes;
    private Boolean isEnabled;
    private String filterValue = null;
    private String filterCriteria = "Data";

    public DiarioModel() {

    }

    /**
     *
     * @return
     */
//    public Refeicao getRegistroSelecionado() {
//        return registroSelecionado;
//    }
//
//    /**
//     *
//     * @param refeicao
//     */
//    public void setRegistroSelecionado(Refeicao refeicao) {
//        this.registroSelecionado = refeicao;
//        firePropertyChange("registroSelecionado", null, refeicao);
//    }

    /**
     *
     * @return
     */
    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    /**
     *
     * @param refeicoes
     */
    public void setRefeicoes(List<Refeicao> refeicoes) {
        refeicoes.sort(new RefeicaoComparator());
        this.refeicoes = ObservableCollections.observableList(refeicoes);
        firePropertyChange("refeicoes", null, Collections.unmodifiableList(refeicoes));
    }

    /**
     *
     * @param refeicao
     */
    public void removeRefeicao(Refeicao refeicao) {
        this.refeicoes.remove(refeicao);
        this.refeicoes.sort(new RefeicaoComparator());
        firePropertyChange("refeicoes", null, Collections.unmodifiableList(refeicoes));
    }

    /**
     *
     * @param refeicao
     */
    public void addRefeicao(Refeicao refeicao) {
        this.refeicoes.add(refeicao);
        this.refeicoes.sort(new RefeicaoComparator());
        firePropertyChange("refeicoes", null, Collections.unmodifiableList(refeicoes));
    }

    /**
     *
     * @return
     */
//    public Refeicao getBackupRegistro() {
//        return backupRegistro;
//    }

    /**
     *
     * @param backupRegistro
     */
//    public void setBackupRegistro(Refeicao backupRegistro) {
//        if (backupRegistro == null) {
//            this.backupRegistro = null;
//        } else {
//            this.backupRegistro = backupRegistro;
//        }
//    }

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
//    public Refeicao getRegistroEditado() {
//        return registroEditado;
//    }

    /**
     *
     * @param registroEditado
     */
//    public void setRegistroEditado(Refeicao registroEditado) {
//        this.registroEditado = registroEditado;
//        firePropertyChange("registroEditado", null, registroEditado);
//    }

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
    public List<Refeicao> getBackupRefeicoes() {
        return backupRefeicoes;
    }

    /**
     *
     * @param backupRefeicoes
     */
    public void setBackupRefeicoes(List<Refeicao> backupRefeicoes) {
        this.backupRefeicoes = new ArrayList();
        this.backupRefeicoes.addAll(backupRefeicoes);
    }

    public void removeDiario(Diario diario) {
        diario = null;
        firePropertyChange("diario", null, diario);
    }

    public void addDiario(Diario diario) {
        this.diario = diario;
        firePropertyChange("diario", null, diario);
    }

    public void setRegistroEditado(Diario diario) {
        System.out.println("teste");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Diario getRegistroSelecionado() {
        return registroSelecionado;
    }

    public void setBackupRegistro(Diario backupRegistro) {
        if (backupRegistro == null) {
            this.backupRegistro = null;
        } else {
            this.backupRegistro = backupRegistro;
        }
    }

}
