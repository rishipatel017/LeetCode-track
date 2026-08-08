// LeetCode 28 - Find the Index of the First Occurrence in a String

public class FindFirstOccurrence {

    // ANSI Colors
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    // Implement this function
    public static int solve(String haystack, String needle) {

        // Write your code here

        return -1;
    }

    public static void runTest(String haystack, String needle, int expected) {

        int result = solve(haystack, needle);

        System.out.println("Haystack : \"" + haystack + "\"");
        System.out.println("Needle   : \"" + needle + "\"");
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

        // LeetCode Examples
        runTest("sadbutsad", "sad", 0);
        runTest("leetcode", "leeto", -1);

        // Additional Test Cases
        runTest("hello", "ll", 2);
        runTest("aaaaa", "bba", -1);
        runTest("mississippi", "issip", 4);
        runTest("abc", "abc", 0);
        runTest("abc", "c", 2);
        runTest("abc", "d", -1);
        runTest("aaaa", "aa", 0);
        runTest("abababab", "bab", 1);
        runTest("a", "a", 0);
        runTest("abcde", "e", 4);
    }
}