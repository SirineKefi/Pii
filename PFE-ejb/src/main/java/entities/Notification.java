package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Notification
 *
 */
@Entity
@Table(name = "NOTIFICATION")
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notif_id;

    @ManyToOne
    @JoinColumn(name = "idEmployee", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "idStudent", referencedColumnName = "student_id")
    private Student student;

    public Notification() {
        super();
    }

    public long getNotif_id() {
        return notif_id;
    }

    public void setNotif_id(long notif_id) {
        this.notif_id = notif_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

	@Override
	public String toString() {
		return "Notification [notif_id=" + notif_id + ", employee=" + employee + ", student=" + student + "]";
	}

}
