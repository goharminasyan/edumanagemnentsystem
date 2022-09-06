package com.epam.edumanagementsystem.parent.model.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Objects;

public class ParentDto {

    private Long id;
    @NotBlank(message = "Please, fill the required fields")
    private String name;
    @NotBlank(message = "Please, fill the required fields")
    private String surname;
    @NotBlank(message = "Please, fill the required fields")
    @Email
    private String email;
    @NotBlank(message = "Please, fill the required fields")
    @Size(min = 9, max = 50)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentDto parentDto = (ParentDto) o;
        return Objects.equals(id, parentDto.id) && Objects.equals(name, parentDto.name) && Objects.equals(surname, parentDto.surname) && Objects.equals(email, parentDto.email) && Objects.equals(password, parentDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password);
    }
}
