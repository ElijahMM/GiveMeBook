package com.mihai.licenta.Models.InternModels;

import java.util.List;

/**
 * Created by mihai on 15.05.2017.
 */
public class RegisterUser {
    String username;
    String email;
    String password;
    String photoUrl;
    String fbID;
    List<RegPref> preferences;
}
