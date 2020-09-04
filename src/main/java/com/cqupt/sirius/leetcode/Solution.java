package com.cqupt.sirius.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : tickets){
            String key = list.get(0);
            if (map.containsKey(key)){
                String value = map.get(key);
                String cur = list.get(1);
                for (int i = 0; i < 3; i++){
                    int compare = value.charAt(i) - cur.charAt(i);
                    if (compare==0) continue;
                    else if (compare < 0) break;
                    else {
                        value = cur;
                        break;
                    }
                }
                map.put(key,value);
            }else {
                map.put(key, list.get(1));
            }
        }
        List<String> result = new ArrayList<>();
        String next = "JFK";
        do {
            result.add(next);
            next = map.get(next);
        }while (next!=null&&!next.equals("JFK"));
        return result;
    }
}
