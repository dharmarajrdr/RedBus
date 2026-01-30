package com.dharmaraj.redbus.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User extends BaseModel {

    @Embedded
    private Account account;

    @OneToMany(mappedBy = "user")
    private List<AssociatedUser> associatedUsers;
}
