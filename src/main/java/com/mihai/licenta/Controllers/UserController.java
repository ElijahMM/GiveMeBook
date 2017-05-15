package com.mihai.licenta.Controllers;

import com.mihai.licenta.Models.InternModels.RegisterUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mihai on 15.05.2017.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ResponseEntity registerUser(RegisterUser user) {
        return null;
    }
}
