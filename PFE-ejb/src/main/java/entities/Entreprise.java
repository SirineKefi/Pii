package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Entreprise
 *
 */
@Entity

public class Entreprise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ent_id;

    private String name;

    private String adress;

    private String country;

    private String supEmail;

    private String website;

    private long phone;

    @OneToMany(mappedBy = "entreprise")
    private List<Form> forms;

    public Entreprise() {
        super();
    }

    public long getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(long ent_id) {
        this.ent_id = ent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSupEmail() {
        return supEmail;
    }

    public void setSupEmail(String supEmail) {
        this.supEmail = supEmail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

	@Override
	public String toString() {
		return "Entreprise [ent_id=" + ent_id + ", name=" + name + ", adress=" + adress + ", country=" + country
				+ ", supEmail=" + supEmail + ", website=" + website + ", phone=" + phone + ", forms=" + forms + "]";
	}

}
