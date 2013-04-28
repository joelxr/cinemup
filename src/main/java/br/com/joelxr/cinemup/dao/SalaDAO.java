package br.com.joelxr.cinemup.dao;

import br.com.joelxr.cinemup.entities.Sala;
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
public class SalaDAO {

    public boolean salvar(Sala s) {
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

    public boolean remover(Sala s) {
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

    public Sala buscar(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();
        Sala result = null;

        try {
            em.getTransaction().begin();
            result = em.find(Sala.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return result;
        }
    }

    public List<Sala> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();

        List<Sala> salas = new ArrayList<Sala>();

        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Sala a");
            salas = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return salas;
        }
    }
}
