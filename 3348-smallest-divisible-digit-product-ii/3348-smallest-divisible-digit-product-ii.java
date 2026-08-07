import java.util.*;

class Solution {

    static final int[][] FACTOR = {
            {0,0,0,0}, //0
            {0,0,0,0}, //1
            {1,0,0,0}, //2
            {0,1,0,0}, //3
            {2,0,0,0}, //4
            {0,0,1,0}, //5
            {1,1,0,0}, //6
            {0,0,0,1}, //7
            {3,0,0,0}, //8
            {0,2,0,0}  //9
    };

    public String smallestNumber(String num, long t) {

        int[] need = factorize(t);
        if (need == null) return "-1";

        int n = num.length();

        int[][] suffix = new int[n + 1][4];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1].clone();
            int d = num.charAt(i) - '0';
            for (int j = 0; j < 4; j++)
                suffix[i][j] += FACTOR[d][j];
        }

        boolean hasZero = false;
        for (char c : num.toCharArray())
            if (c == '0')
                hasZero = true;

        if (!hasZero && covers(suffix[0], need))
            return num;

        int[] prefix = new int[4];

        for (int i = 0; i < n; i++) {

            int cur = num.charAt(i) - '0';

            if (cur == 0) break;

            int[] remainPrefix = prefix.clone();

            int[] suffixWithout = suffix[i + 1];

            for (int nxt = cur + 1; nxt <= 9; nxt++) {

                int[] have = new int[4];

                for (int j = 0; j < 4; j++)
                    have[j] = remainPrefix[j] + FACTOR[nxt][j];

                int[] rem = new int[4];

                for (int j = 0; j < 4; j++)
                    rem[j] = Math.max(0, need[j] - have[j]);

                int len = n - i - 1;

                String tail = build(rem, len);

                if (tail != null) {
                    return num.substring(0, i) + nxt + tail;
                }
            }

            for (int j = 0; j < 4; j++)
                prefix[j] += FACTOR[cur][j];
        }

        int len = n + 1;

        while (true) {
            String tail = build(need, len);
            if (tail != null)
                return tail;
            len++;
        }
    }

    private int[] factorize(long t) {

        int[] need = new int[4];

        while (t % 2 == 0) {
            need[0]++;
            t /= 2;
        }

        while (t % 3 == 0) {
            need[1]++;
            t /= 3;
        }

        while (t % 5 == 0) {
            need[2]++;
            t /= 5;
        }

        while (t % 7 == 0) {
            need[3]++;
            t /= 7;
        }

        if (t != 1)
            return null;

        return need;
    }

    private boolean covers(int[] have, int[] need) {
        for (int i = 0; i < 4; i++)
            if (have[i] < need[i])
                return false;
        return true;
    }

    private String build(int[] need, int len) {

        List<Integer> digits = new ArrayList<>();

        while (need[0] >= 3) {
            digits.add(8);
            need[0] -= 3;
        }

        while (need[1] >= 2) {
            digits.add(9);
            need[1] -= 2;
        }

        while (need[0] > 0 && need[1] > 0) {
            digits.add(6);
            need[0]--;
            need[1]--;
        }

        while (need[0] >= 2) {
            digits.add(4);
            need[0] -= 2;
        }

        while (need[2] > 0) {
            digits.add(5);
            need[2]--;
        }

        while (need[3] > 0) {
            digits.add(7);
            need[3]--;
        }

        while (need[0] > 0) {
            digits.add(2);
            need[0]--;
        }

        while (need[1] > 0) {
            digits.add(3);
            need[1]--;
        }

        if (digits.size() > len)
            return null;

        while (digits.size() < len)
            digits.add(1);

        Collections.sort(digits);

        StringBuilder sb = new StringBuilder();

        for (int d : digits)
            sb.append(d);

        return sb.toString();
    }
}