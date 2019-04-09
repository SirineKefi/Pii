/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entities.Admin;
import entities.Employee;
import entities.Student;
import javax.ejb.Remote;

/**
 *
 * @author Tryvl
 */
@Remote
public interface AutheticatorInterfaceRemote {
    
    public Employee getAutheticatedEmployee(String username, String password);
    public Admin getAutheticatedAdmin(String username, String password);
    public Student getAutheticatedStudent(String username, String password);
    
}
