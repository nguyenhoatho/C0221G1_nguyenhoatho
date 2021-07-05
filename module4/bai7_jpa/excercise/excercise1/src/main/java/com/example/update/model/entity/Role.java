package com.example.update.model.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRole;
    private String roleName;
    @ManyToMany(mappedBy ="roles")
    private Collection<User> userCollection;
}
