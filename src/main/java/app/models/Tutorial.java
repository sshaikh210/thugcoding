package app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdul.jabbar@octryx.com 2/9/2016.
 */
@Entity
@Table(name="Tutorials")
public class Tutorial extends Model {
    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = true)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSteps_count() {
        return steps_count;
    }

    public void setSteps_count(int steps_count) {
        this.steps_count = steps_count;
    }

    public Technology getTutorial_technology() {
        return tutorial_technology;
    }

    public void setTutorial_technology(Technology tutorial_technology) {
        this.tutorial_technology = tutorial_technology;
    }

    @Column(name = "steps_count", nullable = false)
    private int steps_count = 0;
    @ManyToOne(optional = false)
    @JoinColumn(name = "Technologies", referencedColumnName = "id")
    @RestResource(exported = false)
    @JsonBackReference
    private Technology tutorial_technology;


    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
        for(Step child : steps)
        {
            // initializing the TestObj instance in Children class (Owner side) so that it is not a null and PK can be created
            child.setTutorial(this);
        }
    }

    @OneToMany(mappedBy="tutorial", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JsonManagedReference
    private List<Step> steps= new ArrayList<Step>();
}
