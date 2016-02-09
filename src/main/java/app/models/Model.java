package app.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Model {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Long id;

    private Date dateCreated;

    @Version
    private Timestamp dateModified;

    @PrePersist
    void createdAt() {
        this.setDateCreated(new Date());
    }

    private boolean active = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateModified() {
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified) {
        this.dateModified = dateModified;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive(){
        return this.active;
    }
}
