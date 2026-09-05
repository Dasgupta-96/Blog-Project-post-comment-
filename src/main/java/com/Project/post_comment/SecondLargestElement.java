package com.Project.post_comment;


public class SecondLargestElement {
  public static void main(String[] args) {

    int[] x = {3, 2, 1, 5, 9, 4,8};
//    Arrays.sort(x);
//    int largestElement = Integer.MIN_VALUE;
//
//    for (int i =0; i<x.length; i++){
//
//      if(x[i] > largestElement){
//
//        largestElement = x[i];
//      }
//    }
    // brute force with sorted: nlogn + O(n)
//    for (int i = x.length-2; i>=0 ; i--){ // 1,2,3,4,5,9
//
//      if(x[i] != maxElement){
//
//        System.out.println("2nd max element is: "+x[i]);
//        break;
//      }
//    }
    // better approach as we are not sorted O(2n)
//    int secondLargest = Integer.MIN_VALUE; // ex : -1
//    for (int  i = 0; i< x.length; i++){ // 3,2,1,5,9,4
//
//      if(x[i] > secondLargest && x[i] != largestElement){
//
//        secondLargest = x[i];
//      }
//    }
//    System.out.println("Second largest element is: "+secondLargest);

    // Optimal solution // 3, 2, 1, 5, 9, 4
    int largest = x[0];
    int secondLargest = -1;

    for (int i = 1; i < x.length; i++) {

      if (x[i] > largest) {
        secondLargest = largest;
        largest = x[i];
      } else if (x[i] < largest && x[i] > secondLargest) {

        secondLargest = x[i];
      }

    }
    System.out.println("Second largest is : " + secondLargest);

  }
}
