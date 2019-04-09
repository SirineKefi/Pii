/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Admin;
import entities.MailServer;
import iservice.MailServerFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tryvl
 */
@Stateless
public class MailServerFacade extends AbstractFacade<MailServer> implements MailServerFacadeLocal {

    @PersistenceContext(unitName = "pfe-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MailServerFacade() {
        super(MailServer.class);
    }

    @Override
    public MailServer findByMailer(Admin admin) {
        MailServer mailer = new MailServer();
        
        try{
             mailer = (MailServer) em.createQuery("Select M From MailServer M Where M.mailer = :admin")
                .setParameter("admin", admin).getSingleResult();
             return mailer;
        }catch(NoResultException ex)
        {
            return new MailServer();
        }
       
        
        
    }
    
    
}
