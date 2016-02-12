package app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

/**
 * @author abdul.jabbar@octryx.com 2/9/2016.
 */
@Entity
@Table(name="Status")
public class Status extends Model {
    @Column(name="tutorials_completed",nullable = false)
    private int tutorials_completed = 0;

    public int getTutorials_completed() {
        return tutorials_completed;
    }

    public void setTutorials_completed(int tutorials_completed) {
        this.tutorials_completed = tutorials_completed;
    }

    public int getSteps_completed() {
        return steps_completed;
    }

    public void setSteps_completed(int steps_completed) {
        this.steps_completed = steps_completed;
    }

    @Column(name="steps_completed",nullable = false)
    private int steps_completed = 0;

    @OneToOne(optional= false)
    @JoinColumn(name = "Users_Technologies", referencedColumnName = "id")
    @RestResource(exported = false)
    @JsonBackReference
    private User_Technology user_technology;
//    @JsonIgnore
    public User_Technology getUser_technology() {
        return user_technology;
    }

    public void setUser_technology(User_Technology user_technology) {
        this.user_technology = user_technology;
    }
}
