/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Departement;
import entities.Opt;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.OptFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class OptFacade extends AbstractFacade<Opt> implements OptFacadeRemote {

    @PersistenceContext(unitName = "pfe-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OptFacade() {
        super(Opt.class);
    }

    @Override
    public List<Opt> findByDepartement(Departement departement) {
        try {
            TypedQuery<Opt> query = (TypedQuery<Opt>) em.createQuery("SELECT E FROM Opt E Where E.departement = :departement", Opt.class)
                    .setParameter("departement", departement);
            List<Opt> options = query.getResultList();
            return options;

        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean UniqueSite(Opt option) {
        Opt OptExist = new Opt();

        try {
            OptExist = (Opt) em.createQuery("SELECT E FROM Opt E Where E.name = :name")
                    .setParameter("name", option.getName().toLowerCase())
                    .getSingleResult();
            return false;
        } catch (NoResultException ex) {
            return true;
        }
    }

    @Override
    public List<Opt> findByName(String name) {
        try {
            TypedQuery<Opt> query = (TypedQuery<Opt>) em.createQuery("SELECT E FROM Opt E Where E.name = :name", Opt.class)
                    .setParameter("name", name);
            List<Opt> options = query.getResultList();
            return options;

        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }
    
    

}
