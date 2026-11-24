class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        // 1. Transform s: "abba" -> "#a#b#b#a#"
        // Unifies odd and even palindromes around a single center index.
        StringBuilder sb = new StringBuilder(s.length() * 2 + 1);
        sb.append('#');
        for (int idx = 0; idx < s.length(); idx++) {
            sb.append(s.charAt(idx)).append('#');
        }
        String t = sb.toString();

        int m = t.length();
        int[] p = new int[m]; // p[i] = radius of palindrome centered at i in t
        int center = 0;     // Center of the rightmost palindrome found so far
        int right = 0;      // Right boundary index of that palindrome

        int maxRadius = 0;
        int bestCenter = 0;

        for (int i = 0; i < m; i++) {
            // 2. Initialize radius using mirror symmetry if i lies within right
            if (i < right) {
                int mirror = 2 * center - i;
                // Clamp so we don't rely on symmetry past the known right boundary
                p[i] = Math.min(right - i, p[mirror]);
            }

            // 3. Expand outward around i while left and right characters match
            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < m &&
                   t.charAt(i - p[i] - 1) == t.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            // 4. Update center and right if the palindrome at i extends past right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // 5. Track the largest palindrome seen so far
            if (p[i] > maxRadius) {
                maxRadius = p[i];
                bestCenter = i;
            }
        }

        // Map center and radius in transformed string t back to original string s:
        // Start index in s is (bestCenter - maxRadius) / 2
        int start = (bestCenter - maxRadius) / 2;
        return s.substring(start, start + maxRadius);
    }
}