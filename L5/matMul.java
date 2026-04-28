import java.util.*;

public class MCM {
    public static int matrixChain(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                            + arr[i - 1] * arr[k] * arr[j];

                    if (cost < dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {12, 6, 4, 9, 20, 50, 8, 5, 30, 10};
        System.out.println("Minimum cost: " + matrixChain(arr));
    }
}