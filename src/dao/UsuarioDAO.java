/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import util.JPAUtil;

/**
 *
 * @author visitante
 */
public class UsuarioDAO implements IDAO<Usuario> {

    private final EntityManager em;

    public UsuarioDAO() {
        em = JPAUtil.getEntityManager();
    }

    @Override
    public Usuario save(Usuario usuario) {
        em.getTransaction().begin();
        Usuario merged = em.merge(usuario);
        em.getTransaction().commit();
        em.close();
        return merged;
    }

    @Override
    public void remove(Usuario usuario) {
        em.getTransaction().begin();
        Usuario u = em.merge(usuario);
        em.remove(u);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Usuario findById(Long codigo) {
        return em.find(Usuario.class, codigo);
    }

    public Usuario findByLoginSenha(String login, String senha) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = builder.createQuery(Usuario.class);

        Root<Usuario> usuario = criteriaQuery.from(Usuario.class);
        criteriaQuery.select(usuario);

        List<Predicate> predicates = new ArrayList<>();

        ParameterExpression<String> paramLogin = builder.parameter(String.class, "login");
        ParameterExpression<String> paramSenha = builder.parameter(String.class, "senha");

        predicates.add(builder.equal(usuario.get("login"), paramLogin));
        predicates.add(builder.equal(usuario.get("senha"), paramSenha));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Usuario> query = em.createQuery(criteriaQuery);
        query.setParameter("login", login);
        query.setParameter("senha", senha);

        Usuario result = null;

        try {
            result = query.getSingleResult();
        } catch (Exception e) {

        }

        return result;
    }

    @Override
    public List<Usuario> findAll() {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll", Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        em.close();
        return usuarios;
    }
}
