package com.ttt.datautilities;

import com.ttt.enums.DriverType;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public final class ConfigDataManager {

    private ConfigDataManager(){

    }

    private static final Properties configProperties = new Properties();
    private static Hashtable<String,String> propertiesHashTbl = new Hashtable<>();

     static {
        try(InputStream fis = ConfigDataManager.class.getClassLoader().getResourceAsStream("config.properties")){
             configProperties.load(fis);
             for(Map.Entry<Object,Object> map: configProperties.entrySet()){
                 propertiesHashTbl.put(map.getKey().toString(),map.getValue().toString());
             }
        }catch(IOException ex){
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public static DriverType getBrowser(){

       return DriverType.valueOf(propertiesHashTbl.get("Browser").toUpperCase());
    }

    public static String getAppUrl(){

        return propertiesHashTbl.get("AppUrl");
    }

    public static long getGlobalWaitTime(){
        return Long.valueOf(propertiesHashTbl.get("GlobalWaitTime"));
    }
    public static String getAppUserName(){
        return propertiesHashTbl.get("AppUserName");
    }
    public static String getAppPassword(){
        return propertiesHashTbl.get("AppPassword");
    }



}
