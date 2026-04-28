import java.util.* ;

public class Main {
    public static int mcm( int[] arr ){
        int n  = arr.length ;
        int[][] dp = new int [n][n];
        int len , i , j , k ;
        
        for( len = 2 ; len < n ; len++){
            for ( i = 1 ; i < n-len+1 ; i++){
                j = len+i-1;
                dp[i][j] = Integer.MAX_VALUE ;
                for ( k = i ; k<j ; k++){
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[j]*arr[k];
                    if ( cost < dp[i][j]) dp[i][j] = cost ;
                }
            }
        }
        
        return dp[1][n-1];
    }
    
    public static void main( String[] args ){
        int[] arr = { 4,5,7,8,9,6,3,2,12,4,9};
        
        System.out.println("Minimum no. of multiplication is :- " 
                            + mcm(arr));
    }
    
}