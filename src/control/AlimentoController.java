/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AlimentoDAO;
import entity.Alimento;
import exception.BusinessException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.AlimentoModel;

/**
 *
 * @author Aluca
 */
public class AlimentoController {

    private final AlimentoModel model;
    private AlimentoDAO alimentoDAO;

    /**
     *
     * @param model
     */
    public AlimentoController(AlimentoModel model) {
        this.model = model;
    }

    public void carregarAlimentos() {
        model.setFilterCriteria("Nome");
        model.setFilterValue("");
        alimentoDAO = new AlimentoDAO();
        List<Alimento> alimentos = alimentoDAO.findAll();
        model.setAlimentos(alimentos);
    }
    
    public void remove(Alimento alimento) throws BusinessException {
        alimentoDAO = new AlimentoDAO();
        alimentoDAO.remove(alimento);
        model.removeAlimento(alimento);
    }

    /**
     *
     * @param alimento
     * @throws BusinessException
     */
    public void saveAlimento(Alimento alimento) throws BusinessException {
        alimentoDAO = new AlimentoDAO();
        alimento = alimentoDAO.save(alimento);
        Alimento a = new Alimento(alimento.getId(), alimento.getNome(), alimento.getTipo());
        model.removeAlimento(alimento);
        model.addAlimento(a);
    }

    public AlimentoModel getModel() {
        return model;
    }
    
    public void doFilter(String value, String criteria) {
        Predicate<Alimento> predicate;

        switch (criteria) {
            case "Nome":
                try {
                    predicate = (Alimento alimento) -> alimento.getNome().compareTo(value) == 0;
                    List<Alimento> resultado = model.getAlimentos().stream().filter(predicate).collect(Collectors.toList());
                    model.setBackupAlimentos(model.getAlimentos());
                    model.setAlimentos(resultado);
                } catch (Exception ex) {
                }
                break;
            case "Tipo":
                try {
                    predicate = (Alimento alimento) -> alimento.getTipo().compareTo(value) == 0;
                    List<Alimento> resultado = model.getAlimentos().stream().filter(predicate).collect(Collectors.toList());
                    model.setBackupAlimentos(model.getAlimentos());
                    model.setAlimentos(resultado);
                } catch (Exception ex) {
                }
                break;
        }
    }
}
