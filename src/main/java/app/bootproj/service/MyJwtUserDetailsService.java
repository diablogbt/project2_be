package app.bootproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.bootproj.dao.UserDao;
import app.bootproj.pojo.UserInfo;

/**
 * MyUserDetailsService
 */
@Service
public class MyJwtUserDetailsService implements UserDetailsService{
    @Autowired
    UserDao userDao;

    UserBuilder builder = null;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        if(userInfo!=null){
            builder = User.withUsername(username)
                .password(new BCryptPasswordEncoder().encode(userInfo.getPassword()))
                .roles(userInfo.getRole());
        } else {
            System.out.println("------get a not found user request=====");
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }
}