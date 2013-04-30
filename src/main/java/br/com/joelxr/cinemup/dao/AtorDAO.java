package br.com.joelxr.cinemup.dao;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.joelxr.cinemup.entities.Ator;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Joel Rocha
 */ 
@ApplicationScoped
@Component
public class AtorDAO {

    public boolean salvar(Ator a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(a);
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

    public boolean remover(Ator a) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(a);
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

    public Ator buscar(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();
        Ator result = null;

        try {
            em.getTransaction().begin();
            result = em.find(Ator.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return result;
        }
    }

    public List<Ator> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();

        List<Ator> atores = new ArrayList<Ator>();

        // teste

        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Ator a");
            atores = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return atores;
        }
    }
}
