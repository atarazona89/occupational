package com.hxplus.occupational.service;

import java.util.List;

import com.hxplus.occupational.model.User;
import com.hxplus.occupational.request.UserRequest;

public interface UserService {

	public User findById(Long id);
	public List<User> findAll();
	public User saveUser(UserRequest userRequest);
	public User createUser(User user);
	public User updateUser(Long id, UserRequest userRequest);
	public void deleteUser(Long id);
}
