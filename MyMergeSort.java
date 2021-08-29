
public class MyMergeSort {
  
  
  public static void main(String[] args) {
    
    // build test array to sort
    int[] list = new int[100000];
    int n = list.length;
    for (int i = 0; i < n; i++) {
      list[i] = (int)(Math.random() * 1000000);
    }
    
    // sort test array
    long startTime = System.nanoTime();
    mergeSort(list, 0, list.length - 1);
    long endTime = System.nanoTime();
    double totalTime = (endTime - startTime) / 1000000000.0;
    printList(list);
    System.out.println("MergeSort complete in " + totalTime + " seconds");
    
  }
  
  // public mergeSort() method
  public static void mergeSort(int[] arr, int first, int last) {
    
    int[] temp = new int[arr.length];
    mergeSort(arr, temp, first, last);
  }
  
  // private mergeSort() method with int[] temp
  private static void mergeSort(int[] arr, int[] temp, int first, int last) {
    if (first < last) { // base case - end recursion when first >= last
      int mid = first + (last - first)/ 2; // find mid index
    
      mergeSort(arr, temp, first, mid); // recursively sort right half
      mergeSort(arr, temp, mid + 1, last); // recursively sort left half
    
      merge(arr, temp, first, mid, last); // merge halves in ascending order
    }
  }
  
  // utility method to print array in rows of 10
  public static void printList(int[] list) {
    int n = list.length;
    for (int i = 0; i < n; i++) {
      if ((i + 1) % 10 == 0)
       System.out.println(list[i]);
      else
        System.out.print(list[i] + " ");
    }
  }
  
  // method to combine sub arrays in ascending order
  public static void merge(int[] arr, int[] temp, int first, int mid, int last) {
    
    // set index for left half
    int leftIndex = first;
    int leftLast = mid;
    // set index for right half
    int rightIndex = mid + 1;
    int rightLast = last;
    // set index for temp
    int tempIndex = 0;
    
    // fill temp from left and right halves in ascending order
    while (leftIndex <= leftLast && rightIndex <= rightLast) { // while both halves have remaining entries
      if (arr[leftIndex] <= arr[rightIndex]) { 
        temp[tempIndex] = arr[leftIndex];
        leftIndex++;
      }
      else {
        temp[tempIndex] = arr[rightIndex];
        rightIndex++;
      }
      tempIndex++;
    }
    
    while (leftIndex <= leftLast) { // left half has remaining entries
      temp[tempIndex] = arr[leftIndex];
      leftIndex++;
      tempIndex++;
    }
    
    while (rightIndex <= rightLast) { // right half has remaining entries
      temp[tempIndex] = arr[rightIndex];
      rightIndex++;
      tempIndex++;
    }
    
    // copy temp into arr
    for (int i = 0; i <= last - first; i++)
      arr[first + i] = temp[i];
  }
  
}