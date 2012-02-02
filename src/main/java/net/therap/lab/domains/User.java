package net.therap.lab.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jahangir
 * @since 2/2/12 1:34 PM
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "NAME", length = 120)
    private String name;

    @Column(name = "EMAIL", length = 64)
    private String email;

    @Column(name = "USER_NAME", length = 32)
    private String userName;

    @Column(name = "HASHED_PASSWORD", length = 32)
    private String hashedPassword;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED")
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED")
    private Date updated;

    @PrePersist
    public void prePersist() {
        created = new Date();
        updated = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updated = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

}
