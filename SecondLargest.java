//Find the second largest element

import java.util.Arrays;

public class SecondLargest {
    // ANSI Colors
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    // Implement this function
    public static int solve(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int max=Integer.MIN_VALUE;
        int secmax=Integer.MIN_VALUE;
        for (int n : nums) {

    if (n > max) {
        secmax = max;
        max = n;
    } else if (n > secmax && n != max) {
        secmax = n;
    }
}
        return secmax == Integer.MIN_VALUE ? -1 : secmax;
    }

    public static void runTest(int[] nums, int expected) {

        int result = solve(nums);

        System.out.println("Input    : " + Arrays.toString(nums));
        System.out.println("Output   : " + result);
        System.out.println("Expected : " + expected);

        if (result == expected) {
            System.out.println(GREEN + "✅ PASS" + RESET);
        } else {
            System.out.println(RED + "❌ FAIL" + RESET);
        }

        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {

        runTest(new int[]{12, 35, 1, 10, 34, 1}, 34);

        runTest(new int[]{10, 5, 10}, 5);

        runTest(new int[]{5, 5, 5}, -1);

        runTest(new int[]{1}, -1);

        runTest(new int[]{9, 8, 7, 6}, 8);

        runTest(new int[]{100, 200, 300, 400}, 300);

        runTest(new int[]{2, 1}, 1);
    }

}
