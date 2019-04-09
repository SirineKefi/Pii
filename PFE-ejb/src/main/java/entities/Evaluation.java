package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Evaluation
 *
 */
@Entity
@Table(name = "EVALUATION")
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long evaluation_id;

    private double presence;

    private double presentation;

    private double report;

    public Evaluation() {
        super();
    }

    public long getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(long evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public double getPresence() {
        return presence;
    }

    public void setPresence(double presence) {
        this.presence = presence;
    }

    public double getPresentation() {
        return presentation;
    }

    public void setPresentation(double presentation) {
        this.presentation = presentation;
    }

    public double getReport() {
        return report;
    }

    public void setReport(double report) {
        this.report = report;
    }

	@Override
	public String toString() {
		return "Evaluation [evaluation_id=" + evaluation_id + ", presence=" + presence + ", presentation="
				+ presentation + ", report=" + report + "]";
	}

}
