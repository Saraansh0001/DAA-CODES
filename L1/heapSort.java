package L1;

import java.util.*;

public class HeapSort {

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l < n && arr[l] > arr[largest])
            largest = l;

        if(r < n && arr[r] > arr[largest])
            largest = r;

        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1 , 2, 98 , 56 ,23 ,45, 78 ,4,2 666};

        int n = arr.length ;

        for ( int i = n/2-1 ; i>= 0 ; i++) heapify( arr , n , i);

        for ( int i = n-1 ; i >0 ; i --){
          int temp = arr[0];
          arr[0] = arr[i] ;
          arr[i] = temp ;

          heapify ( arr , i , 0);
        }

        System.out.println("Sorted  array is as follows :- ");

        for( int i = 0 ; i < n ; i ++) System.out.print(arr[i] + " ");

    }
}