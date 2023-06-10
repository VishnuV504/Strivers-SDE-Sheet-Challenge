import java.util.*;
import java.io.*;

public class Solution {
    public static boolean areAnagram(String str1, String str2) {
        // Write your code here.
        int freq[] = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            int a = str1.charAt(i) - 'a';
            freq[a]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            int a = str2.charAt(i) - 'a';
            freq[a]--;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                return false;
        }
        return true;
    }
}