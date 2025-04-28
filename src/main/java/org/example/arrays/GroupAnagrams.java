package org.example.arrays;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Two strings are anagrams if they contain the same characters in different orders.
*/
public class GroupAnagrams {

    public static void main(String[] args) {
        var list= Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        var result = groupAnagrams(list);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(List<String> strs) {
        // HashMap to store the sorted string as the key and list of anagrams as the value
        Map<String, List<String>> map = new Hashtable<>();

        // Iterate through each string in the input array
        for (String str : strs) {
            // Convert the string into a character array, sort it and convert back to a string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // If the sorted string is already a key in the HashMap, add the current string to the list
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                // If not, create a new list and add the current string to it
                List<String> anagramList = new ArrayList<>();
                anagramList.add(str);
                map.put(sortedStr, anagramList);
            }
        }

        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }

}
