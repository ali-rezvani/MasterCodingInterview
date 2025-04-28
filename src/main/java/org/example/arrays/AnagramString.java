package org.example.arrays;
/*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An anagram is a word or phrase formed by rearranging the letters of another, such as "listen" and "silent".
*/

public class AnagramString {
    public static void main(String[] args) {
        String s1 = "asbasomp";
        String s2 = "aasspobm";

//        bruteAnagram(s1,s2);
        optimizedAnagram(s1,s2);
    }

    private static void optimizedAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            System.out.println(s2 + " is not anagram of " + s1);
            return;
        }

        int[] charCounts = new int[26]; // 26 letters in the English alphabet

       for (int i = 0; i < s1.length(); i++) {
            charCounts[s1.charAt(i) - 'a']++;  // Increase count for s1
            charCounts[s2.charAt(i) - 'a']--;  // Decrease count for s2
        }

        for (int count : charCounts) {
            if (count != 0) {
                System.out.println(s2 + " is not anagram of " + s1);
                return;
            }
        }

        System.out.println(s2 + " is anagram of " + s1);
    }


    private static void bruteAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            System.out.println(s2 + " is not anagram of " + s1);
            return;
        }
        for (int i = 0; i < s1.length(); i++) {
            var ch = s1.charAt(i);
            var findChar=Boolean.FALSE;
            var idexes=new boolean[s1.length()];
            for (int j = 0; j < s2.length(); j++) {
                if (ch == s2.charAt(j)&&idexes[j]==false) {
                    findChar = Boolean.TRUE;
                    idexes[j] = true;
                }
            }
            if (findChar == Boolean.FALSE) {
                System.out.println(s2 + " is not anagram of " + s1);
                return;
            }
        }
        System.out.println(s2 + " is anagram of " + s1);
    }

}
