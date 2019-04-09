/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.Admin;
import entities.MailServer;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Tryvl
 */
@Remote
public interface MailServerFacadeLocal {

    void create(MailServer mailServer);

    void edit(MailServer mailServer);

    void remove(MailServer mailServer);

    MailServer find(Object id);

    List<MailServer> findAll();

    List<MailServer> findRange(int[] range);

    int count();
    
    MailServer findByMailer(Admin admin);
    
}
