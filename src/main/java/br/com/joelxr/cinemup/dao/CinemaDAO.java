
package br.com.joelxr.cinemup.dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.joelxr.cinemup.entities.Cinema;
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
@Component
public class CinemaDAO {

    public boolean salvar(Cinema c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(c);
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

    public boolean remover(Cinema c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(c);
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

    public Cinema buscar(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();
        Cinema result = null;

        try {
            em.getTransaction().begin();
            result = em.find(Cinema.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return result;
        }
    }

    public List<Cinema> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();

        List<Cinema> cinemas = new ArrayList<Cinema>();

        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Cinema a");
            cinemas = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return cinemas;
        }
    }
}
