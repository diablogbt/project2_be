package app.bootproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

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

    public UserInfo get(String username, String password){
        List<UserInfo> res= userDao.findByUsernameAndPassword(username, password);
        if(res.size()>0) return res.get(0);
        else
        return null;
    }

    public UserInfo get(String username) {
        return userDao.findByUsername(username);        
    }

    public UserInfo get(Integer id){
        return userDao.findById(id).get();
    }

    public void add(UserInfo userInfo){
        userDao.save(userInfo);
    }

    public Integer getId(String username){
        return userDao.findByUsername(username).getUserid();
    }
    
    public void saveToken(String username, String token){
        UserInfo userInfo = userDao.findByUsername(username);
        if(userInfo == null)return;
        else {
            userInfo.setToken(token);
            userDao.save(userInfo);
        }
    }
}