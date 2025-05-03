package org.example.arrays;

import java.util.HashMap;
import java.util.HashSet;

/*
    Given a string, you need to find the length of the longest substring
    that does not contain any repeating characters.
*/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        var str="abcabcbb";
        System.out.println(longestSubstrByHashSet(str));
    }

    private static int longestSubstrByHashSet(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0; // Left pointer
        int maxLength = 0; // To track the maximum length of substring

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, move the left pointer
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left)); // Remove the left character from the set
                left++; // Shrink the window from the left
            }
            // Add the current character to the set
            set.add(s.charAt(right));

            // Calculate the current window length and update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int longestSubstrByHashMap(String s) {
        // HashMap to store the most recent index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0; // Left pointer
        int maxLength = 0; // To track the maximum length of substring

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the map and its index is greater than or equal to left pointer
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left) {
                // Move the left pointer to the next position after the last occurrence of the character
                left = map.get(s.charAt(right)) + 1;
            }

            // Update the most recent index of the character in the map
            map.put(s.charAt(right), right);

            // Calculate the current window length and update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
