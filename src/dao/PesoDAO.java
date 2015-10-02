/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Peso;
import entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

/**
 *
 * @author visitante
 */
public class PesoDAO implements IDAO<Peso> {

    private EntityManager em;

    public PesoDAO() {
        em = JPAUtil.getEntityManager();
    }

    @Override
    public Peso save(Peso peso) {
        em.getTransaction().begin();
        Peso merged = em.merge(peso);
        em.getTransaction().commit();
        em.close();
        return merged;
    }

    @Override
    public void remove(Peso peso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Peso findById(Long codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Peso findByData(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Peso> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Peso> findByUsuarioByPeso(Usuario usuario) {
        List<Peso> list = null;
        TypedQuery<Peso> query = em.createNamedQuery("Peso.findByUsuarioByPesoAtual", Peso.class);
        query.setParameter("usuario", usuario);        
        list = query.getResultList();
        em.close();
        return list;
    }
    
    // Comentei porque não será mais usado o pesoAtual, mas ainda precisa pesquisar
    // por usuário
//    public List<Peso> findByUsuarioByPesoAtual(Usuario usuario, boolean pesoAtual) {
//        List<Peso> list = null;
//        TypedQuery<Peso> query = em.createNamedQuery("Peso.findByUsuarioByPesoAtual", Peso.class);
//        query.setParameter("usuario", usuario);
//        query.setParameter("pesoAtual", pesoAtual);
//        list = query.getResultList();
//        em.close();
//        return list;
//    }
}
