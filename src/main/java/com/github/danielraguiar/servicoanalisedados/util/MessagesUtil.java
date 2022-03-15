package com.github.danielraguiar.servicoanalisedados.util;


import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessagesUtil {

    public static String getMessage(String key, Object params){
        ResourceBundle bundle = ResourceBundle.getBundle("messages");
        return MessageFormat.format(bundle.getString(key), params);
    }

}
