/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.Form;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Xandrayice
 */
@Remote
public interface FormFacadeRemote {

    void create(Form form);

    void edit(Form form);

    void remove(Form form);

    Form find(Object id);

    List<Form> findAll();

    List<Form> findRange(int[] range);

    int count();
    
    //nejmi professor
    List<Form> findForms();

}
