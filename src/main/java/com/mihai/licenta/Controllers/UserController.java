package com.mihai.licenta.Controllers;

import com.mihai.licenta.Models.DBModels.UserPreferences;
import com.mihai.licenta.Models.DBModels.Settings;
import com.mihai.licenta.Models.DBModels.User;
import com.mihai.licenta.Service.UserService;
import com.mihai.licenta.Utils.Urls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by mihai on 15.05.2017.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    private static String UPLOADED_FOLDER = "/home/mihai/Documents/Licenta/Server/Resources/Images/User/";


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity registerUser(@RequestParam("username") String username,
                                       @RequestParam("email") String email,
                                       @RequestParam("password") String password,
                                       @RequestParam(value = "file", required = false) MultipartFile file) {
        User user = new User();
        if ((userService.findUserByEmail(email)) == null) {
            if ((userService.findUserByUsername(username) == null)) {
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                Long id = userService.saveUser(user, 0).getUid();

                try {
                    if (file != null) {
                        byte[] bytes = file.getBytes();
                        Path path = Paths.get(UPLOADED_FOLDER + id + "");
                        Files.write(path, bytes);

                        String url = Urls.BASE_URL + Urls.GET_PHOTO_URL + id;

                        userService.updateUserPhoto(url, id);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return ResponseEntity.status(HttpStatus.OK).body("User registered");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already in use");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already register");
        }

    }

    @RequestMapping(value = "/updatePreferences/{id}", method = RequestMethod.POST)
    public ResponseEntity updatePreferences(@RequestBody List<UserPreferences> preferences, @PathVariable("id") Long uid) {
        if (userService.updatePreferences(preferences, uid)) {
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No user with such id");
    }

    @RequestMapping(value = "/updateSettings/{id}", method = RequestMethod.POST)
    public ResponseEntity updateSettings(@RequestBody Settings settings, @PathVariable("id") Long uid) {
        if (userService.updateSettings(settings, uid)) {
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No user with such id");
    }


}
