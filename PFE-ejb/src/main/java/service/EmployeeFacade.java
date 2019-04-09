/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Category;
import entities.Departement;
import entities.Employee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.EmployeeFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeRemote {

	@PersistenceContext(unitName = "pfe-ejb")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public EmployeeFacade() {
		super(Employee.class);
	}

	@Override
	public Boolean uniqueEmployee(Employee employee) {
		Employee employeeExist = new Employee();

		try {
			employeeExist = (Employee) em.createQuery("SELECT E FROM Employee E Where E.email = :email or E.login = :login", Employee.class)
					.setParameter("email", employee.getEmail().toLowerCase())
					.setParameter("login", employee.getLogin().toLowerCase())
					.getSingleResult();
			return false;
		} catch (NoResultException ex) {
			return true;
		}
	}

	@Override
	public List<Employee> findByDepartement(Departement dep) {
		try {
			TypedQuery<Employee> query =  (TypedQuery<Employee>) 
					em.createQuery("SELECT E FROM Employee E Where E.departement = :dep", Employee.class)
					.setParameter("dep", dep);
			List<Employee> employees = query.getResultList();
			return employees;

		} catch (NoResultException ex) {
			return new ArrayList<>();
		}
	}

	@Override
	public List<Employee> findByRole(Employee.Role role) {
		try {
			TypedQuery<Employee> query =  (TypedQuery<Employee>) 
					em.createQuery("SELECT E FROM Employee E Where E.role = :role", Employee.class)
					.setParameter("role", role);
			List<Employee> employees = query.getResultList();
			return employees;

		} catch (NoResultException ex) {
			return new ArrayList<>();
		}
	}
	
	//SIRINE+OUSSAMA : DEPARTEMENT SUPERVISOR
	public List<Long> list_form_manquante(){
		List<Long> list_form=em.createQuery("select f.form_id from PFE_Form f where f.president_id=1",Long.class).getResultList();
		return list_form;
	}

	public List<Employee> orderby_supervisions() {
		List<Employee>list=em.createQuery("select f.supervisor from PFE_Form f group by f.supervisor order by count(f.form_id)",Employee.class).getResultList();

		return list;
	}

	@Override
	public long nbre_supervisions(long id_emp) {
		System.out.println("hayaaaaa amannn");
		long nbre=em.createQuery("select count(f) from PFE_Form f where f.supervisor="+id_emp,Long.class).getSingleResult();
		return nbre;
	}

	@Override
	public List<Employee> orderby_supervisons() {
		List<Employee>emp=em.createQuery("select f from Employee f where f.employee_id=(select supervisor from PFE_Form group by supervisor order by count(form_id))",Employee.class).getResultList();
		return emp;
	}
	@Override
	public void choisir_categorie(long id_c, long id_emp) {
		Category c=em.find(Category.class, id_c);
		Employee emp=em.find(Employee.class, id_emp);
		emp.setCategory(c);
		
	}


}
