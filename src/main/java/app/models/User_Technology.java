package app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author abdul.jabbar@octryx.com 2/9/2016.
 */
@Entity
@Table(name = "Users_Technologies")
public class User_Technology extends Model {
    @ManyToOne(optional = false)
    @JoinColumn(name = "Users", referencedColumnName = "id")
    @RestResource(exported = false)
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Technology getTechnology() {
        return user_technology;
    }

    public void setTechnology(Technology technology) {
        this.user_technology = technology;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "Technologies", referencedColumnName = "id")
    @RestResource(exported = false)
    @JsonBackReference
    private Technology user_technology;


}
