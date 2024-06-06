package com.logging.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "emp")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;



}
