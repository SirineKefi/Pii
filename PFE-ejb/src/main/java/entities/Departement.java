package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Departement
 *
 */
@Entity
@Table(name = "DEPARTEMENT")
public class Departement implements Serializable {

    private static final long serialVersionUID = 124L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departement_id;

    private String department_name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "site_id")
    private Site site;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.REMOVE)
    private List<Employee> employees;
    
    
    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee chef;

    public Departement() {
        super();
    }

    public Long getDepartement_id() {
        return departement_id;
    }

    public void setDepartement_id(Long departement_id) {
        this.departement_id = departement_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getChef() {
        return chef;
    }

    public void setChef(Employee chef) {
        this.chef = chef;
    }

    @Override
    public String toString() {
        return "Departement{" + "departement_id=" + departement_id + ", department_name=" + department_name + ", site=" + site + ", employees=" + employees + ", chef=" + chef + '}';
    }

}
