package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;

public class CategoriaDao {
	
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		/*Primeiro fazendo um merge para que o 
		 * objeto categoria volte a ser managed*/
		categoria = em.merge(categoria);
		
		/*Para remover, o objeto só pode estar no
		 * estado managed, caso contrário é exception*/
		this.em.remove(categoria);
	}
}
