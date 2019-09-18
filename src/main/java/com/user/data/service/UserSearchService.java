package com.user.data.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.data.mapper.UserMapper;
import com.user.data.model.User;
import com.user.data.repository.UserRepository;

@Service
public class UserSearchService {

	private static Logger logger = LoggerFactory.getLogger(UserSearchService.class);

	@PersistenceContext
	private EntityManager entityManager;

	private UserRepository repository;

	private UserMapper userMapper;

	@Autowired
	public UserSearchService(EntityManager em, UserRepository repository, UserMapper userMapper) {
		this.entityManager = em;
		this.repository = repository;
		this.userMapper = userMapper;
	}

	public Iterable<com.user.data.entity.User> featchAllUsers(){
		return repository.findAll();
	}

	@Transactional
	public void createNewUser(User user) {
		com.user.data.entity.User userEntity =  userMapper.mapToEntity(user);
		repository.save(userEntity);
	}

	public void deleteUser(User user) {
		com.user.data.entity.User entity =  userMapper.mapToEntity(user);
		List<com.user.data.entity.User> usersToBeDeleted =
				entityManager.createQuery("FROM User u WHERE u.name = ?1")
				.setParameter(1, entity.getName())
				//.setParameter(2, entity.getServiceLine())
				.getResultList();

		usersToBeDeleted.stream()
		.forEach(i -> deleteUserById(i.getId()));
	}

	public void deleteUserById(Integer id) {
		repository.deleteById(id);
	}

	public User updateUser(User user) {
		return user;
	}


}
