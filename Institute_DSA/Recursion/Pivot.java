import java.util.Scanner;

public class Pivot {
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];  // Choosing the last element as pivot
        int i = start - 1;     // Pointer for the smaller element
        for (int j = start; j < end; j++) {  // Iterate from start to end-1
            if (arr[j] < pivot) {
                i++;  // Increment index of smaller element
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap the pivot element with the element at i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1; // Return the partitioning index
    }

    public static void Quicksort(int[] arr, int start, int end) {
        if (start < end) { // Fixing the base condition
            int pivotIndex = partition(arr, start, end);
            Quicksort(arr, start, pivotIndex - 1); // Recursively sort the left part
            Quicksort(arr, pivotIndex + 1, end);   // Recursively sort the right part
        }
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Quicksort(arr, 0, n - 1);
        System.out.println("Sorted array:");
        print(arr);
        sc.close(); // Close the scanner
    }
}
