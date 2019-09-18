package com.user.data.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.data.model.User;
import com.user.data.service.UserSearchService;

@RestController
public class UserSearchController {
	
	private static Logger logger = LoggerFactory.getLogger(UserSearchController.class);

	private UserSearchService service;
	
	@Autowired	
	public UserSearchController(UserSearchService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ResponseEntity<Iterable<com.user.data.entity.User>> getAllUsers(){
	    return ResponseEntity.ok(service.featchAllUsers());	
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/create/user")
	public ResponseEntity<Void> putNewUser(@Valid @RequestBody User user){
	    service.createNewUser(user);
	    return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/update/user")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		return ResponseEntity.ok(service.updateUser(user));
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/user")
	public ResponseEntity<Void> deleteUser(@RequestBody User user){
		service.deleteUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
