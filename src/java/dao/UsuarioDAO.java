/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Carlos
 */
public class UsuarioDAO {

    private static EntityManagerFactory getEntity() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionClinicaPU");
        return emf;
    }

    public static List<Usuario> listar() {
        EntityManager em = getEntity().createEntityManager();
        Query q = em.createNamedQuery("Usuario.findAll");
        List<Usuario> lista = q.getResultList();
        return lista;
    }

    public static void agregar(Usuario usu) {
        EntityManager em = getEntity().createEntityManager();
        em.getTransaction().begin();
        em.persist(usu);
        em.getTransaction().commit();
    }

    public static Usuario validar(Usuario usu) {
        try {
            EntityManager em = getEntity().createEntityManager();
            Query q = em.createNamedQuery("Usuario.validar");
            q.setParameter("logiUsua", usu.getLogiUsua());
            q.setParameter("passUsua", usu.getPassUsua());
            return (Usuario) q.getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
