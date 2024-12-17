package org.codeforall.orange.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * DONORS ACCOUNTS
 */
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    private int phone;

    private String mail;
    private int donations;

    @OneToMany(
            mappedBy = "users",
            cascade = CascadeType.ALL,
            orphanRemoval = true
            //fetch = FetchType.LAZY
    )  // Inverse side of the relationship
    private List<Giftees> giftees;

    //Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public int getNumberOfDonations() {
        return donations;
    }

    public List<Giftees> getGiftees() {
        return giftees;
    }

    //Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNumberOfDonations(int donations) {
        this.donations = donations;
    }

    public void setGiftees(List<Giftees> giftees) {
        this.giftees = giftees;
    }
}
