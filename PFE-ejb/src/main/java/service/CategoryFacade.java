/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.CategoryFacadeRemote;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeRemote {

	@PersistenceContext(unitName = "pfe-ejb")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CategoryFacade() {
		super(Category.class);
	}
	
	//SIRINE+OUSSAMA :DEPARTEMENT SUPERVISOR
	@Override
	public void accept_category_proposed(long category_id) {
		Category c=em.find(Category.class, category_id);
		c.setCategory_available(true);

	}

	@Override
	public void refuse_category_proposed(long id) {
		Category c=em.find(Category.class, id);
		em.remove(c);

	}

	@Override
	public List<Category> listCategorie() {
		return em.createQuery("select c from Category c where c.category_available="+false,Category.class).getResultList();

	}

	@Override
	public List<Category> findbyid(long id) {
		return em.createQuery("select f from Category f where f.category_id ="+id,Category.class).getResultList();

	}
	@Override
	public Category findbyidOne(long id) {
return em.find(Category.class, id);
	}

	@Override
	public Category findByName(String nom) {
		Category c=em.createQuery("select c from Category c where c.category_name like '%' || :category_name || '%'",Category.class).setParameter("category_name", nom).getSingleResult();
		return c;
	}

	@Override
	public void ajouter_categorie(Category c) {
  		em.persist(c);
  		
	}

	@Override
	public List<Category> categorie_accepter() {
		List<Category>emp=em.createQuery("select f from Category f where f.category_available="+true,Category.class).getResultList();
		return emp;
	}

	@Override
	public List<Category> existe(String name_category) {
		List<Category> list=em.createQuery("select f from Category f where f.category_name like '%' || :category_name || '%'",Category.class).setParameter("category_name", name_category).getResultList();
		return list;
	}






}
