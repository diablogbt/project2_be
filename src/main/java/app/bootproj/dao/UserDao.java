package app.bootproj.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.bootproj.pojo.UserInfo;

/**
 * UserDao
 */
@Repository
public interface UserDao extends JpaRepository<UserInfo, Integer>{
    
}