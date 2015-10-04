/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PesoUsuarioDAO;
import entity.Peso;
import entity.Usuario;
import exception.BusinessException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.PesoUsuarioModel;

/**
 *
 * @author winston.sonnesen
 */
public class PesoUsuarioController implements IController {

    private PesoUsuarioDAO pesoDAO;
    private final PesoUsuarioModel model;

    /**
     *
     * @param model
     */
    public PesoUsuarioController(PesoUsuarioModel model) {
        this.model = model;
    }

    /**
     * Efetua carga a partir dos registros da tabela inscricao
     *
     * @param usuario
     */
    public void carregarPesos(Usuario usuario) {
        model.setFilterCriteria("Data");
        model.setFilterValue("");        
        pesoDAO = new PesoUsuarioDAO();
        List<Peso> pesos = pesoDAO.findByUsuario(usuario);
        model.setPesos(pesos);
    }

    /**
     *
     * @param peso
     * @throws BusinessException
     */
    public void remove(Peso peso) throws BusinessException {
        pesoDAO = new PesoUsuarioDAO();
        pesoDAO.remove(peso);
        model.removePeso(peso);
    }

    /**
     *
     * @param peso
     * @throws BusinessException
     */
    public void save(Peso peso) throws BusinessException {
        pesoDAO = new PesoUsuarioDAO();
        peso = pesoDAO.save(peso);
        Peso p = new Peso(peso.getId(), peso.getData(), peso.getPeso(), peso.getUsuario());
        model.removePeso(peso);
        model.addPeso(p);
    }

    /**
     *
     * @return
     */
    public PesoUsuarioModel getModel() {
        return model;
    }

    /**
     *
     * @param value
     * @param criteria
     */
    public void doFilter(String value, String criteria) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Predicate<Peso> predicate;

        switch (criteria) {
            case "Data":
                try {
                    Date data = sdf.parse(value);
                    predicate = (Peso peso) -> peso.getData().compareTo(data) == 0;
                    List<Peso> resultado = model.getPesos().stream().filter(predicate).collect(Collectors.toList());
                    model.setBackupPesos(model.getPesos());
                    model.setPesos(resultado);
                } catch (Exception ex) {

                }
                break;
            case "Peso":
                try {
                    DecimalFormat df = new DecimalFormat();
                    float valor = df.parse(value).floatValue();
                    predicate = (Peso peso) -> peso.getPeso() == valor;
                    List<Peso> resultado = model.getPesos().stream().filter(predicate).collect(Collectors.toList());
                    model.setBackupPesos(model.getPesos());
                    model.setPesos(resultado);
                } catch (Exception ex) {

                }
                break;
        }
    }
}
