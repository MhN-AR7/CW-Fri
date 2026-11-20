package com.link.rider.command;

import com.link.rider.dto.DriverSignupRequest;
import com.link.rider.model.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverSignupRequestToDriver {
    Driver convert(DriverSignupRequest driverSignupRequest);
}
