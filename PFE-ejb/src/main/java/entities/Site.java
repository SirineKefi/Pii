package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Site
 *
 */
@Entity
@Table(name = "SITE")
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long site_id;

    private String name;

    private String address;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "school_id")
    private School school;

    public Site() {
        super();
    }

    public Long getSite_id() {
        return site_id;
    }

    public void setSite_id(Long site_id) {
        this.site_id = site_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Site{" + "site_id=" + site_id + ", name=" + name + ", address=" + address + ", school=" + school + '}';
    }

}
