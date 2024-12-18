package org.codeforall.orange.command;

import jakarta.validation.constraints.*;
import org.codeforall.orange.model.Institution;

public class GifteeDto {

    private int id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 64)
    private String name;

    @NotNull(message = "Age is mandatory")
    @NotBlank(message = "Age is mandatory")
    private Integer age;

    @NotNull(message = "Description is mandatory")
    @NotBlank(message = "Description is mandatory")
    @Size(min = 3, max = 256)
    private String description;

    @NotNull(message = "Institution is mandatory")
    @NotBlank(message = "Institution is mandatory")
    private Institution institution;

    //Getters
    public int getId() {
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

    public Institution getInstitution() {
        return institution;
    }

    //Setters
    public void setId(int id) {
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

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String toString(){
        return name + " (" + age + "): " + description + " :: " + institution;
    }
}

