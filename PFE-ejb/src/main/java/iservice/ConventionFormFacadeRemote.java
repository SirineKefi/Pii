/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.ConventionForm;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Xandrayice
 */
@Remote
public interface ConventionFormFacadeRemote {

    void create(ConventionForm conventionForm);

    void edit(ConventionForm conventionForm);

    void remove(ConventionForm conventionForm);

    ConventionForm find(Object id);

    List<ConventionForm> findAll();

    List<ConventionForm> findRange(int[] range);

    int count();
    
}
