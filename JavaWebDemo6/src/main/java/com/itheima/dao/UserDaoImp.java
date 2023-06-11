package com.itheima.dao;

import com.itheima.dao.impl.UserDao;

public class UserDaoImp implements UserDao {

    @Override
    public Boolean login(String name, String password) {
        if (name.equals("张三")&&password.equals("1234")){
            return true;
        }
        return false;
    }
}
