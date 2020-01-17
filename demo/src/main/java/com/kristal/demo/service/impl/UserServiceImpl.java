package com.kristal.demo.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kristal.demo.Vo.ChangePasswordVo;
import com.kristal.demo.Vo.LoginVo;
import com.kristal.demo.model.Role;
import com.kristal.demo.model.Users;
import com.kristal.demo.repository.UserRepository;
import com.kristal.demo.service.UserService;
import com.kristal.demo.util.PasswordValidator;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public boolean loginService(String userName, String password) {
        Optional<Users> userObj = userRepository.findByUserName(userName);
        if(userObj.isPresent())
        {
        	Users user = userObj.get();
            if (user != null) {
                if (password.equals(user.getPassword()))
                    return true;
            }
        }
        
        return false;
    }

    public boolean changePassword(ChangePasswordVo changePasswordVo) {
    	Optional<Users> userObj = userRepository.findByUserName(changePasswordVo.getUserName());
        PasswordValidator passwordValidator;
        Users user = userObj.get();
        if (user != null) {
            if (changePasswordVo.getOldPassword().equals(user.getPassword())) {
                passwordValidator = new PasswordValidator();
                boolean validPassword = passwordValidator.validate(changePasswordVo.getNewPassword());
                if (validPassword) {
                    user.setPassword(changePasswordVo.getNewPassword());
                    userRepository.save(user);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public Users editUser(LoginVo loginVo)
    {
        Optional<Users> userObj = userRepository.findById(loginVo.getUserId());
    	if(userObj.isPresent())
    	{
        	String password = loginVo.getPassword();
            PasswordValidator passwordValidator = new PasswordValidator();
            if(passwordValidator.validate(password))
            {

    	    	Users user = userObj.get();
    	    	user.setFirstName(loginVo.getFirstName());
    	    	user.setLastName(loginVo.getLastName());
    	    	user.setPassword(password);
    	    	user.setEmail(loginVo.getEmail());
    	    	user.setDateOfBirth(loginVo.getDateOfBirth());
        	
                return userRepository.save(user);
            }
    	}
    	
    	return null;
    }
}
