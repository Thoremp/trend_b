package com.qust.service.impl;

import com.qust.domain.User;
import com.qust.mapper.UserMapper;
import com.qust.service.IRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tan Weichao on 2017/4/13.
 */
@Service()
public class RegService implements IRegService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean regUser(String uerId, String pwd) {

        Boolean flag;
        try {
            flag = userMapper.insertUsers(uerId,pwd);
        }catch (Exception e){
            return false;
        }
        return flag;
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
