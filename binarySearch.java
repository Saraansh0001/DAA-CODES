import java.util.* ;

public class binarySearch {
  
  public static void main(String[] args) {
    int[] arr = { 1,2,3,4,5,6,7 ,8,9,10}; 

    int target =  11;

    int found = -1;

    int low = 0 , high = arr.length - 1;

    while ( low < high ){
      int mid = low + (high - low) / 2;

      if ( arr[mid] == target){
        found = mid ;
        break;
      }
      else if ( arr[mid] < target){
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    if (found != -1) {
      System.out.println("Element found at index: " + found);
    } else {
      System.out.println("Element not found");
    }
  }

}
