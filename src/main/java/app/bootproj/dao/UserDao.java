package app.bootproj.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.bootproj.pojo.UserInfo;

/**
 * UserDao
 */
@Repository
public interface UserDao extends JpaRepository<UserInfo, Integer>{

	List<UserInfo> findByUsernameAndPassword(String username, String password);
    UserInfo findByUsername(String username);

    // @Modifying
    // @Query("UPDATE userinfo ur SET ur.token = :token WHERE ur.username = :name")
    // int updateToken(@Param("name") String username, @Param("token") String token);
}