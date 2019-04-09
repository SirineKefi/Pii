/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Classe;
import entities.Opt;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.ClassFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class ClassFacade extends AbstractFacade<Classe> implements ClassFacadeRemote {

    @PersistenceContext(unitName = "pfe-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClassFacade() {
        super(Classe.class);
    }

    @Override
    public boolean uniqueClass(Classe cl) {

        try {
            Classe classExist = (Classe) em.createQuery("SELECT E FROM Classe E Where E.name = :name and E.option = :opt", Classe.class)
                    .setParameter("name", cl.getName())
                    .setParameter("opt", cl.getOption())
                    .getSingleResult();
            return false;
        } catch (NoResultException ex) {
            return true;
        }
    }

    @Override
    public List<Classe> findClassByName(String name) {
        try {
            TypedQuery<Classe> query = (TypedQuery<Classe>) em.createQuery("SELECT E FROM Classe E Where E.name = :name", Classe.class)
                    .setParameter("name", name);
            List<Classe> classes = query.getResultList();
            return classes;

        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Classe> findClassByOption(Opt option) {
        try {
            TypedQuery<Classe> query = (TypedQuery<Classe>) em.createQuery("SELECT E FROM Classe E Where E.option = :option", Classe.class)
                    .setParameter("option", option);
            List<Classe> classes = query.getResultList();
            return classes;

        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }

}
