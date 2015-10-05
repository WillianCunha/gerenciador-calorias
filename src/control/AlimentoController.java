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

    private AlimentoDAO alimentoDAO;
    private final AlimentoModel model;

    /**
     *
     * @param model
     */
    public AlimentoController(AlimentoModel model) {
        this.model = model;
    }

    /**
     * Efetua carga a partir dos registros da tabela alimento
     *
     * 
     */
    public void carregarAlimentos() {
        model.setFilterCriteria("");
        model.setFilterValue("");
        alimentoDAO = new AlimentoDAO();
        List<Alimento> alimentos = alimentoDAO.findAll();
        model.setAlimentos(alimentos);
    }

    /**
     *
     * @param alimento
     * @throws BusinessException
     */
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
    public void save(Alimento alimento) throws BusinessException {
        alimentoDAO = new AlimentoDAO();
        alimento = alimentoDAO.save(alimento);
        Alimento a = new Alimento(alimento.getId(), alimento.getNome(), alimento.getTipo());
        a.setPorcaoList(alimento.getPorcaoList());
        a.setCaracteristicaAlimentoList(alimento.getCaracteristicaAlimentoList());
        model.removeAlimento(alimento);
        model.addAlimento(a);
    }

    /**
     *
     * @return
     */
    public AlimentoModel getModel() {
        return model;
    }

    /**
     *
     * @param value
     * @param criteria
     */
    public void doFilter(String value, String criteria) {
        Predicate<Alimento> predicate;

        switch (criteria) {
            case "Nome":
                try {
                    predicate = (Alimento alimento) -> alimento.getNome().equalsIgnoreCase(value);
                    List<Alimento> resultado = model.getAlimentos().stream().filter(predicate).collect(Collectors.toList());
                    model.setBackupAlimentos(model.getAlimentos());
                    model.setAlimentos(resultado);
                } catch (Exception ex) {

                }
                break;
            case "Tipo":
                try {
                    predicate = (Alimento alimento) -> alimento.getTipo().equalsIgnoreCase(value);
                    List<Alimento> resultado = model.getAlimentos().stream().filter(predicate).collect(Collectors.toList());
                    model.setBackupAlimentos(model.getAlimentos());
                    model.setAlimentos(resultado);
                } catch (Exception ex) {

                }
                break;
        }
    }
}
