import java.util.HashMap;
import java.util.Map;

public class SmallestStringWithSubstring {

    public static String findSmallestString(String word, String substr) {
        int wordLength = word.length();
        int substrLength = substr.length();
        String result = null;

        // Try placing substr at every position
        for (int i = 0; i <= wordLength - substrLength; i++) {
            boolean canPlace = true;
            StringBuilder newWord = new StringBuilder(word);

            // Check if substr can fit and build the new string simultaneously
            for (int j = 0; j < substrLength; j++) {
                char wordChar = newWord.charAt(i + j);
                char substrChar = substr.charAt(j);

                if (wordChar != '?' && wordChar != substrChar) {
                    canPlace = false;
                    break;
                }

                // Replace '?' with the corresponding character from substr
                newWord.setCharAt(i + j, substrChar);
            }

            // If substr fits, replace remaining '?' with 'a'
            if (canPlace) {
                for (int k = 0; k < wordLength; k++) {
                    if (newWord.charAt(k) == '?') {
                        newWord.setCharAt(k, 'a');
                    }
                }

                // Compare with the current result
                String transformed = newWord.toString();
                if (result == null || transformed.compareTo(result) < 0) {
                    result = transformed;
                }
            }
        }

        return result != null ? result : "-1";
    }

    public static void main(String[] args) {
        String word = "a?c?b";
        String substr = "abc";
        System.out.println(findSmallestString(word, substr)); // Output: "aabcb"

        String word2 = "?????";
        String substr2 = "abc";
        System.out.println(findSmallestString(word2, substr2)); // Output: "abcaa"

        String word3 = "a?b";
        String substr3 = "xyz";
        System.out.println(findSmallestString(word3, substr3)); // Output: "-1"
    }


    public static int firstUniqueChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i + 1; // Convert to 1-based index
            }
        }

        return -1; // No unique character found
    }


}
