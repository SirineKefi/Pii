/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.Departement;
import entities.Opt;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Xandrayice
 */
@Remote
public interface OptFacadeRemote {

    void create(Opt opt);

    void edit(Opt opt);

    void remove(Opt opt);

    Opt find(Object id);

    List<Opt> findAll();

    List<Opt> findRange(int[] range);

    int count();
    public List<Opt> findByDepartement(Departement departement);
    public boolean UniqueSite(Opt option);
    public List<Opt> findByName(String name);
    
}
