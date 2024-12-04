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

}