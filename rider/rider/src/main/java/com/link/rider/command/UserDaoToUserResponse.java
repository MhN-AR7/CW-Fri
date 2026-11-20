package com.link.rider.command;

import com.link.rider.dto.UserResponse;
import com.link.rider.model.UserDao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDaoToUserResponse {
    UserResponse convert(UserDao userDao);
}
