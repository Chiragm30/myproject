package com.appsdeveloperblog.photoapp.Api.Users.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.photoapp.Api.Users.data.UserEntity;
import com.appsdeveloperblog.photoapp.Api.Users.data.UserRepository;
import com.appsdeveloperblog.photoapp.Api.Users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService{

	UserRepository usersRepository;
	
	@Autowired
	public UsersServiceImpl(UserRepository usersRepository)
	{
		this.usersRepository=usersRepository;
	}
	
	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper md=new ModelMapper();
		md.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity =md.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword("test");
		usersRepository.save(userEntity);
		
		UserDto returnvalue=md.map(userEntity, UserDto.class);
		return returnvalue;
	}

}
