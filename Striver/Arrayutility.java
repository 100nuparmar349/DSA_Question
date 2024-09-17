import java.util.Scanner;

public class Arrayutility {

    // Function to input an array of integers
    public static int[] inputArray() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt(); // Input size of the array
        int[] num = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt(); // Input array elements
        }

        return num;
    }
}
