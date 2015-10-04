/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Peso;
import entity.Usuario;
import exception.BusinessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import util.JPAUtil;

/**
 *
 * @author winston.sonnesen
 */
public class PesoUsuarioDAO implements IDAO<Peso> {

    private final EntityManager manager;

    /**
     * Construtor da classe
     */
    public PesoUsuarioDAO() {
        manager = JPAUtil.getEntityManager();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Peso> findAll() {
        List<Peso> pesos = manager.createNamedQuery("Peso.findAll", Peso.class).getResultList();
        manager.close();
        return pesos;
    }

    /**
     *
     * @param peso
     * @throws BusinessException
     */
    @Override
    public Peso save(Peso peso) throws BusinessException {
        try {
            manager.getTransaction().begin();
            if (!manager.contains(peso)) {
                peso = manager.merge(peso);
            }
            manager.persist(peso);
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar registro: " + peso, e);
        } finally {
            manager.close();
        }
        return peso;
    }

    @Override
    public void remove(Peso peso) throws BusinessException {
        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(peso));
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao remover registro: " + peso, e);
        } finally {
            manager.close();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Peso findById(Long id) {
        Peso peso = manager.find(Peso.class, id);
        manager.close();
        return peso;
    }

    /**
     * @param usuario
     * @return 
     */
    public List<Peso> findByUsuario(Usuario usuario) {
        TypedQuery<Peso> query = manager.createQuery("from Peso p inner join fetch p.usuario where p.usuario = :usuario", Peso.class)
                .setParameter("usuario", usuario);
        List<Peso> result = query.getResultList();
        manager.close();
        return result;
    }

}
