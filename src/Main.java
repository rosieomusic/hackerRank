import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


}

}

