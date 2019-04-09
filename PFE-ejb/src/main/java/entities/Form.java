package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Form
 *
 */
@Entity
@Table(name = "T_FORM")
@Inheritance(strategy = InheritanceType.JOINED)
public class Form implements Serializable {

    private static final long serialVersionUID = 1451L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long form_id;

    private String responsibleEmail;

    private String responsibleFirstName;

    private String responsibleLastName;

    @ManyToOne
    @JoinColumn(name = "Id_entreprise")
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "Id_Category")
    private Category category;

    @ManyToMany
    private List<Employee> employees;

    @OneToOne
    private Student student;

    public Form() {
        super();
    }

    public long getForm_id() {
        return form_id;
    }

    public void setForm_id(long form_id) {
        this.form_id = form_id;
    }

    public String getResponsibleEmail() {
        return responsibleEmail;
    }

    public void setResponsibleEmail(String responsibleEmail) {
        this.responsibleEmail = responsibleEmail;
    }

    public String getResponsibleFirstName() {
        return responsibleFirstName;
    }

    public void setResponsibleFirstName(String responsibleFirstName) {
        this.responsibleFirstName = responsibleFirstName;
    }

    public String getResponsibleLastName() {
        return responsibleLastName;
    }

    public void setResponsibleLastName(String responsibleLastName) {
        this.responsibleLastName = responsibleLastName;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

	@Override
	public String toString() {
		return "Form [form_id=" + form_id + ", responsibleEmail=" + responsibleEmail + ", responsibleFirstName="
				+ responsibleFirstName + ", responsibleLastName=" + responsibleLastName + ", entreprise=" + entreprise
				+ ", category=" + category + ", employees=" + employees + ", student=" + student + "]";
	}

}
