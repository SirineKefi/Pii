package entities;

import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConventionForm
 *
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "form_id")
public class ConventionForm extends Form {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    private Date startOn;

    @Temporal(TemporalType.DATE)
    private Date endOn;

    public ConventionForm() {
        super();
    }

    public Date getStartOn() {
        return startOn;
    }

    public void setStartOn(Date startOn) {
        this.startOn = startOn;
    }

    public Date getEndOn() {
        return endOn;
    }

    public void setEndOn(Date endOn) {
        this.endOn = endOn;
    }

}
