/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.PFE.Utils;

import entities.Admin;
import entities.Employee;
import iservice.AutheticatorInterfaceRemote;

import javax.naming.NamingException;
import tn.esprit.PFE.Utils.Cache.ContextCache;

/**
 *
 * @author Tryvl
 */
public class Authenticator {

    public static Admin admin;
    public static Employee employee;

    
    public void loginAdmin(String username, String password) throws NamingException
    {
        admin =  getRemote().getAutheticatedAdmin(username, password);
    }
    
    public static AutheticatorInterfaceRemote getRemote() {
        return (AutheticatorInterfaceRemote) ContextCache
                .getInstance()
                .getProxy("PFE-ejb/AutheticatorService!interfaces.AutheticatorInterfaceRemote");
    }
    
    

}
