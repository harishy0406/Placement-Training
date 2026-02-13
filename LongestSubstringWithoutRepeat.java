import java.util.*;

public class LongestSubstringWithoutRepeat {

    public static int lengthOfLongestSubstring(String s) {

        // Set to store characters in current window
        Set<Character> set = new HashSet<>();

        int left = 0;      // Left pointer of window
        int maxLen = 0;    // Stores maximum length found

        // Right pointer moves forward
        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);

            // If character already exists in set,
            // remove characters from left until duplicate is removed
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to set
            set.add(currentChar);

            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        int result = lengthOfLongestSubstring(s);

        System.out.println("Length of Longest Substring Without Repeating Characters: " + result);
    }
}
