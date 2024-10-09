import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /* Solution solution = new Solution();
        int count = solution.mySolution("noorulhassanmohamed");
        System.out.println("The unique count of the characters is: " + count);*/

        Solution solution = new Solution();
        String s = "noorul hassan mohamed";
        String result = solution.mySolution1(s);

        System.out.println("The longest substring without repeating characters is: " + result);

        // Convert to a list of non-repeating characters
        System.out.println("Non-repeating characters: " + result.chars().mapToObj(c -> (char) c).toList());

    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Initialize the set to store characters and two pointers
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        // Iterate over the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, move the left pointer to the right
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the set
            set.add(s.charAt(right));
            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringWithNonRepetitive(String s) {
        // HashMap to store the index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        // Initialize the left pointer
        int left = 0;

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map, update the left pointer
            if (map.containsKey(currentChar)) {
                // Move left pointer to the right of the last occurrence of the current character
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Add the current character to the map with its index
            map.put(currentChar, right);

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int mySolution(String s) {
        HashSet<Character> sb = new HashSet<>();
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            sb.remove(currentChar);
            sb.add(currentChar);
            maxLength = Math.max(maxLength, sb.size());
        }
        System.out.println(sb);
        return maxLength;
    }

    public int anotherSolution(String s) {
        // HashMap to store the index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        // Initialize the left pointer
        int left = 0;

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map, update the left pointer
            if (map.containsKey(currentChar)) {
                // Move left pointer to the right of the last occurrence of the current character
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Add the current character to the map with its index
            map.put(currentChar, right);

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public String mySolution1(String s) {
        // HashMap to store the index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int start = 0;  // To track the start of the longest non-repeating substring

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // If the character is already in the map, update the left pointer
            if (map.containsKey(currentChar)) {
                // Move left pointer to the right of the last occurrence of the current character
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Add the current character to the map with its index
            map.put(currentChar, right);

            // Update the maximum length and track the start of the longest substring
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;  // Update the start of the longest substring
            }
        }
        // Extract the longest substring

        // Collect all the non-repeating characters in the order they appear in the longest substring
        return s.substring(start, start + maxLength);
    }
}