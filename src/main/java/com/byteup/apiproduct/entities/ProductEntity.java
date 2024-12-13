package com.byteup.apiproduct.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Table(name = "TB_PRODUCT")
@JsonPropertyOrder({"id", "name", "expirationDate", "price", "quantity"})
@Entity
@Getter
@Setter

public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "expirationDate")
    private Date expirationDate;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private int quantity;
}
