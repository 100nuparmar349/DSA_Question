# Q.01
There are 5 assignment operators in java. These are +=, -=, *=, /=, and %=.

Problem statement
The circular wait condition can be prevented by ___________
Ans :- defining a linear ordering of resource types

Problem statement
If the wait for graph contains a cycle __
Ans :-  then a deadlock exists
 */

 # 02 
  public:
  long long gcd(long long a,long long b){
      if(b==0)return a;
      return gcd(b,a%b);
  }
    vector<long long> lcmAndGcd(long long A , long long B) {
        // code here
        vector<long long>v;
        long HCF=gcd(A,B);
        long  lcm=A*B/gcd(A,B);
        v.push_back(lcm);
        v.push_back(HCF);
        return v;
    }
};