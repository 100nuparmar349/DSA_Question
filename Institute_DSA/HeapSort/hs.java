// package Institute_DSA.HeapSort;

public class hs {
    public static void heapify(int[] arr,int i,int n){
        int max=i;
        int left=2*i+1,right=2*i+2;
        if(left<n && arr[left]>arr[max])max=left;
        if(right<n && arr[right]>arr[max])max=right;
        if(max!=i){
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
            heapify(arr,max, n);
        }
    }
    public static void heapsort(int[] arr,int n){
       for(int i=n/2-1;i>=0;i--){
        heapify(arr,i,n);
       }
       for(int i=n-1;i>0;i--){
        int temp=arr[0];
        arr[0]=arr[i];
        arr[i]=temp;
        heapify(arr,0,i);
       }
    }
    public static void main(String[] args) {
        int arr[]={7,3,2,5,1,4};
        heapsort(arr,arr.length);
        for(int i:arr)System.out.println(i);
    }
}
