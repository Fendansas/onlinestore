package by.grodno.onlinestore.domain;


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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(unique = true,name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "place_number")
    private String placeNumber;

    @OneToMany( mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<UserCredentials> credentials;

    @OneToMany( mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<UserOrder> orders = new ArrayList<>();






}
