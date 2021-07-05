package com.example.update.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class RoleRatingKey implements Serializable {
    @Column(name = "idUSer")
    Integer idUser;
    @Column(name = "idRole")
    Integer idRole;
}
