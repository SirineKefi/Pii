package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long student_id;

    private String ident;
    
    private int credit;

    private String firstName;

    private String lastName;

    private String personalEmail;

    private String professionalEmail;

    private String password;

    @OneToMany(mappedBy = "student")
    private List<Notification> notifications;

    @ManyToOne
    @JoinColumn(name = "class_id")
    Classe classe;

    @OneToOne(mappedBy = "student", cascade = CascadeType.REMOVE)
    Form form;

    public Student() {
        super();
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }  

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getProfessionalEmail() {
        return professionalEmail;
    }

    public void setProfessionalEmail(String professionalEmail) {
        this.professionalEmail = professionalEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }
    
    

    @Override
    public String toString() {
        return "Student{" + "student_id=" + student_id + ", credit=" + credit + ", firstName=" + firstName + ", lastName=" + lastName + ", personalEmail=" + personalEmail + ", professionalEmail=" + professionalEmail + ", password=" + password + ", notifications=" + notifications + ", classe=" + classe + ", form=" + form + '}';
    }

}
