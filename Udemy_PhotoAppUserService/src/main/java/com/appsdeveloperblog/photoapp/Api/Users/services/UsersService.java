package com.appsdeveloperblog.photoapp.Api.Users.services;

import com.appsdeveloperblog.photoapp.Api.Users.shared.UserDto;

public interface UsersService {
  UserDto createUser(UserDto userDetails);
}
