/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Admin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.AdminFacadeRemote;
import javax.persistence.NoResultException;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> implements AdminFacadeRemote {

    @PersistenceContext(unitName = "pfe-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }

    @Override
    public boolean uniqueEmail(String email) {

        Admin admin = new Admin();

        try {
            admin = (Admin) em.createQuery("SELECT E FROM Admin E Where E.email = :email")
                    .setParameter("email", email.toLowerCase()).getSingleResult();
            return false;
        } catch (NoResultException ex) {
            return true;
        }
    }

    @Override
    public boolean uniqueUsername(String username) {
        Admin admin = new Admin();

        try {
            admin = (Admin) em.createQuery("SELECT E FROM Admin E Where E.login = :username")
                    .setParameter("username", username.toLowerCase()).getSingleResult();
            return false;
        } catch (NoResultException ex) {
            return true;
        }
    }

}
