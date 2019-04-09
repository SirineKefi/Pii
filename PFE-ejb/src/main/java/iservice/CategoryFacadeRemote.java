/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.Category;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Xandrayice
 */
@Remote
public interface CategoryFacadeRemote {

    void create(Category category);

    void edit(Category category);

    void remove(Category category);

    Category find(Object id);

    List<Category> findAll();

    List<Category> findRange(int[] range);

    int count();
    
    
    //SIRINE+OUSSAMA: DEPARTEMENT SUPERVISOR
    
    void accept_category_proposed(long category_id);
	void refuse_category_proposed(long id);
	public List<Category> listCategorie();
	public List<Category> findbyid(long id);
	public Category findByName(String nom);
	 Category findbyidOne(long id);
	//nejmi/PROFESSOR

	
	void ajouter_categorie(Category c);
	List<Category> categorie_accepter();
	List<Category> existe(String name_category);


	

}
