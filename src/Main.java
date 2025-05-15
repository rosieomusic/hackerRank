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
        String amPM = s.substring(s.length() - 2);
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

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
    //Check if each number has a matching reverse number in the list
    public List<int[]> solution(List<Integer> numbers) {
        // TODO: implement solution here
        List<int[]> result = new ArrayList<>();
        for (int num : numbers){
            int reversedNum = reverse(num);
            if(numbers.contains(reversedNum)){
                result.add(new int[] {num, reversedNum});
            }

        }
        return result;
    }
    private int reverse(int n){
        int revNum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            revNum = revNum * 10 + lastDigit;
            n /= 10;
        }
        return revNum;
    }

    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        // Add only positive integers to the set
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }

        // Start checking from 1 upwards to find the smallest missing positive integer
        int smallest = 1;
        while (set.contains(smallest)) {
            smallest++;
        }

        return smallest;
    }

    public int solution(int n) {
        int digitProduct = 1;
        boolean hasOddDigits = false;
        // TODO: implement
        while(n > 0){
            int digit = n % 10;
            if(digit % 2 != 0){
                digitProduct *=digit;
                hasOddDigits = true;
            }
            n/=10;
        }
        if(hasOddDigits){
            return 0;
        }
        return digitProduct;
    }

    public int result(int n) {
        // TODO: implement the solution here
        int digit = 0;
        int revNum = 0;
        int multiplier = 10;
        while (n > 0) {
            digit = n % 10;
            revNum*=multiplier;
            revNum+=digit;
            n/=10;

        }
        return revNum; // Placeholder return
    }
    public List<String> paring(List<Integer> numbers) {
        // TODO: Implement the function to pair the elements from the middle to ends of the array
        ArrayList<String> result = new ArrayList<>();
        int mid = numbers.size() / 2;
        int left,right;
        if(numbers.size() % 2 == 1){
            result.add(numbers.get(mid) + " " + "0");
            left = mid - 1;
            right = mid + 1;
        } else{
            left = mid - 1;
            right = mid;
        }
        while(left >=0 && right < numbers.size()){
            result.add(numbers.get(left--) + " " + numbers.get(right++));

        }

        return result;
    }
    public List<Integer> unusualTraversal(int[] array) {
        // TODO: implement this function
        ArrayList<Integer> insaneArray = new ArrayList<>();
        int mid = array.length / 2;
        int left = mid - 1;
        int right = mid + 1;
        insaneArray.add(array[mid]);

        while(left >= 0 || right < array.length){
            if(left >= 1){
                insaneArray.add(array[left - 1]);
                insaneArray.add(array[left]);
                left-=2;
            }else if(left == 0){
                insaneArray.add(array[left]);
                left--;
            }
            if(right < array.length-1){
                insaneArray.add(array[right]);
                insaneArray.add(array[right + 1]);
                right+=2;
            }else if (right == array.length-1){
                insaneArray.add(array[right]);
                right++;
            }

        }
        return insaneArray;
    }
    // returning a group count of chars in reverse order
    public List<String> solution(String s) {
        // TODO: implement the algorithm to find consecutive groups of characters in the reverse order
        List<String> result = new ArrayList<>();
        char currentGroupChar = '\0';
        int currentGroupLength = 0;
        int i = s.length()-1;

        while(i >= 0){
            char c = s.charAt(i--);
            if(currentGroupChar == c){
                currentGroupLength +=1;
            }else{
                if(currentGroupChar != '\0'){
                    result.add(currentGroupChar + " " + currentGroupLength);
                }
                currentGroupChar = c;
                currentGroupLength = 1;
            }


        }
        if(currentGroupChar != '\0'){
            result.add(currentGroupChar + " " + currentGroupLength);
        }
        return result;
    }
    public String reversedTripleChars(String s) {
        // TODO: Implement the function that reforms the string as described above
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i+=3) {
            int end = Math.min(i + 3, n);
            String segment = s.substring(i,end);
            if(segment.length() == 3){
                result.append(new StringBuilder(segment).reverse());
            } else {
                result.append(segment);
            }
        }
        return result.toString();
    }



}




