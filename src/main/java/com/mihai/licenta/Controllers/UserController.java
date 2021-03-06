package com.mihai.licenta.Controllers;

import com.mihai.licenta.Models.DBModels.UserPreferences;
import com.mihai.licenta.Models.DBModels.Settings;
import com.mihai.licenta.Models.DBModels.User;
import com.mihai.licenta.Models.InternModels.InteractionIncoming;
import com.mihai.licenta.Models.InternModels.SharedUser;
import com.mihai.licenta.Models.InternModels.StringResonse;
import com.mihai.licenta.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by mihai on 15.05.2017.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity registerUser(@RequestParam("username") String username,
                                       @RequestParam("email") String email,
                                       @RequestParam("password") String password,
                                       @RequestParam(value = "photo", required = false) MultipartFile file) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        if (userService.registerUser(user, file)) {
            return ResponseEntity.status(HttpStatus.OK).body(new StringResonse("User registered"));
        }
        return ResponseEntity.badRequest().body(new StringResonse("User already register"));
    }

    @RequestMapping(value = "/logout/{id}", method = RequestMethod.POST)
    public ResponseEntity logoutUser(@PathVariable("id") Long uid) {
        if (userService.removeUserToken(uid)) {
            return ResponseEntity.ok().body(new StringResonse("Success"));
        }
        return ResponseEntity.badRequest().body(new StringResonse("Invalid User"));
    }

    @RequestMapping(value = "/updatePreferences/{id}", method = RequestMethod.POST)
    public ResponseEntity updatePreferences(@RequestBody List<UserPreferences> preferences, @PathVariable("id") Long uid) {
        if (userService.updatePreferences(preferences, uid)) {
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }
        return ResponseEntity.badRequest().body(new StringResonse("No user with such id"));
    }

    @RequestMapping(value = "/updateSettings/{id}", method = RequestMethod.POST)
    public ResponseEntity updateSettings(@RequestBody Settings settings, @PathVariable("id") Long uid) {
        if (userService.updateSettings(settings, uid)) {
            return ResponseEntity.status(HttpStatus.OK).body(new StringResonse("Success"));
        }
        return ResponseEntity.badRequest().body(new StringResonse("No user with such id"));
    }


    @RequestMapping(value = "/updatePhoto/{id}", method = RequestMethod.POST)
    public ResponseEntity updateUserPhoto(@RequestParam("photo") MultipartFile file, @PathVariable("id") Long uid) {
        if (userService.updateUserPhoto(uid, file)) {
            return ResponseEntity.status(HttpStatus.OK).body(new StringResonse("Success"));
        }
        return ResponseEntity.badRequest().body(new StringResonse("No user with such id"));
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserByID(@PathVariable("id") Long uid) {
        SharedUser sharedUser = userService.getUserById(uid);
        if (sharedUser != null) {
            return ResponseEntity.ok().body(sharedUser);
        }
        return ResponseEntity.badRequest().body(new StringResonse("No user with such id"));
    }

    @RequestMapping(value = "/addFriend", method = RequestMethod.POST)
    public ResponseEntity addFriendToUser(@RequestBody InteractionIncoming interactionIncoming) {
        //todo: add request friendship(Maybe)
        if (userService.addFriendToUser(interactionIncoming)) {
            return ResponseEntity.ok(new StringResonse("Success"));
        }
        return ResponseEntity.badRequest().body(new StringResonse("No user with such id or friend already added"));
    }


}
