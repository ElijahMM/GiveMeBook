package com.mihai.licenta.Impl;

import com.mihai.licenta.Models.DBModels.User;
import com.mihai.licenta.Repos.UserRepository;
import com.mihai.licenta.Service.UserService;
import com.mihai.licenta.Utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * Created by mihai on 16.05.2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User saveUser(User user) {
       //  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setType(2);
        user.setCreatedAt(Util.getSqlDate());
        user.setUpdatedAt(Util.getSqlDate());
        return userRepository.save(user);
    }

    @Override
    public int updateUserPhoto(String url, Long userId) {
        return userRepository.updateUserPhoto(url,userId);
    }
}
