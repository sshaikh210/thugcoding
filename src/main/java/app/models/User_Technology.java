package app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

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
    public Technology getUser_technology() {
        return user_technology;
    }
    public void setUser_technology(Technology user_technology) {
        this.user_technology = user_technology;
    }
    @ManyToOne(optional = false)
    @JoinColumn(name = "Technologies", referencedColumnName = "id")
    @RestResource(exported = false)
    @JsonBackReference
    private Technology user_technology;
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    @OneToOne(mappedBy="user_technology", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JsonManagedReference
    private Status status;
}
