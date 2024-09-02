
import java.util.Scanner;
class obj{
    public void rever(int[] arr,int i,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        
    }
}
public class Reve {
        public static void main(String[] args) {
            obj o=new obj();
        

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your array length");
        int n=sc.nextInt();
       
        System.out.print(n);
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        int i=0;
        
        int k=3;
     for(int j=k-1;j<n;j+=k){
        o.rever(arr, i, j);
        i+=k;
     }
          
         

        
       
    //     for(int i=0;i<n/2;i++){
    //    int temp=arr[i];
    //    arr[i]=arr[n-1-i];
    //    arr[n-1-i]=temp;
    //     }

    // Two Pointer Approach .
    // int i=0,j=n-1;
   
        for(int a=0;a<n;a++){
            System.out.print(arr[a]);
        }

    }
}

// Question
// given an array reverse the array in k groups. 