package com.qust.service;

import com.qust.domain.Basis;
import com.qust.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Tan Weichao on 2017/4/13.
 */
public interface IRegService {
    boolean regUser(String uerId,String pwd);

    List<User> getUsers();


}
