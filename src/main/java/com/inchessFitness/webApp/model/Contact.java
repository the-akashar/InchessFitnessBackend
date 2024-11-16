package com.inchessFitness.webApp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator="native")
    @GenericGenerator(name = "native" , strategy = "native")
    @Column(name = "contact_id")
    private int contactId;

    @NotBlank(message = "Please enter a valid name")
    private String name;

    @NotBlank(message = "Please enter a valid message")
    @Email(message = "Please enter a valid message")
    private String email;

    @NotBlank(message = "Mobile number cannot be blank")
    @Pattern(regexp = "(^$|[0-9]{10})" , message = "please enter a valid mobile number")
    private String mobileNum;

    @NotBlank(message = "Please mention your Goal")
    private String goal;

    private String message;


    private String status;


}
