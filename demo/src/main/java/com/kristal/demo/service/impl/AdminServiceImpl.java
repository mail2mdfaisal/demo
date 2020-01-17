package com.kristal.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kristal.demo.Vo.LoginVo;
import com.kristal.demo.model.Role;
import com.kristal.demo.model.Users;
import com.kristal.demo.repository.RoleRepository;
import com.kristal.demo.repository.UserRepository;
import com.kristal.demo.service.AdminService;
import com.kristal.demo.util.PasswordValidator;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public Users createUser(LoginVo loginVo) {
		Optional<Users> userObj = userRepository.findByUserName(loginVo.getUserName());
		if (!userObj.isPresent()) {
			String password = loginVo.getPassword();
			PasswordValidator passwordValidator = new PasswordValidator();
			if (passwordValidator.validate(password)) {

				Users user = new Users();
				user.setFirstName(loginVo.getFirstName());
				user.setLastName(loginVo.getLastName());
				user.setUserName(loginVo.getUserName());
				user.setPassword(password);
				user.setEmail(loginVo.getEmail());
				user.setDateOfBirth(loginVo.getDateOfBirth());

				Optional<Role> roleObj = roleRepository.findById(loginVo.getRoleId());
				if (roleObj.isPresent()) {
					Role role = roleObj.get();
					user.setRole(role);
				}

				return userRepository.save(user);
			}
		}

		return null;
	}

	public List<Users> getUsers() {
		return userRepository.findAll();
	}

	public Users getUserDetail(Long userId) {
		Optional<Users> userObj = userRepository.findById(userId);
		if (userObj.isPresent())
			return userObj.get();
		return null;
	}
}
