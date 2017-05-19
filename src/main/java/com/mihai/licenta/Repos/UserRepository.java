package com.mihai.licenta.Repos;

import com.mihai.licenta.Models.DBModels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by mihai on 12.04.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    User findUserByEmailAndPassword(String email, String password);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE user u SET u.photo_url = :url WHERE u.uid = :userID")
    int updateUserPhoto(@Param("url") String url, @Param("userID") Long userId);

}
