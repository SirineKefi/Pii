/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.Classe;
import entities.Opt;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Xandrayice
 */
@Remote
public interface ClassFacadeRemote {

    void create(Classe classe);

    void edit(Classe classe) ;

    void remove(Classe classe);

    Classe find(Object id);

    List<Classe> findAll();

    List<Classe> findRange(int[] range);

    int count();
    
    public boolean uniqueClass(Classe cl);
    
    public List<Classe> findClassByName(String name);
    
    public List<Classe> findClassByOption(Opt option);
    
}
