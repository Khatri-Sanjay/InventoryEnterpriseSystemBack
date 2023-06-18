//package com.sanjay.InventoryEnterpriseSystem.category;
//
//import com.sanjay.InventoryEnterpriseSystem.item.entity.Items;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.Set;
//
//@Entity
//@Table(name = "category")
//@Data
//public class Category {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "category_name")
//    private String categoryName;
//
//    //Collection - Java Collection -- also se the Product rel. on the Product Class
//    //==================@OneToMany====================//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
//    private Set<Items> items;
//
//}
