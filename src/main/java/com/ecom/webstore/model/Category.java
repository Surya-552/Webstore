package com.ecom.webstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data //lombok for auto getter and setter method
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;
    private String name;
}
