// Given a number n print the values from n to 1;
public class Recursion{
// Tail recursion
    static void print(int n){
        if(n==0){
            return;
        }
        print(n-1);
        System.out.println(n);
        print(n-1);


       
       
    }
    public static void main(String[] args) {
        int n=5;
        print(n);
    }
}