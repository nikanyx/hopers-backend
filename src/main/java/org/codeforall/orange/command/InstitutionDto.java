package org.codeforall.orange.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InstitutionDto {

    private int id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 64)
    private String name;

    @NotNull(message = "Mail is mandatory")
    @NotBlank(message = "Mail is mandatory")
    @Size(min = 3, max = 64)
    private String mail;

    @NotNull(message = "Schedule is mandatory")
    @NotBlank(message = "Schedule is mandatory")
    @Size(min = 3, max = 64)
    private String schedule;

    @NotNull(message = "Address is mandatory")
    @NotBlank(message = "Address is mandatory")
    @Size(min = 3, max = 64)
    private String address;

    //Getters
    public int getId() {
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

    //Setters
    public void setId(int id) {
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

    public void setAddress(String adrress) {
        this.address = adrress;
    }
}
