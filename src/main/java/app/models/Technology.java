package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdul.jabbar@octryx.com 2/9/2016.
 */
@Entity
@Table(name = "Technologies")
public class Technology extends Model {
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

    public int getTutorials_count() {
        return tutorials_count;
    }

    public void setTutorials_count(int tutorials_count) {
        this.tutorials_count = tutorials_count;
    }

    @Column(name = "tutorials_count", nullable = false)
    private int tutorials_count = 0;
    public synchronized List<User_Technology> getUser_technologies() {
        return user_technologies;
    }

    public synchronized void setUserTechnology(List<User_Technology> user_technologies) {
        this.user_technologies = user_technologies;

        for(User_Technology child : user_technologies)
        {
            // initializing the TestObj instance in Children class (Owner side) so that it is not a null and PK can be created
            child.setUser_technology(this);
        }
    }

    @OneToMany(mappedBy="user_technology", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
   @JsonManagedReference
    private List<User_Technology> user_technologies= new ArrayList<User_Technology>();

    public List<Tutorial> getTutorials() {
        return tutorials;
    }

    public void setTutorials(List<Tutorial> tutorials) {
        this.tutorials = tutorials;
        for(Tutorial child : tutorials)
        {
            // initializing the TestObj instance in Children class (Owner side) so that it is not a null and PK can be created
            child.setTutorial_technology(this);
        }
    }

    @OneToMany(mappedBy="tutorial_technology", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JsonManagedReference
    private List<Tutorial> tutorials= new ArrayList<Tutorial>();


}
