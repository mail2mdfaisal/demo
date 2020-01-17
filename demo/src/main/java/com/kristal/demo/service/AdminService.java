package com.kristal.demo.service;


import java.util.List;

import com.kristal.demo.Vo.LoginVo;
import com.kristal.demo.model.Users;

public interface AdminService {

    public Users createUser(LoginVo loginVo);

    public List<Users> getUsers();

    public Users getUserDetail(Long userId);

}
