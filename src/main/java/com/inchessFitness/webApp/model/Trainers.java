package com.inchessFitness.webApp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "trainers")
public class Trainers extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "native")
    @GenericGenerator(name = "native" , strategy = "native")
    @Column(name = "trainer_id")
    private int trainersid;

    @NotBlank(message="Name must not be blank")
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;


    @NotBlank(message="Email must not be blank")
    @Email(message = "Please provide a valid email address" )
    private String email;

    @NotBlank(message="Mobile number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message="Field must not be blank")
    private String specializedIn;


    @NotBlank(message="fees must not be blank")
    private String emolument;

    @NotBlank(message="Password must not be blank")
    @Size(min=5, message="Password must be at least 5 characters long")
    private String pwd;

    @NotBlank(message="Confirm Password must not be blank")
    @Size(min=5, message="Confirm Password must be at least 5 characters long")
    @Transient
    private String confirmPwd;

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST,targetEntity = Roles.class)
    @JoinColumn(name="role_id" , referencedColumnName = "roleId",nullable = true)
    private Roles roles;


    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST,targetEntity = Address.class)
    @JoinColumn(name="address_id" , referencedColumnName = "addressId",nullable = true)
    private Address address;
}
