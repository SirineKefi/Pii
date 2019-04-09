/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Facade.AbstractFacade;
import entities.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import iservice.StudentFacadeRemote;
import javax.persistence.NoResultException;

/**
 *
 * @author Xandrayice
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeRemote {

    @PersistenceContext(unitName = "pfe-ejb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public boolean uniqueStundet(Student student) {
        Student studentExist = new Student();

        try {
            studentExist = (Student) em.createQuery("SELECT S FROM Student S Where S.professionalEmail = :email AND S.ident = :id")
                    .setParameter("email", student.getProfessionalEmail().toLowerCase())
                    .setParameter("id", student.getIdent().toLowerCase())
                    .getSingleResult();
            return false;
        } catch (NoResultException ex) {
            return true;
        }
    }
    
}
