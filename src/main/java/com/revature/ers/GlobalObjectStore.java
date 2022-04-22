package com.revature.ers;

import java.util.HashMap;
import java.util.Map;

//store username so user don't have to type in their username everytime they need to verify their identity

//still need work use p1-ui-assist/src/main/java/com/revature/GlobalObjectStore.java as reference
public class GlobalObjectStore {


    private Map<String, Object> globalStore;

    private GlobalObjectStore() {
        //private constructor -
        // use getStore();
    }

    public Map<String, Object> getStore() {
        if (globalStore == null) {
            globalStore = new HashMap<String, Object>();
        }

        return globalStore;
    }


    //potentially where could go wrong on storing the username
    public void add(String username, Object obj) {
        globalStore.put(username, obj);
    }

    public static Object getObject(String username) {
        return GlobalObjectStore.getObject(username);
    }
}


