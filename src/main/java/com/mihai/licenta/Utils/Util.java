package com.mihai.licenta.Utils;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by mihai on 16.05.2017.
 */
public class Util {

    public static Date getSqlDate() {
        return new Date(Calendar.getInstance().getTimeInMillis());
    }
}
