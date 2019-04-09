/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.PFE.Main;

import entities.Admin;
import iservice.AutheticatorInterfaceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Tryvl
 */
public class Client {
    public static void main(String[] args) throws NamingException 
    {
        String jndiName = "PFE-ear/PFE-ejb/AutheticatorService!iservice.AutheticatorInterfaceRemote";
        Context context = new InitialContext();
        AutheticatorInterfaceRemote proxy = (AutheticatorInterfaceRemote) context.lookup(jndiName);
        
        Admin admin = new Admin();
        /*admin.setEmail("yassine.sta@esprit.tn");
        admin.setFirstName("Yassine");
        admin.setLastName("STA");
        admin.setLogin("Tryvl");
        admin.setPassword("azerty");
        
        proxy.create(admin);
        */
      //  Admin find = proxy.getAutheticatedAdmin("cc", "c");
       // System.out.println("Admin autheticated  : " + find);
    }
}
