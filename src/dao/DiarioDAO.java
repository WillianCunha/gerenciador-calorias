/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Diario;
import entity.Usuario;
import exception.BusinessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

/**
 *
 * @author Aluca
 */
public class DiarioDAO implements IDAO<Diario> {

    private final EntityManager manager;
    
    public DiarioDAO() {
        manager = JPAUtil.getEntityManager();
    }
    
    @Override
    public Diario save(Diario entity) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Diario entity) throws BusinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Diario findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Diario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Diario> findByUsuario(Usuario usuario) {
        TypedQuery<Diario> query = manager.createQuery("from Diario d inner join fetch d.usuario where d.usuario = :usuario", Diario.class)
                .setParameter("usuario", usuario);
        List<Diario> result = query.getResultList();
        manager.close();
        return result;
    }
}
