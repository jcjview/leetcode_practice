import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

public class Regular_Expression_Matching_10 {
  static char point = ".".toCharArray()[0];
  static char star = "*".toCharArray()[0];
  //hard  start at 2019-3-12 15:02:42
  public static boolean sim(char a,char b){
    return point == b || a == b;
  }
  public static boolean isMatch(String s, String p) {


    int n = s.length(), m = p.length();
    boolean ret = false;
    int i = 0, j = 0;
    char formal = 0;
    Deque<Map.Entry<Integer, Integer>> stack = new LinkedList<>();
    stack.add(new AbstractMap.SimpleEntry<>(i, j));
    FOR:
    while (!stack.isEmpty()) {
      Map.Entry<Integer, Integer> pair = stack.pop();
      i = pair.getKey();
      j = pair.getValue();
      char si = s.charAt(i);
      char pj = p.charAt(j);
      if (sim(si , pj)) {
        if (i == n - 1 && j == m - 1) {
          ret = true;
          break;
        }
        if (i < n - 1 && j < n - 1) {
          i++;
          j++;
          stack.add(new AbstractMap.SimpleEntry<>(i, j));
        }
      } else if (pj == star) {
        if (j <= 0) {
          break FOR;
        }
        formal = p.charAt(j - 1);
        int temp = i;
        char si1 = s.charAt(temp);
        while (temp < n && sim(si1 , formal)) {
          if (temp == n - 1 && j == m - 1) {
            ret = true;
            break FOR;
          }
          if (j<m-1) {
            stack.push(new AbstractMap.SimpleEntry<>(temp, j+1));
          }
          temp++;
        }

      }
    }

    return ret;
  }

  public static void main(String[] args) {
    boolean ret = isMatch("abbzz", "a.*z");
    System.out.println(ret);
  }
}
