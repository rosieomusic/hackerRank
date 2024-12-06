import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void plusMinus(List<Integer> arr) {
        int positives = 0;
        int negatives = 0;
        int zeros = 0;
        int n = arr.size();

        // Count positives, negatives, and zeros
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > 0) {
                positives++;
            } else if (arr.get(i) < 0) {
                negatives++;
            } else {
                zeros++;
            }
        }

        // Calculate and print the proportions to 6 decimal places
        System.out.printf("%.6f%n", (double) positives / n);
        System.out.printf("%.6f%n", (double) negatives / n);
        System.out.printf("%.6f%n", (double) zeros / n);
    }
    public static int simpleArraySum(List<Integer> ar) {
        int total = 0;
        for (int i = 0; i < ar.size(); i++) {
            total += ar.get(i); // Add the actual array element
        }
        return total;
    }
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < 3; i++) {
            if(a.get(i) > b.get(i)){
                alice++;
            } else if (a.get(i) < b.get(i)){
                bob++;
            }


        }
        List<Integer> result = new ArrayList<>();
        result.add(alice);
        result.add(bob);

        return result;

    }
    public static void miniMaxSum(List<Integer> arr) {

        // Write your code here
        Collections.sort(arr);
        long minSum = 0;
        for (int i = 0; i < 4; i++) {
            minSum += arr.get(i);
        }
        long maxSum = 0;
        for (int i = 1; i < 5; i++) {
            maxSum += arr.get(i);

        }
        System.out.println(minSum + " " + maxSum);


    }
    public static String timeConversion(String s) {
        // Write your code here
        String amPM = s.substring(s.length() -2 );
        String hour = s.substring(0, 2);
        String minuteSecond = s.substring(2,  s.length() - 2);

        int hourInt = Integer.parseInt(hour);
        if(amPM.equals("AM")){
            if(hourInt == 12) {
                hour = "00";
            }
        } else{
            if(hourInt != 12){
                hour = String.format("%02d", hourInt + 12);
            }
        }

        return hour + minuteSecond;

    }

}
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

