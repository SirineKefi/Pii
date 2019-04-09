/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Employee;
import entities.PFE_Form;
import entities.Category;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.PFE_FormFacadeRemote;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class PFE_FormFacade extends AbstractFacade<PFE_Form> implements PFE_FormFacadeRemote {

    @PersistenceContext(unitName = "pfe-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PFE_FormFacade() {
        super(PFE_Form.class);
    }
    
    
	//SIRINE+OUSSAMA : DEPARTEMENT SUPERVISOR
    @Override
	public List<PFE_Form> Form_without_reporter() {
		List<PFE_Form> list_form=em.createQuery("select f from PFE_Form f where f.reporter=null ",PFE_Form.class).getResultList();
		return list_form;
	}
	@Override
	public List<PFE_Form> Form_pfe_accepted() {
		List<PFE_Form> list_accept=em.createQuery("select f from PFE_Form f where f.accepted="+true,PFE_Form.class).getResultList();
		return list_accept;
	}
	@Override
	public List<PFE_Form> Form_without_supervisor() {
		List<PFE_Form> list_form=em.createQuery("select f from PFE_Form f where f.supervisor=null",PFE_Form.class).getResultList();
		return list_form;
	}
	@Override
	public void Assign_supervisor(Employee e,PFE_Form f) {
		//affecter Ã  un etudiant
		if( f.getStudent()!=null){
			// not written notes yet or not been assigned yet
			if((f.getSupervisor()==null)||(f.getNote_supervisor()==0)){
				if(e.getRole().equals("professor")&&(e.getCategory()==f.getCategory())){
					f.setSupervisor(e);
				}
			}
		}
	}
	@Override
	public void SetCategory_PfeForm( Long cat_id, Long pfe_form_id ) {
		Category c =em.find(Category.class, cat_id);
		PFE_Form f=em.find(PFE_Form.class, pfe_form_id);
		if(f.getCategory()==null)
		{f.setCategory(c);}
		else{
			System.out.println("it has a category!");
		}

	}
	@Override
	public List<PFE_Form> Form_pfe_without_note() {
		List<PFE_Form> list_form=em.createQuery("select f from PFE_Form f where f.note_supervisor=null or f.note_reporter=null",PFE_Form.class).getResultList();
		return list_form;
	}
	
	@Override
	public List<PFE_Form> FindAll_PfeForm() {
		return em.createQuery("select f from PFE_Form f ",PFE_Form.class).getResultList();
		
	}
	@Override
	public List<Employee> FindAmployee(long id_empl) {
		return em.createQuery("select e from Employee e where employee_id="+id_empl,Employee.class).getResultList();

	}
	@Override
	public List<Employee> Employe_de_category(PFE_Form f) {
		Category c=f.getCategory();
		long id_c=c.getCategory_id();
		return em.createQuery("select e from Employee e where e.category="+id_c,Employee.class).getResultList();
		
	}
	@Override
	public Employee returnEmpByName(String nom) {
		return em.createQuery("select e from Employee e where e.lastName like '%' || :nom || '%'",Employee.class).setParameter("nom", nom).getSingleResult();
	}
	public void Assign_emp_Form(long id_form,long id_emp){
		
		PFE_Form f=em.find(PFE_Form.class, id_form);
		Employee e=em.find(Employee.class,id_emp);
		f.setReporter(e);
	}
	@Override
	public void Assign_emp_sup_Form(long id_form, long id_emp) {

		PFE_Form f=em.find(PFE_Form.class, id_form);
		Employee e=em.find(Employee.class,id_emp);
		f.setSupervisor(e);
	}
	@Override
	public List<PFE_Form> Form_pfe_non_accepted() {
		List<PFE_Form> list_accept=em.createQuery("select f from PFE_Form f where f.accepted="+false,PFE_Form.class).getResultList();
		return list_accept;
	}
	@Override
	public long nb_Form_pfe_non_accepted() {
		return em.createQuery("select count(f) from PFE_Form f where f.accepted="+false,Long.class).getSingleResult();
	
	}
	@Override
	public long nb_Form_pfe_accepted() {
		return em.createQuery("select count(f) from PFE_Form f where f.accepted="+true,Long.class).getSingleResult();

	}
	@Override
	public List<PFE_Form> form_pfe_accepted() {
		System.out.println("***********************");
		List<PFE_Form> list_accept=em.createQuery("select f from PFE_Form f where f.accepted= :acc",PFE_Form.class)
				.setParameter("acc",true).getResultList();
		System.out.println("***********************");
		return list_accept;
	}
	@Override
	public List<PFE_Form> sans_superviseure() {
		List<PFE_Form> sans_superviseur=em.createQuery("select f from PFE_Form f where f.supervisor=null",PFE_Form.class).getResultList();
		return sans_superviseur;
	}
	@Override
	public List<PFE_Form> afficher_supervision(long id_emp) {
		List<PFE_Form> supervision=em.createQuery("select f from PFE_Form f where f.supervisor="+id_emp,PFE_Form.class).getResultList();
		return supervision;

	}
	@Override
	public List<PFE_Form> afficher_reporter(long id_emp) {
		List<PFE_Form> repporter=em.createQuery("select f from PFE_Form f where f.reporter="+id_emp,PFE_Form.class).getResultList();
		return repporter;
	}
	public void delete_pfe(PFE_Form f){
		em.remove(f);
	}


    

}
