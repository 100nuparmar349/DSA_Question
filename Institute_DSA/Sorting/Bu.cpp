#include<iostream>
using namespace std;

int ascending(int arr[],int n){
  int cnt=0;
  for(int i=0;i<n;i++){
    for(int j=0;j<n-1-i;j++){
    	if(arr[j]>arr[j+1]){
          int temp=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=temp;
          cnt++;
        }
    }
  }
  return cnt;
}
int descending(int arr[],int n){
  int cnt=0;
  for(int i=0;i<n;i++){
    for(int j=0;j<n-1-i;j++){
    	if(arr[j]<arr[j+1]){
          int temp=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=temp;
          cnt++;
        }
    }
  }
  return cnt;
}

int main(){
  int n;
  cin>>n;
  int arr[n];
  int arr1[n];
  for(int i=0;i<n;i++){
    cin>>arr[i];
    arr1[i]=arr[i];
  }
  
int s1=ascending(arr,n);
  int s2=descending(arr1,n);
  


   cout<<s1<< "s1 ";

   cout<<s2<<"s2";

  
  return 0;
}