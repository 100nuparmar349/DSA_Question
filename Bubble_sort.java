import java.util.Scanner;



public class Bubble_sort {
    static void selection(int[] arr, int n){

        for(int i=0;i<n;i++){
            int min_index=i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[min_index]){
                    min_index=j;

                }

            }
            int temp=arr[i];
            arr[i]=arr[min_index];
            arr[min_index]=temp;
        }
    }
    static void print(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.print( arr[i]+" ");
        }
    }

    static void bubbble_sort(int[] arr,int n){
          for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new  Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Before sorting");
        for(int i=0;i<n;i++){
            System.out.print( arr[i]+" ");
        }
        System.out.println();
      
        selection(arr, n);
        System.out.println("After Sorting ");
        print(arr, n);
       
    }
}