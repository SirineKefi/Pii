package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Opt
 *
 */
@Entity

public class Opt implements Serializable {

	private static final long serialVersionUID = 1231L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long opt_id;

    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "departement_id")
    private Departement departement;

    public Opt() {
        super();
    }

    public Long getOpt_id() {
        return opt_id;
    }

    public void setOpt_id(Long opt_id) {
        this.opt_id = opt_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
	public String toString() {
		return "Opt [opt_id=" + opt_id + ", name=" + name + ", departement=" + departement + "]";
	}

}
