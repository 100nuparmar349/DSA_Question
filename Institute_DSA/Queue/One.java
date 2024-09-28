import java.util.*;
public class One{
    public static void main(String[] args) {
        Deque<Integer>d=new ArrayDeque<>();
        d.add(4);
        d.addFirst(1);
        d.addLast(2);
        d.add(5);
        d.removeFirst();

    }
}