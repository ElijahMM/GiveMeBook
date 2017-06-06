package com.mihai.licenta.Impl;

import com.mihai.licenta.Models.DBModels.UserPreferences;
import com.mihai.licenta.Models.DBModels.Settings;
import com.mihai.licenta.Models.DBModels.User;
import com.mihai.licenta.Repos.UserRepository;
import com.mihai.licenta.Service.UserService;
import com.mihai.licenta.Utils.Urls;
import com.mihai.licenta.Utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by mihai on 16.05.2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Md5PasswordEncoder passwordEncoder;

    private static String UPLOADED_FOLDER = "/home/mihai/Documents/Licenta/Server/Resources/Images/User/";

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
    public Boolean registerUser(User user, MultipartFile file) {

        if ((findUserByEmail(user.getEmail())) == null) {
            if ((findUserByUsername(user.getUsername()) == null)) {
                Long id = this.saveUser(user, 0).getUid();
                try {
                    if (file != null) {
                        byte[] bytes = file.getBytes();
                        Path path = Paths.get(UPLOADED_FOLDER + id + "");
                        Files.write(path, bytes);

                        String url = Urls.BASE_URL + Urls.GET_PHOTO_URL + id;

                        setUpUserPhotoUrl(url, id);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public Boolean updatePreferences(List<UserPreferences> prefs, Long uid) {
        User user = findUserById(uid);
        if (user != null) {
            Set<UserPreferences> newPreferenceList = prefs.stream().filter(n -> !user.getPreferences().contains(n)).collect(Collectors.toSet());
            user.getPreferences().clear();
            for (UserPreferences p : newPreferenceList) {
                p.setUser(user);
                user.getPreferences().add(p);
            }
            saveUser(user, 1);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateSettings(Settings settings, Long id) {
        User user = findUserById(id);
        if (user != null) {
            settings.setSid(user.getSettings().getSid());
            settings.setUser(user);
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
            u_setting.setEmailNotification(false);
            u_setting.setPushNotification(false);
            u_setting.setUser(user);
            user.setSettings(u_setting);

        } else {
            user.setUpdatedAt(Util.getSqlDate());
        }
        return userRepository.save(user);
    }

    @Override
    public Boolean updateUserPhoto(Long uid, MultipartFile file) {
        User user = findUserById(uid);
        if (user != null) {
            try {
                if (file != null) {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(UPLOADED_FOLDER + user.getUid() + "");
                    Files.write(path, bytes);

                    String url = Urls.BASE_URL + Urls.GET_PHOTO_URL + user.getUid();

                    setUpUserPhotoUrl(url, user.getUid());
                } else {
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public int setUpUserPhotoUrl(String url, Long userId) {
        return userRepository.updateUserPhotoUrl(url, userId);
    }

}
