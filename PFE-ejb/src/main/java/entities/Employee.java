package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;

    private String email;

    private String firstName;

    private String lastName;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    Role role;

    public enum Role {
        professor, departement_supervisor, director
    };

    @ManyToOne
    @JoinColumn(name = "Id_employe_departement")
    private Departement departement;


    @ManyToOne
    @JoinColumn(name = "Id_Category")
    private Category category;


    @ManyToMany
    @JoinTable(name="Employee_t_form",joinColumns={@JoinColumn(name="employee_id")},inverseJoinColumns={@JoinColumn(name="form_id")})

    private List<Form> forms;

    @OneToMany(mappedBy = "employee")
    private List<Notification> notifications;

   
    

    public Employee() {
        super();
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", login=" + login + ", password=" + password + ", role=" + role + ", departement="
				+ departement + ", category=" + category
				+ "]";
	}

}
