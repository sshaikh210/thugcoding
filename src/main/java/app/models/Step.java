package app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

/**
 * @author abdul.jabbar@octryx.com 2/9/2016.
 */
@Entity
@Table(name = "Steps")
public class Step extends Model {
    @Column(name = "step_no",nullable = false)
    private int step_no;

    public int getStep_no() {
        return step_no;
    }

    public void setStep_no(int step_no) {
        this.step_no = step_no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "description", nullable = true)
    private String description;


    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "Tutorials", referencedColumnName = "id")
    @RestResource(exported = false)
    @JsonBackReference
    private Tutorial tutorial;
}
