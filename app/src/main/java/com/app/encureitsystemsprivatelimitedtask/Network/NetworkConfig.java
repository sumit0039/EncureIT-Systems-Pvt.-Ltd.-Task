package com.app.encureitsystemsprivatelimitedtask.Network;

public class NetworkConfig {

    private static String _ENV  = "DEV"; // DEV / PRODUCTION

    public static String GET_BASE_URL(){
        if(_ENV.equals("PRODUCTION"))
            return _BASE_URL_PROD;
        else
            return _BASE_URL_DEV;
    }

    //Production Url
    public static String _BASE_URL_PROD="https://machinetest.encureit.com";
    //Development Url
    public static String _BASE_URL_DEV="https://machinetest.encureit.com";



}
