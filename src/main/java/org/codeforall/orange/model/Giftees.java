package org.codeforall.orange.model;

import jakarta.persistence.*;

@Entity
@Table(name = "giftees")
public class Giftees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    private String description;

    @ManyToOne
    @JoinColumn(name = "institutions_id")  // Foreign key column in the Giftees table
    private Institutions institution; // Foreign key to Institution

    @ManyToOne
    @JoinColumn(name = "users_id")  // Foreign key column in the Giftees table
    private Users users; // Foreign key to Users

    private boolean status;//False = In Progress, True = Completed

    //Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public Institutions getInstitution() {
        return institution;
    }

    public Users getUsers() {
        return users;
    }

    public boolean isStatus() {
        return status;
    }

    //Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInstitution(Institutions institution) {
        this.institution = institution;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
