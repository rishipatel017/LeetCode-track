class Solution {
    public boolean isSubsequence(String s, String t) {
             // Edge cases
        if (s == null || s.isEmpty()) {
            return true;
        }

        if (t == null || t.isEmpty()) {
            return false;
        }

        // Optional: if s is longer, it cannot be a subsequence
        if (s.length() > t.length()) {
            return false;
        }

        int i = 0, j = 0;

        while (j < t.length() && i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

      