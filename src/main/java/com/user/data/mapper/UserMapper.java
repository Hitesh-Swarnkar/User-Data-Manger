package com.user.data.mapper;

import org.springframework.stereotype.Component;

import com.user.data.entity.User;

@Component
public class UserMapper {

	public User mapToEntity(com.user.data.model.User user) {
		User userEntity = new User();
		userEntity.setName(user.getUserName());
		userEntity.setServiceLine(user.getServiceLine());
		return userEntity;
	}

}
