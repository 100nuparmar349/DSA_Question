import java.util.Scanner;
import java.util.*;

public class Maximums{
    public static void main(String[] args){
         Scanner input=new Scanner(System.in);
         int largest=Integer.MIN_VALUE;
         int secondlargest=Integer.MIN_VALUE;
        //  Boolean flag=true;
         int sum=0;
        //  System.out.println("Enter the size of the array:");
        // int size=input.nextInt();
        // int[] array = new int[size];

        // for(int i=0;i<size;i++){
        //     System.out.println("Enter your number");
        //     array[i]=input.nextInt();
        // }

        // find the second element in the array
        //find the sum of the element

        
        int[] array={4,1,2,1,2};
        
       
        // for(int i=0;i<array.length;i++){
            

        //     // largest=Math.max(array[i],largest); 
        //     if(largest<array[i]){
        //         if(secondlargest<largest){
        //             secondlargest=largest;
        //         }
        //         largest=array[i];
        //     }
        //     // if(secondlargest<array[i] && largest!=array[i] ){
        //     //     // flag=false;
        //     //     secondlargest=Math.max(secondlargest,array[i]);
               
        //     // }
        //     sum+=array[i];
            
        // }

        // // System.out.println(array[array.length-2]);
        
        // System.out.println("Largest element "+largest );
        // // if(flag){
        // //     System.out.println("Condition are not execute "+array[array.length-2]);
        // // }else{
        // //     System.out.println("Second largest element "+secondlargest);

        // // }

        // System.out.println("Second largest element "+secondlargest);
        // System.out.println("Sum of all the element "+sum);
        
int one=0;
int first;
        for(int i=0;i<array.length;i++){
            one=one^array[i];

        }
        System.out.println(one);
       


    }
}