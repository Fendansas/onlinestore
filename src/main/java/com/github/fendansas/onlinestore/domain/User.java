package com.github.fendansas.onlinestore.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "u1"),
            inverseJoinColumns = @JoinColumn(name = "u2"))
    private List<UserCredentials> credentials;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<UserOrder> orders = new ArrayList<>();
}