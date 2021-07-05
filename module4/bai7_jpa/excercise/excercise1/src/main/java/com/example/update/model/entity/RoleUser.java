package com.example.update.model.entity;

import javax.persistence.*;

@Entity
public class RoleUser {
    @EmbeddedId
    private RoleRatingKey id;
    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @MapsId("idRole")
    @JoinColumn(name = "idRole")
    private Role role;
}
