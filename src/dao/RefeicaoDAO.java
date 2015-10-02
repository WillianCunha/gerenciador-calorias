/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Refeicao;
import exception.BusinessException;
import java.util.List;
import javax.persistence.EntityManager;
import util.JPAUtil;

/**
 *
 * @author visitante
 */
public class RefeicaoDAO implements IDAO<Refeicao> {

    private EntityManager em;
    
    public RefeicaoDAO() {
        em = JPAUtil.getEntityManager();
    }
    
    @Override
    public Refeicao save(Refeicao refeicao) {
        em.getTransaction().begin();
        Refeicao merged = em.merge(refeicao);
        em.getTransaction().commit();
        em.close();
        return merged;
    }

    @Override
    public void remove(Refeicao entity) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Refeicao findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Refeicao> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
