package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@Table(name="ADMIN")
public class Admin implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long admin_id;
	
	private String email;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	
	@OneToOne
	@JoinColumn(name="FK_SCHOOL_ID")
	private School school;
	
	public Admin() {
		super();
	}

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
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

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

    @Override
    public String toString() {
        return "Admin{" + "admin_id=" + admin_id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", login=" + login + ", password=" + password + ", school=" + school + '}';
    }
   
	
}
