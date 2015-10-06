/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Alimento;
import entity.CaracteristicaAlimento;
import exception.BusinessException;
import java.util.List;
import javax.persistence.EntityManager;
import util.JPAUtil;

/**
 *
 * @author visitante
 */
public class CaracteristicaAlimentoDAO implements IDAO<CaracteristicaAlimento> {

    private final EntityManager manager;
    
    public CaracteristicaAlimentoDAO() {
        manager = JPAUtil.getEntityManager();
    }
    
    @Override
    public CaracteristicaAlimento save(CaracteristicaAlimento caracteristicaAlimento) throws BusinessException {
        manager.getTransaction().begin();
        CaracteristicaAlimento merged = manager.merge(caracteristicaAlimento);
        manager.getTransaction().commit();
        manager.close();
        return merged;
    }

    @Override
    public void remove(CaracteristicaAlimento entity) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CaracteristicaAlimento findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CaracteristicaAlimento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
