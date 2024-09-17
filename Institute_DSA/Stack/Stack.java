import java.util.*;

public class Stack {
// 
   static class Stack1 {
        ArrayList<Integer> st = new ArrayList<>();

        public void push(int x) {
            st.add(x);
        }

        public int pop() {
            if (st.size() == 0) return -1;
            return st.remove(st.size() - 1);
        }
        public boolean isEmpty(){
            return st.size()==0;
           }

        public int peek(){
            if(st.size()==0)return -1;
            return st.get(st.size()-1);
        }
    }

    public static void main(String[] args) {
      //  Stack outer = new Stack(); 
        Stack1 s = new Stack1(); 
        s.push(5);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        
        // System.out.println(s.pop()); 
    }
}
