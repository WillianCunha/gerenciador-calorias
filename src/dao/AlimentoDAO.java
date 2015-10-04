/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Alimento;
import exception.BusinessException;
import java.util.List;
import javax.persistence.EntityManager;
import util.JPAUtil;

/**
 *
 * @author Aluca
 */
public class AlimentoDAO implements IDAO<Alimento> {
    
    private final EntityManager manager;
    
    /**
     *
     */
    public AlimentoDAO() {
        manager = JPAUtil.getEntityManager();
    }
    
    @Override
    public Alimento save(Alimento alimento) {
        manager.getTransaction().begin();
        Alimento merged = manager.merge(alimento);
        manager.getTransaction().commit();
        manager.close();
        return merged;
    }

    @Override
    public void remove(Alimento entity) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alimento findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alimento> findAll() {
        List<Alimento> alimentos = manager.createNamedQuery("Alimento.findAll", Alimento.class).getResultList();
        manager.close();
        return alimentos;
    }
}
