import java.util.ArrayList;

public class Dream{
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
// List<Integer>list=new List<>();
list.add(1);
list.add(2);
list.add(3);



// Insert element
list.add(2,4);
for(int i=0;i<list.size();i++){
    System.out.print(list.get(i));
}
list.remove(2);
for(int i=0;i<list.size();i++){
    System.out.print(list.get(i));
}


    }
}