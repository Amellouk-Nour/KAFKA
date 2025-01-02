package org.integration_services.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "entity1")
@Data
public class Entity1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name1;
    private String name2;

}

