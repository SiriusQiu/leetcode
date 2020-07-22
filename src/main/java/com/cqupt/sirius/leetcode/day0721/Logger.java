package com.cqupt.sirius.leetcode.day0721;

import java.util.HashMap;

public class Logger {
    private HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)){
            int interval = timestamp - map.get(message);
            if (interval >= 10){
                map.put(message,timestamp);
                return true;
            }else {
                return false;
            }
        }else {
            map.put(message,timestamp);
            return true;
        }
    }
}
