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
@Table(name = "User_Purchase")
public class UserPurchase {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PurchaseID")
    private Long purchaseId;

    @Column(name = "PurchseDate", nullable = false)
    private Date purchaseDate;

    @ManyToOne
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @Column(name = "totalUnit", nullable = false)
    private Integer totalUnit;

    @ManyToOne
    @JoinColumn(name = "PurchaseByUser", nullable = false)
    private User purchaseByUser;

    @ManyToOne
    @JoinColumn(name = "PurchaseFromUser", nullable = false)
    private User purchaseFromUser;
}
