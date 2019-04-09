/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.ConventionForm;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.ConventionFormFacadeRemote;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class ConventionFormFacade extends AbstractFacade<ConventionForm> implements ConventionFormFacadeRemote {

    @PersistenceContext(unitName = "pfe-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConventionFormFacade() {
        super(ConventionForm.class);
    }
    
}
