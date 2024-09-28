# 01 Bit Manipulation
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

# 04 2220. Minimum Bit Flips to Convert Number

A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.

For example, for x = 7, the binary representation is 111 and we may choose any bit (including any leading zeros not shown) and flip it. We can flip the first bit from the right to get 110, flip the second bit from the right to get 101, flip the fifth bit from the right (a leading zero) to get 10111, etc.
Given two integers start and goal, return the minimum number of bit flips to convert start to goal.
Example 1:
Input: start = 10, goal = 7
Output: 3
Explanation: The binary representation of 10 and 7 are 1010 and 0111 respectively. We can convert 10 to 7 in 3 steps:
- Flip the first bit from the right: 1010 -> 1011.
- Flip the third bit from the right: 1011 -> 1111.
- Flip the fourth bit from the right: 1111 -> 0111.
It can be shown we cannot convert 10 to 7 in less than 3 steps. Hence, we return
class Solution {
    public int minBitFlips(int start, int goal) {
        int ans=start^goal;
      int cnt=0;
      while(ans>0){
        cnt+=ans&1;
        ans=ans>>1;
      }
      return cnt;
    }
}

# 05 78. Subsets
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
      
      int n = nums.size();
	vector<vector<int>>ans;
	for (int num = 0; num < (1 << n); num++) {
	vector<int>temp;
		for (int i = 0; i < n; i++) {
			//check if the ith bit is set or not
			if ((num & (1 << i))!=0) {
				// sub += s.charAt(i);
                temp.push_back(nums[i]);
			}
		}
		
			ans.push_back(temp);
		
	}
        return ans;
    }
};

#  07 Reverse Bits
# Code
cpp []
class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t reversed = 0;
        int bits_count = sizeof(n) * 8; // Total number of bits in uint32_t
        for (int i = 0; i < bits_count; ++i) {
            reversed = (reversed << 1) | (n & 1); // Shift reversed left and add the rightmost bit of n
            n >>= 1; // Shift n to the right by 1
        }
        return reversed;
    }
};

# 08 Count Bit 
 class Solution {
public:
    vector<int> countBits(int n) {
        vector<int>v;
        for(int i=0;i<=n;i++){
            int temp=i;
            int cnt=0;
            while(temp!=0){
                int bit=temp&1;
                if(bit==1)cnt++;
                temp=temp>>1;
            }

            v.push_back(cnt);
        }
        return v;
    }
};



# 09 Count Prime
N=10.
class Solution {
public:
    
    int countPrimes(int n) {
        int cnt=0;
        int prime[n+1];
        for(int i=1;i<n;i++){
            prime[i]=1;
        }
        for(int i=2;i<sqrt(n);i++){
            if(prime[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(prime[i]==1)cnt++;
        }
        return cnt;
       
    }
};

# 10 All divisors of a Number
Given an integer N, print all the divisors of N in the ascending order.
Example 1:
Input : 20
Output: 1 2 4 5 10 20
Explanation: 20 is completely 
 public:
    void print_divisors(int n) {
        // Code here.
        vector<int>v;
        for(int i=1;i<=sqrt(n);i++){
            if(n%i==0){
                v.push_back(i);
                if(n!=1 && i!=n/i){
                     v.push_back(n/i);
                }
               
            }
        }
        sort(v.begin(),v.end());
        for(int i=0;i<v.size();i++){
            cout<<v[i]<<" ";
        }
    }

# 204. Count Primes

Given an integer n, return the number of prime numbers that are strictly less than n.
Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 int countPrimes(int n) {
        int cnt=0;
        int prime[n+1];
        for(int i=1;i<n;i++){
            prime[i]=1;
        }
        for(int i=2;i<sqrt(n);i++){
            if(prime[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(prime[i]==1)cnt++;
        }
        return cnt;
       
    }