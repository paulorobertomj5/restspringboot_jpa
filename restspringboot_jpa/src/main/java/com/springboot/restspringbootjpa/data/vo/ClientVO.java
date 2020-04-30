package com.springboot.restspringbootjpa.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "fistName", "lastName", "address", "gender"})
public class ClientVO extends ResourceSupport implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(position = 1)
    @JsonProperty("id")
    private Long key;

    @ApiModelProperty(required = true, position = 2, notes = "First name should have max 80 caracteres")
    @NotNull
    @NotBlank
    @Size(max = 80, message = "First name should have max 80 caracteres")
    private String fistName;

    @ApiModelProperty(required = true, position = 3, notes = "Last name should have max 80 caracteres")
    @NotNull
    @NotBlank
    @Size(max = 80, message = "Last name should have max 80 caracteres")
    private String lastName;

    @ApiModelProperty(required = true, position = 4, notes = "Cpf should have 11 numeric caracteres")
    @Size(min = 11, max = 11, message = "Cpf name should have 11 caracteres")
    @Pattern(regexp = "^[0-9/\\-. ]*$")
    private String cpf;

    @ApiModelProperty(required = true, position = 5 , notes = "Birth date should have maximum the format yyyy-MM-dd")
    private Date birthDate;

    @ApiModelProperty(required = true, position = 6 , notes = "Address should have maximum 100 caracteres")
    @NotNull
    @NotBlank
    @Size(max = 100, message = "Last name should have max 100 caracteres")
    private String address;

    @ApiModelProperty(required = true, position = 7 , notes = "Gender should have 1 caracter")
    @NotNull
    @NotBlank
    @Size(min = 1, max = 1, message = "Gender should have 1 caracter")
    private String gender;

    public ClientVO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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
        if (!(o instanceof ClientVO)) return false;
        if (!super.equals(o)) return false;
        ClientVO clientVO = (ClientVO) o;
        return Objects.equals(getKey(), clientVO.getKey()) &&
                Objects.equals(getFistName(), clientVO.getFistName()) &&
                Objects.equals(getLastName(), clientVO.getLastName()) &&
                Objects.equals(getCpf(), clientVO.getCpf()) &&
                Objects.equals(getBirthDate(), clientVO.getBirthDate()) &&
                Objects.equals(getAddress(), clientVO.getAddress()) &&
                Objects.equals(getGender(), clientVO.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getFistName(), getLastName(), getCpf(), getBirthDate(), getAddress(), getGender());
    }
}

