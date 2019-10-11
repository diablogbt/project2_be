
package app.bootproj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.bootproj.pojo.FanList;

/**
 * FanListDao
 */

@Repository
public interface FanListDao extends JpaRepository<FanList,Integer>{

    
}