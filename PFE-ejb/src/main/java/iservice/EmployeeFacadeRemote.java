/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.Departement;
import entities.Employee;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Xandrayice
 */
@Remote
public interface EmployeeFacadeRemote {

    void create(Employee employee);

    void edit(Employee employee);

    void remove(Employee employee);

    Employee find(Object id);

    List<Employee> findAll();

    List<Employee> findRange(int[] range);

    int count();
    
    public Boolean uniqueEmployee(Employee employee);
    
    public List<Employee> findByDepartement(Departement dep);

    public List<Employee> findByRole(Employee.Role role);
    
    //SIRINE+OUSSAMA: DEPARTEMENT SUPERVISOR
    
    List<Long> list_form_manquante();
	List<Employee> orderby_supervisions();
	long nbre_supervisions(long id_emp);
	
	//NEJMI PROFESSOR
	List<Employee> orderby_supervisons();
	void choisir_categorie(long id_c,long id_emp);

}
