import java.util.Scanner;




public class MergeSort {
    public static void merge(int[] arr,int s,int mid,int e){
        int left=mid-s+1;
        int right=e-mid;
        int [] l=new int[left];
        int[] R=new int[right];
        for(int i=0;i<left;i++)l[i]=arr[s+1];
        for(int i=0;i<right;i++)R[i]=arr[mid+1+i];
        int i=0,j=0,k=s;
       while(i<left && j<right){
        if(l[left]<R[right]){
            arr[k++]=l[i++];
           
        }else{
            arr[k++]=R[j++];
        }
       }
       while(i<left){
        arr[k++]=l[i++];
       }
       while(j<right){
        arr[k++]=R[j++];
       }

    }

    public static void MergeSort(int[] arr,int s,int e){
        if(s==e){
            return;
        }
        int mid=(s+e)/2;
        MergeSort(arr,mid,e);
        MergeSort(arr,mid+1,e);
        merge(arr,s,mid,e);
    }
    static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        MergeSort(arr, 0, n);
        print(arr);


    }
}
