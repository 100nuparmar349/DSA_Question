import java.util.*;

  public class Solve{
    public static int solve(int n, List<Integer> a, List<Integer> b) {
        HashSet<Integer> setb = new HashSet<>(b);
        int small = Integer.MAX_VALUE;

        for (int i : a) {
            if (!setb.contains(i)) {
                if (i < small) {
                    small = i;
                }
            }
        }
        return (small == Integer.MAX_VALUE) ? -1 : small;
    }

        public static void main(String[] args) {
            
        }

   }
  