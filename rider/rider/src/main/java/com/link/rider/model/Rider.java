package com.link.rider.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

@Entity
@DiscriminatorValue("RIDER")
public class Rider extends UserDao {
    @Column(name = "home_address", length = 200)
    private String homeAddress;
}
