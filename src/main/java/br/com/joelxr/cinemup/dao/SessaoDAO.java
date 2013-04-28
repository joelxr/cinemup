package br.com.joelxr.cinemup.dao;

import br.com.joelxr.cinemup.entities.Sessao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author joel
 */
public class SessaoDAO {

    public boolean salvar(Sessao s) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
            emf.close();
            return true;
        }
    }

    public boolean remover(Sessao s) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
            emf.close();
            return true;
        }
    }

    public Sessao buscar(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();
        Sessao result = null;

        try {
            em.getTransaction().begin();
            result = em.find(Sessao.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return result;
        }
    }

    public List<Sessao> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();

        List<Sessao> sessoes = new ArrayList<Sessao>();

        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Sessao a");
            sessoes = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return sessoes;
        }
    }
}
