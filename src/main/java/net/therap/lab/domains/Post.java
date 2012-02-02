package net.therap.lab.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jahangir
 * @since 2/2/12 1:29 PM
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE", length = 250)
    private String title;

    @Column(name = "DESCRIPTION")
    @Lob
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @PrePersist
    public void prePersist() {
        created = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

}
