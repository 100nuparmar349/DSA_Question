
# Q.01 Allocate Minimum Pages
You have n books, each with arr[i] a number of pages. m students need to be allocated contiguous books, with each student getting at least one book.
Out of all the permutations, the goal is to find the permutation where the sum of the maximum number of pages in a book allotted to a student should be the minimum, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Input: n = 4, arr[] = [12, 34, 67, 90], m = 2
Output: 113



import java.util.*;

public class Main {
    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size(); // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                // add pages to current student
                pagesStudent += arr.get(i);
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        int ans = findPages(arr, n, m);
        System.out.println("The answer is: " + ans);
    }
}


# Q.02  658. Find K Closest Elements
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

class Solution {
public:
int findmid(vector<int>arr,int x){
     int low=0,high=arr.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x){
                return mid;
            } else if(arr[mid]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;

}

    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int index = findmid(arr, x);
        int left = index, right = index + 1;
        vector<int> result;
        while (k > 0) {
            if (left >= 0 && right < arr.size()) {
                if (abs(arr[left] - x) <= abs(arr[right] - x)) {
                    result.push_back(arr[left]);
                    left--;
                } else {
                    result.push_back(arr[right]);
                    right++;
                }
            } else if (left >= 0) {
                result.push_back(arr[left]);
                left--;
            } else if (right < arr.size()) {
                result.push_back(arr[right]);
                right++;
            }
            k--;
        }
        sort(result.begin(),result.end());
        return result;
       
        
    }
};



