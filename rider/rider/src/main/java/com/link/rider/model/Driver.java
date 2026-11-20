package com.link.rider.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder

@Entity
@DiscriminatorValue("DRIVER")
public class Driver extends UserDao {
    @Column(name = "vehicle_license_number", length = 15)
    private String vehicleLicenseNumber;
}
