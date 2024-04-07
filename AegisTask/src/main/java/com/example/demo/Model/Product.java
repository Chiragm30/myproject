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

@Table(name = "Product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Long productId;

    @Column(name = "ProductName", nullable = false)
    private String productName;

    @Column(name = "ProductDesc", nullable = false)
    private String productDesc;

    @Column(name = "ProductImg", nullable = false)
    private String productImg;

    @Column(name = "ProductSellPrice", nullable = false)
    private Double productSellPrice;

    @Column(name = "ProductCostPrice", nullable = false)
    private Double productCostPrice;

    @Column(name = "StockUnit", nullable = false)
    private Integer stockUnit;

    @ManyToOne
    @JoinColumn(name = "createdByUser", nullable = false)
    private User createdByUser;

    @Column(name = "CreateDate", nullable = false)
    private Date createDate;

    @Column(name = "IsDeleted", nullable = false)
    private Boolean isDeleted;
}
