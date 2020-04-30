package com.springboot.restspringbootjpa.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "first_name", nullable = false, length = 80)
    private String fistName;
    @Column(name= "last_name", nullable = false, length = 80)
    private String lastName;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(name="birth_date", nullable = false)
    private Date birthDate;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 1)
    private String gender;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) &&
                Objects.equals(getFistName(), client.getFistName()) &&
                Objects.equals(getLastName(), client.getLastName()) &&
                Objects.equals(getCpf(), client.getCpf()) &&
                Objects.equals(getBirthDate(), client.getBirthDate()) &&
                Objects.equals(getAddress(), client.getAddress()) &&
                Objects.equals(getGender(), client.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFistName(), getLastName(), getCpf(), getBirthDate(), getAddress(), getGender());
    }
}
