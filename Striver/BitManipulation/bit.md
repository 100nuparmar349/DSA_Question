# 01 Bit Manipulation
Difficulty: EasyAccuracy: 49.84%Submissions: 37K+Points: 2
Given a 32 bit unsigned integer num and an integer i. Perform following operations on the number - 

1. Get ith bit

2. Set ith bit

3. Clear ith bit

Note : For better understanding, we are starting bits from 1 instead 0. (1-based). You have to print space three space seperated values ( as shown in output ) and do not have to return anything.

Examples :

Input: 70 3
Output: 1 70 66
Explanation: Bit at the 3rd position from LSB is 1. (1 0 0 0 1 1 0) .The value of the given number after setting the 3rd bit is 70. The value of the given number after clearing 3rd bit is 66. (1 0 0 0 0 1 0)
Input: 8 1
Output: 0 9 8
  int get = (num>>(i-1))&1;
        int set = num | (1<<(i-1));
        int clear = set ^ (1<<(i-1));


# 02 K-th Bit is Set or Not
Difficulty: EasyAccuracy: 52.75%Submissions: 194K+Points: 2
Given a number n and a bit number k, check if kth index bit of n is set or not. A bit is called set if it is 1. Position of set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number.
Note: Index is starting from 0. You just need to return true or false, driver code will take care of printing "Yes" and "No".

Examples : 

Input: n = 4, k = 0
Output: No
Explanation: Binary representation of 4 is 100, in which 0th index bit from LSB is not set. So, return false

 static boolean checkKthBit(int n, int k) {
        // Your code here
        int x=n>>k;
        x=x&1;
        if(x==1)return true;
        return false;
        
  
    }

# 03 Power of two
  public boolean isPowerOfTwo(int n) {   
        return (n&(n-1))==0;
    }