package org.codeforall.orange.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * DONORS ACCOUNTS
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private String mail;
    private Integer donations;

    @OneToMany(
            mappedBy = "users",
            cascade = CascadeType.ALL,
            orphanRemoval = true
            //fetch = FetchType.LAZY
    )  // Inverse side of the relationship
    private List<Giftee> giftees;

    //Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public int getDonations() {
        return donations;
    }

    public List<Giftee> getGiftees() {
        return giftees;
    }

    //Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDonations(int donations) {
        this.donations = donations;
    }

    public void setGiftees(List<Giftee> giftees) {
        this.giftees = giftees;
    }
}
