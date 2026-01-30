package com.dharmaraj.redbus.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel {

    @Embedded
    private Account account;

    @OneToMany(mappedBy = "user")
    private List<AssociatedUser> associatedUsers;

    @ManyToOne
    private Country country;
}
