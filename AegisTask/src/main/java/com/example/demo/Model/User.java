package com.example.demo.Model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "User")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "DateOfBirth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "EmailID", nullable = false)
    private String emailId;

    @Column(name = "MobileNo", nullable = false)
    private String mobileNo;

    @Column(name = "Balance", nullable = false)
    private Double balance;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "UserRole", nullable = false)
    private UserRole userRole;

}
