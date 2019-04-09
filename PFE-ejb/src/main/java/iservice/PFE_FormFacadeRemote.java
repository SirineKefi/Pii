/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.Employee;
import entities.PFE_Form;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Xandrayice
 */
@Remote
public interface PFE_FormFacadeRemote {

	void create(PFE_Form pFE_Form);

	void edit(PFE_Form pFE_Form);

	void remove(PFE_Form pFE_Form);

	PFE_Form find(Object id);

	List<PFE_Form> findAll();

	List<PFE_Form> findRange(int[] range);

	int count();

	//SIRINE+OUSSAMA: DEPARTEMENT SUPERVISOR


	List<PFE_Form> Form_without_reporter();
	List<PFE_Form> Form_without_supervisor();
	List<PFE_Form> Form_pfe_accepted();
	List<PFE_Form> Form_pfe_without_note();
	void Assign_supervisor(Employee e,PFE_Form f);
	void SetCategory_PfeForm(Long cat_id, Long pfe_form_id );
	List<PFE_Form> FindAll_PfeForm();
	List<Employee> FindAmployee(long id_empl);
	List<Employee> Employe_de_category(PFE_Form f);
	Employee returnEmpByName(String nom);
	void Assign_emp_Form(long id_form,long id_emp);
	void Assign_emp_sup_Form(long id_form,long id_emp);
	List<PFE_Form> Form_pfe_non_accepted() ;
	long  nb_Form_pfe_non_accepted() ;
	long nb_Form_pfe_accepted();

	void delete_pfe(PFE_Form f);
	//Nejmi professor
	
	
	
	
	List<PFE_Form> form_pfe_accepted();
	List<PFE_Form> sans_superviseure();
	List<PFE_Form> afficher_supervision(long id_emp);
	List<PFE_Form> afficher_reporter(long id_emp);


}
