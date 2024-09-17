import java.util.*;
public class Bit{
   public static String convertBinary(int x){
    String res="";
    while(x!=0){
        if(x%2==1)res+='1';
        else res+='0';

        x=x/2;
    }
    
    return res;
   }
   public static void convertDecimal(String s,int n){
    
    int ans=0;
    int p=1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                ans+=p;
                p=p*2;
            }else{
                p=p*2;
            }

        }
        System.out.println(ans);
   }
    public static void main(String[] args) {
    
        String ans=convertBinary(10);
        StringBuilder s=new StringBuilder(ans);
        s.reverse();
        System.out.println(s);
        String x="0100";
        int n=x.length();
        convertDecimal("0100",n);
       
    }
}