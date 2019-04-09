/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Admin;
import entities.School;
import entities.Site;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.SiteFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class SiteFacade extends AbstractFacade<Site> implements SiteFacadeRemote {

    @PersistenceContext(unitName = "pfe-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SiteFacade() {
        super(Site.class);
    }

    @Override
    public boolean UniqueSite(Site site) {
        Site siteExist = new Site();

        try {
            siteExist = (Site) em.createQuery("SELECT E FROM Site E Where E.name = :name and E.address = :adress")
                    .setParameter("name", site.getName().toLowerCase())
                    .setParameter("adress", site.getAddress().toLowerCase())
                    .getSingleResult();
            return false;
        } catch (NoResultException ex) {
            return true;
        }
    }

    @Override
    public List<Site> findBySchool(School school) {
        
        try {
            TypedQuery<Site> query =  (TypedQuery<Site>) em.createQuery("SELECT E FROM Site E Where E.school = :school", Site.class)
                    .setParameter("school", school);
            List<Site> sites = query.getResultList();
            return sites;
            
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
        
    }
    
    public Site findByName(String name)
    {
         Site siteExist = new Site();

        try {
            siteExist = (Site) em.createQuery("SELECT E FROM Site E Where E.name = :name")
                    .setParameter("name",name.toLowerCase())
                    .getSingleResult();
            return siteExist;
        } catch (NoResultException ex) {
            return new Site();
        }
    }
    
}
