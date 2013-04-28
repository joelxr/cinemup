package br.com.joelxr.cinemup.dao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.joelxr.cinemup.entities.Ator;
import br.com.joelxr.cinemup.entities.Diretor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class DiretorDAO {

    public boolean salvar(Diretor d) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(d);
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

    public boolean remover(Ator d) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(d);
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

    public Diretor buscar(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();
        Diretor result = null;

        try {
            em.getTransaction().begin();
            result = em.find(Diretor.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return result;
        }
    }

    public List<Diretor> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemapp");
        EntityManager em = emf.createEntityManager();

        List<Diretor> diretores = new ArrayList<Diretor>();

        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Diretor a");
            diretores = query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            return diretores;
        }
    }
}
