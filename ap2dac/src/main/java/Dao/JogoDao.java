package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidade.Jogo;
import util.JPAUtil;

public class JogoDao {
	// Salvar
	public static void salvar(Jogo b) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}

	// Editar
	public static void editar(Jogo b) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(b);
		em.getTransaction().commit();
		em.close();
	}

	// Excluir
	public static void excluir(Jogo b) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		b = em.find(Jogo.class, b.getId());
		em.remove(b);
		em.getTransaction().commit();
		em.close();
	}

	// Listar
	public static List<Jogo> listar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select b from Jogo b");
		List<Jogo> list = q.getResultList();
		em.close();
		return list;
	}
}