package com.brillio.omnistore.user.service;

import java.util.List;

import com.brillio.omnistore.dto.UserDto;
import com.brillio.omnistore.model.User;

public interface UserService {

	List<User> getUsersByTypes(List<String> statuses);

	UserDto getCustomerProfile(String userId);

}
