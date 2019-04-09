package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Classe
 *
 */
@Entity
@Table(name = "CLASS")
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long class_id;

    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "opt_id")
    private Opt option;

    public Classe() {
        super();
    }

    public long getClass_id() {
        return class_id;
    }

    public void setClass_id(long class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Opt getOption() {
        return option;
    }

    public void setOption(Opt option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return  name;
    }

}
