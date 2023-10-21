package com.makefriends.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shenhufei
 * @description: TODO
 * @date 2023年10月21日
 * @version: 1.0
 */
public class DateUtils {
    private  static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public   static String getCurrentDate(){
       return    DATE_FORMAT.format(new Date());
    }
}
