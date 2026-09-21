class Solution {

    private long makePalindrome(long prefix, int len) {
        String s = String.valueOf(prefix);
        StringBuilder sb = new StringBuilder(s);

        int start = (len % 2 == 0) ? s.length() - 1 : s.length() - 2;

        for (int i = start; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return Long.parseLong(sb.toString());
    }

    public long minOperations(int[] nums) {
        long ans = 0;

        for (int n : nums) {
            String s = String.valueOf(n);
            int len = s.length();
            int half = (len + 1) / 2;

            long prefix = Long.parseLong(s.substring(0, half));

            long base = 1;
            for (int i = 1; i < half; i++) {
                base *= 10;
            }

            long firstDigit = prefix / base;
            long best = Long.MAX_VALUE;

            for (long p = prefix - 1; p <= prefix + 1; p++) {
                if (p <= 0)
                    continue;

                long pal = makePalindrome(p, len);

                if (String.valueOf(pal).length() == len &&
                    pal % 2 == n % 2) {

                    best = Math.min(
                        best,
                        Math.abs((long)n - pal) / 2
                    );
                }
            }

            if (firstDigit % 2 != n % 2) {

                if (firstDigit > 1) {
                    long p = (firstDigit - 1) * base + (base - 1);
                    long pal = makePalindrome(p, len);

                    best = Math.min(
                        best,
                        Math.abs((long)n - pal) / 2
                    );
                }

                if (firstDigit < 9) {
                    long p = (firstDigit + 1) * base;
                    long pal = makePalindrome(p, len);

                    best = Math.min(
                        best,
                        Math.abs((long)n - pal) / 2
                    );
                }
            }

            if (len > 1) {
                int newLen = len - 1;
                long pal;

                if (n % 2 == 0) {
                    if (newLen == 1) {
                        pal = 8;
                    } else {
                        pal = 8;

                        for (int i = 0; i < newLen - 2; i++) {
                            pal = pal * 10 + 9;
                        }

                        pal = pal * 10 + 8;
                    }
                } else {
                    pal = 0;

                    for (int i = 0; i < newLen; i++) {
                        pal = pal * 10 + 9;
                    }
                }

                best = Math.min(
                    best,
                    Math.abs((long)n - pal) / 2
                );
            }

            long pal;

            if (n % 2 == 0) {
                pal = 2;

                for (int i = 0; i < len - 1; i++) {
                    pal *= 10;
                }

                pal += 2;
            } else {
                pal = 1;

                for (int i = 0; i < len; i++) {
                    pal *= 10;
                }

                pal += 1;
            }

            best = Math.min(
                best,
                Math.abs((long)n - pal) / 2
            );

            ans += best;
        }

        return ans;
    }
}