package com.brillio.omnistore.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.omnistore.dto.AddressDto;
import com.brillio.omnistore.dto.UserDto;
import com.brillio.omnistore.model.Address;
import com.brillio.omnistore.model.User;
import com.brillio.omnistore.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsersByTypes(List<String> types) {

		return userRepository.findByTypeIn(types);
	}

	@Override
	public UserDto getCustomerProfile(String userId) {
		Optional<User> userFromDb = userRepository.findById(userId);

		if (userFromDb.isPresent()) {
			UserDto userDto = new UserDto();
			User user = userFromDb.get();

			mapUser(userDto, user);
			mapAddress(userDto, user);

			return userDto;
		}
		return null;
	}

	private void mapUser(UserDto userDto, User user) {
		userDto.setFirstName(user.getFirstName());
		userDto.setId(user.getId());
		userDto.setLastName(user.getLastName());
		userDto.setType(user.getType());
		userDto.setUpdatedBy(user.getUpdatedBy());
		userDto.setUpdatedDate(user.getUpdatedDate());
	}

	private void mapAddress(UserDto userDto, User user) {
		AddressDto addressDto = new AddressDto();
		Address address = user.getAddress();
		addressDto.setCity(address.getCity());
		addressDto.setCountry(address.getCountry());
		addressDto.setId(address.getId());
		addressDto.setStreet(address.getStreet());
		addressDto.setTel(address.getTel());
		addressDto.setUpdatedBy(address.getUpdatedBy());
		addressDto.setUpdatedDate(address.getUpdatedDate());
		addressDto.setZip(address.getZip());
		userDto.setAddress(addressDto);
	}

}
