package com.packt.cardatabase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ownerId;
    private String firstname, lastname;

    public Owner() {}



    public Owner(String firstname, String lastname){
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
