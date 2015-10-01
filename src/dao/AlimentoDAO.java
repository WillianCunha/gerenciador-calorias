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
    
    private EntityManager em;
    
    public AlimentoDAO() {
        em = JPAUtil.getEntityManager();
    }
    
    @Override
    public Alimento save(Alimento alimento) {
        em.getTransaction().begin();
        Alimento merged = em.merge(alimento);
        em.getTransaction().commit();
        em.close();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
