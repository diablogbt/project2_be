package app.bootproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.bootproj.dao.UserDao;
import app.bootproj.pojo.UserInfo;

/**
 * UserService
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<UserInfo> getAll(){
        return userDao.findAll();
    }
}