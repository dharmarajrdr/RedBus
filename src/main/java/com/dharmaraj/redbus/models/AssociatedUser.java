package com.dharmaraj.redbus.models;

import com.dharmaraj.redbus.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AssociatedUser extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private User user;
}
