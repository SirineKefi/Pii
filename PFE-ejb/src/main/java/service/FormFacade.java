/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Form;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.FormFacadeRemote;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class FormFacade extends AbstractFacade<Form> implements FormFacadeRemote {

    @PersistenceContext(unitName = "pfe-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormFacade() {
        super(Form.class);
    }
	public List<Form> findForms() {
	return em.createQuery("select f from Form f",Form.class).getResultList();
	}

}
