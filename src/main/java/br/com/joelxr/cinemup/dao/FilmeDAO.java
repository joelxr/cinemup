package br.com.joelxr.cinemup.dao;

import br.com.joelxr.cinemup.entities.Filme;
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
public class FilmeDAO {

    public boolean salvar(Filme f) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(f);
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
    
       public boolean remover(Filme f) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(f);
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

    public Filme buscar(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();
        Filme result = null;

        try {
            em.getTransaction().begin();
            result = em.find(Filme.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return result;
        }
    }

    public List<Filme> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();

        List<Filme> filmes = new ArrayList<Filme>();

        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Filme a");
            filmes = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return filmes;
        }
    }
}
