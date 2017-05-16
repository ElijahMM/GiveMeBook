package com.mihai.licenta.Service;

import com.mihai.licenta.Models.DBModels.User;

/**
 * Created by mihai on 16.05.2017.
 */
public interface UserService {

    User findUserByEmail(String email);

    User findUserById(Long id);

    User findUserByUsername(String username);

    User saveUser(User user);

    int updateUserPhoto(String url, Long userId);

}
