class Solution {

    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // prefix count of non-zero digits
        int[] prefixCount = new int[n + 1];

        // collect non-zero digits
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            prefixCount[i + 1] = prefixCount[i];

            if (ch != '0') {
                digits.add(ch - '0');
                prefixCount[i + 1]++;
            }
        }

        int m = digits.size();

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefixValue = new long[m + 1];
        int[] prefixSum = new int[m + 1];

        for (int i = 0; i < m; i++) {
            int d = digits.get(i);

            prefixValue[i + 1] = (prefixValue[i] * 10 + d) % MOD;
            prefixSum[i + 1] = prefixSum[i] + d;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int left = prefixCount[l];
            int right = prefixCount[r + 1];

            int len = right - left;

            int sum = prefixSum[right] - prefixSum[left];

            long x = prefixValue[right]
                    - (prefixValue[left] * pow10[len]) % MOD;

            x %= MOD;
            if (x < 0) x += MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}