package com.mihai.licenta.Utils;

import java.sql.Date;

/**
 * Created by mihai on 16.05.2017.
 */
public class Util {

    public static Date getSqlDate() {
        java.util.Date date = new java.util.Date();
        return new Date(date.getTime());
    }
}
