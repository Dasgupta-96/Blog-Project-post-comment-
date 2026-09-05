package com.Project.post_comment;

public class MoveZeroes {

  public static void main(String[] args) {

    int [] nums = {1,2,0,4,0,6,0}; //1,2,4,0,0,6,0
    int j = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        j++;
      }
    }
    for (int e : nums) {
      System.out.print(e);

    }

//    List<Integer> list = Stream.concat(Arrays.stream(x).boxed().filter(a -> a != 0),
//      Arrays.stream(x).boxed().filter(b -> b == 0)).toList();
//
//    System.out.println(list);
//
//    List<Integer> temp = new ArrayList<>();
//
//    for (int i =0; i<x.length; i++) {
//
//      if (x[i] !=0) {
//        temp.add(x[i]);
//      }
//    }
//    for (int i =0; i<temp.size(); i++) {
//      x[i] = temp.get(i);
//    }
//    for (int i = temp.size(); i< x.length; i++) {
//      x[i] = 0;
//    }
//
//    for (int i =0; i< x.length; i++) {
//      System.out.print(x[i] + " ");
//    }

  }

}
