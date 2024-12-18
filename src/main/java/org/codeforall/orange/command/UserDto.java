package org.codeforall.orange.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDto {

    private int id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 64)
    private String name;

    @NotNull(message = "Phone is mandatory")
    @NotBlank(message = "Phone is mandatory")
    private Integer phone;

    @NotNull(message = "Description is mandatory")
    @NotBlank(message = "Description is mandatory")
    @Size(min = 3, max = 256)
    private String mail;

    @NotNull(message = "Phone is mandatory")
    @NotBlank(message = "Phone is mandatory")
    private Integer donations;

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public Integer getDonations() {
        return donations;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDonations(Integer donations) {
        this.donations = donations;
    }
}
