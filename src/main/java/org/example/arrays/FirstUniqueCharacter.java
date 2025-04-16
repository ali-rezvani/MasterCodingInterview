package org.example.arrays;

/*
    Given a string s, return the index of the first non-repeating character.
    If there is no such character, return -1.
*/

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("hjcgfjg"));
    }

    public static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }

        return -1;
    }
}
