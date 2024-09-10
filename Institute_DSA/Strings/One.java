import java.util.Scanner;

public class One{
    public static void main(String[] args) {
        System.out.println("Hello");
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char[] arr=s.toCharArray();

         System.out.println(s);
         System.out.print("Char array :- ");
         System.out.println(arr[0]);
         
         System.out.println(s+10);
         System.out.println(s.charAt(0));
         System.out.println(s.length());// length() is method.
         // length is property of array.

         for(char c:arr){
            System.out.println(c);
         }
         int n=s.length();
         System.out.println(n);
         String s1="";
         for(int i=n-1;i>=0;i--){
            s1+=s.charAt(i);
         }
        //  int i=0;
        //  int j=n-1;
        // while(i<j){
        //     char temp=s.charAt(i);
        //     s.charAt(i)=s.charAt(j-i); 
        //     i++;
        //     j--;

        //  }
         System.out.println(s1);

         StringBuilder rev=new StringBuilder(s);
         System.out.println(rev.reverse());
         System.out.println(rev.toString());


    }
}