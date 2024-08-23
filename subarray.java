import java.util.Scanner;

public class subarray{
    public static void main(String[] args) {
        // 
       

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the element of the array");
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<arr.length;i++){
            int sum=0;
           for(int j=i;j<arr.length;j++){
            
            // for(int k=i;k<=j;k++){
                sum+=arr[j];


            //     System.out.print(arr[k]+" ");
            // }
           

           }
           System.out.println("= "+sum);
             
        }
       
        // Given an array print the sum of all subarray
        // 
      
    }
}