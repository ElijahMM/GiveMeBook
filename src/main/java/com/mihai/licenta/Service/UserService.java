package com.mihai.licenta.Service;

import com.mihai.licenta.Models.DBModels.UserPreferences;
import com.mihai.licenta.Models.DBModels.Settings;
import com.mihai.licenta.Models.DBModels.User;

import java.util.List;

/**
 * Created by mihai on 16.05.2017.
 */
public interface UserService {

    User findUserByEmail(String email);

    User findUserById(Long id);

    User findUserByUsername(String username);

    User saveUser(User user, Integer createOrUpdate);

    int updateUserPhoto(String url, Long userId);

    User loginUser(String email, String password);

    Boolean updatePreferences(List<UserPreferences> prefs, Long uid);

    Boolean updateSettings(Settings settings, Long id);

}
