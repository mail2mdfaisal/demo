package com.kristal.demo.service;

import com.kristal.demo.Vo.ChangePasswordVo;
import com.kristal.demo.Vo.LoginVo;
import com.kristal.demo.model.Users;

public interface UserService {

    public boolean loginService(String userName,String password);
    public boolean changePassword(ChangePasswordVo changePasswordVo);
    public Users editUser(LoginVo loginVo);
}
