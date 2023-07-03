package org.learning.java.springlamiapizzeriacrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Role {
    @Id
    private Integer id;

    private String name;
}
