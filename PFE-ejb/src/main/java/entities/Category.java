package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

    @Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_name=" + category_name 
				 + ", category_available=" + category_available + "]";
	}

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long category_id;

    private String category_name;

    @OneToMany(mappedBy = "category",cascade=CascadeType.REMOVE)
    private List<Employee> employees;

    @OneToMany(mappedBy = "category",cascade=CascadeType.REMOVE)
    private List<Form> forms;

    private boolean category_available;
    
    public Category() {
        super();
    }
    

    public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public Category(String category_name) {
        this.category_name = category_name;
    }

	public boolean isCategory_available() {
		return category_available;
	}

	public void setCategory_available(boolean category_available) {
		this.category_available = category_available;
	}

	

}
