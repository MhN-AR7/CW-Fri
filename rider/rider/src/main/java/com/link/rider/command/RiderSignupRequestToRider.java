package com.link.rider.command;

import com.link.rider.dto.RiderSignupRequest;
import com.link.rider.model.Rider;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RiderSignupRequestToRider {
    Rider convert(RiderSignupRequest riderSignupRequest);
}
