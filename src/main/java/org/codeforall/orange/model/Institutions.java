package org.codeforall.orange.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "institutions")
public class Institutions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    private String mail;

    private String schedule;

    private String address;

    private boolean isAvailable;

    @OneToMany(
            mappedBy = "institution",
            cascade = CascadeType.ALL,
            orphanRemoval = true
            //fetch = FetchType.LAZY
    )
    private List<Giftees> giftees = new ArrayList<>();

    //Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getAddress() {
        return address;
    }

    public boolean isAvailable() {
        return isAvailable;
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

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setGiftees(List<Giftees> giftees) {
        this.giftees = giftees;
    }
}
