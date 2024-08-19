package edu.icet.crm.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity     // make this class as entity class foe creat table like this
@Table(name = "product")        // Set Table Name
public class ProductEntity {
        @Id     //Set primary key
        @GeneratedValue(strategy = GenerationType.AUTO)     //Genarate primary key Auto
        private Long id;        //Primary Key now
        private String name;
        private String description;
        private Double price;

}
