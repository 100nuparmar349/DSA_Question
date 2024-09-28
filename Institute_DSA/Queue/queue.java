import java.util.*;
public class queue{
    public static void main(String[] args) {
        // System.out.println("Hello");
        Queue<Integer>q=new LinkedList<>();
        // Queue<Integer>deq=new LinkedList<>();
        q.add(-1);
        q.add(2);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        // q.remove();
        q.poll();
    }
}