import java.util.*;

class solution{
    public static void main( String[] args ){
        
        int[] arr = { 11 , 56 , 89, 7891 , 56 , 45
        , 74 , 86976  , 86 };
        
        int n = arr.length ;
        
        for ( int i = 0 ; i < n ; i++){
            int minIndex = i;
            for ( int j = i+1 ; j<n ; j ++){
                if ( arr[j] < arr[minIndex]){
                    minIndex  = j ;
                }
            }
            
            int temp = arr[i];
            arr[i]=  arr[minIndex] ;
            arr[minIndex] = temp ;
        }
        
        System.out.println("Sorted array: ");
        
        for ( int i = 0 ; i < n ; i++){
          System.out.print(arr[i] + " ");
        }
    
    }
}