package br.com.joelxr.cinemup.dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.joelxr.cinemup.entities.Genero;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class GeneroDAO {

    public boolean salvar(Genero g) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(g);
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

    public boolean remover(Genero g) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(g);
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

    public Genero buscar(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();
        Genero result = null;

        try {
            em.getTransaction().begin();
            result = em.find(Genero.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return result;
        }
    }

    public List<Genero> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemup");
        EntityManager em = emf.createEntityManager();

        List<Genero> generos = new ArrayList<Genero>();

        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Genero a");
            generos = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return generos;
        }
    }
}
