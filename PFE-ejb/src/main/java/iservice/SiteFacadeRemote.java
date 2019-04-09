/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.School;
import entities.Site;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Xandrayice
 */
@Remote
public interface SiteFacadeRemote {

    void create(Site site);

    void edit(Site site);

    void remove(Site site);

    Site find(Object id);

    List<Site> findAll();

    List<Site> findRange(int[] range);

    int count();
    
    public boolean UniqueSite(Site site);
    
    public List<Site> findBySchool(School school);
    
    public Site findByName(String name);
    
}
