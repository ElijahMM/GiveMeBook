package com.mihai.licenta.Impl;

import com.mihai.licenta.Models.DBModels.Preferences;
import com.mihai.licenta.Models.DBModels.Settings;
import com.mihai.licenta.Models.DBModels.User;
import com.mihai.licenta.Repos.UserRepository;
import com.mihai.licenta.Service.UserService;
import com.mihai.licenta.Utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by mihai on 16.05.2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Md5PasswordEncoder passwordEncoder;


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
    public User loginUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            if (passwordEncoder.isPasswordValid(user.getPassword(), password, "test")) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Boolean updatePreferences(List<Preferences> prefs, Long uid) {
        User user = findUserById(uid);
        if (user != null) {
            for (Preferences p : prefs) {
                p.setUser(user);
                user.getPreferences().add(p);
                saveUser(user, 1);
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateSettings(Settings settings, Long id) {
        User user = findUserById(id);
        if (user != null) {
            user.setSettings(settings);
            saveUser(user, 1);
            return true;
        }
        return false;
    }

    @Override
    public User saveUser(User user, Integer createOrUpdate) {
        if (createOrUpdate == 0) {
            user.setPassword(passwordEncoder.encodePassword(user.getPassword(), "test"));
            user.setType(2);

            user.setCreatedAt(Util.getSqlDate());
            user.setUpdatedAt(Util.getSqlDate());

            Settings u_setting = new Settings();
            u_setting.setEmailNotiffication(false);
            u_setting.setPushNotiffication(false);
            u_setting.setUser(user);
            user.setSettings(u_setting);

        } else {
            user.setUpdatedAt(Util.getSqlDate());
        }
        return userRepository.save(user);
    }

    @Override
    public int updateUserPhoto(String url, Long userId) {
        return userRepository.updateUserPhoto(url, userId);
    }


}
