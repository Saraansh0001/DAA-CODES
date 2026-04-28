public class selectionSort {

  public static void main(String[] args) {
    
    int[] arr = {64, 25, 12, 22, 11};
    int n = arr.length;
    for ( int i = 0 ; i < n ; i++){
      int minIndex = i ;
      for ( int  j = i+1 ; j < n ; j ++){
        if ( arr[j] < arr[minIndex]){
          minIndex = j ;
        }
      }
      int temp = arr[i] ;
      arr[i] = arr[minIndex] ;
      arr[minIndex] = temp ;
    }

    System.out.println("Sorted array: ");
    for ( int i = 0 ; i < n ; i++){
      System.out.print(arr[i] + " ");
    }

  }
  
}
// shortest ko pick krke first me rakhna hai