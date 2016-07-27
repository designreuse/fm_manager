package com.avlasenko.sb.fmmanager.util.dto;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Document;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * Created by A. Vlasenko on 21.07.2016.
 */
public class IndividualQuickFormDTO implements DTO {

    @Max(9999999999L)
    @Min(100000000L)
    private long identNumber;

    private boolean client;

    @Length(max = 25)
    @NotEmpty
    private String firstName;

    @Length(max = 25)
    @NotEmpty
    private String lastName;

    @Length(max = 25)
    private String middleName;

    @NotNull
    private LocalDate dateBirth;

    private boolean resident;

    @NotNull
    @Valid
    private Address address;

    @NotNull
    @Valid
    private Document document;

    public IndividualQuickFormDTO() {
    }

    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public long getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(long identNumber) {
        this.identNumber = identNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public boolean isResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}