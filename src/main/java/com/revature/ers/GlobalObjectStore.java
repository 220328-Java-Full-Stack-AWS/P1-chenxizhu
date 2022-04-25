package com.revature.ers;

import com.revature.ers.repositories.UserDAO;

import java.util.HashMap;
import java.util.Map;

//store username so user don't have to type in their username everytime they need to verify their identity

//still need work use p1-ui-assist/src/main/java/com/revature/GlobalObjectStore.java as reference
public class GlobalObjectStore {


    private static final Map<String, Object> globalStore = new HashMap<String, Object>();

    private GlobalObjectStore() {
        //private constructor -
        // use getStore();
        //no need to build an object. Why?
    }


    /*
    public Map<String, Object> getStore() {
        if (globalStore == null) {
            globalStore = new HashMap<String, Object>();
        }

        return globalStore;
    }
*/

    //potentially where could go wrong on storing the username
    public static void addObject(String name, Object obj) {
        globalStore.put(name, obj);
    }

    public static Object getObject(String name) {
        //return GlobalObjectStore.getObject(name);
        UserDAO userdao = new UserDAO();
        return globalStore.get(userdao.getUserByUserName(name));
    }

    public static void removeObject(String name) {
        Object obj = globalStore.remove(name);
        System.out.println("Object removed: " + obj);
    }
}


