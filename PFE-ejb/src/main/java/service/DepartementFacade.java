/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Departement;
import entities.Employee;
import entities.School;
import entities.Site;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.DepartementFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class DepartementFacade extends AbstractFacade<Departement> implements DepartementFacadeRemote {

    @PersistenceContext(unitName = "pfe-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartementFacade() {
        super(Departement.class);
    }

    @Override
    public List<Departement> findBySite(Site site) {
        try {
            TypedQuery<Departement> query =  (TypedQuery<Departement>) em.createQuery("SELECT E FROM Departement E Where E.site = :site", Departement.class)
                    .setParameter("site", site);
            List<Departement> options = query.getResultList();
            return options;
            
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }
    
    @Override
    public List<Departement> findBySiteName(String site, School school)
    {
        try {
            TypedQuery<Departement> query =  (TypedQuery<Departement>) 
                    em.createQuery("SELECT E FROM Departement E Where E.site.name = :name And E.site.school = :school", Departement.class)
                    .setParameter("name", site)
                    .setParameter("school", school);
            List<Departement> options = query.getResultList();
            return options;
            
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }
    
    @Override
    public Boolean uniqueDepartement(String name)
    {
        Departement depaExist = new Departement();

        try {
            depaExist = (Departement) em.createQuery("SELECT E FROM Departement E Where E.department_name = :name", Departement.class)
                    .setParameter("name", name.toLowerCase())
                    .getSingleResult();
            return false;
        } catch (NoResultException ex) {
            return true;
        }
    }
    
    @Override
    public Departement findByName(String name)
    {
        Departement depaExist = new Departement();

        try {
            depaExist = (Departement) em.createQuery("SELECT E FROM Departement E Where E.department_name = :name", Departement.class)
                    .setParameter("name", name.toLowerCase())
                    .getSingleResult();
            return depaExist;
        } catch (NoResultException ex) {
            return new Departement();
        }
    }

    @Override
    public List<Departement> findByChefNull(Site site) {
        try {
            TypedQuery<Departement> query =  (TypedQuery<Departement>) 
                    em.createQuery("SELECT E FROM Departement E Where E.chef IS NULL AND E.site = :site", Departement.class)
                    .setParameter("site", site);
            
            List<Departement> options = query.getResultList();
            return options;
            
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }
    
}
