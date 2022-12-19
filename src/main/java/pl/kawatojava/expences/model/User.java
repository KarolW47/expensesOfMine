package pl.kawatojava.expences.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(unique = true, name = "email_address")
    private String emailAddress;

    @Column(name = "create_date")
    private Date createDate;


    public User() {
    }

    public User(Long id, String username, String password, String emailAddress, Date createDate) {
        this.id = id;
        this.password = password;
        this.emailAddress = emailAddress;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
