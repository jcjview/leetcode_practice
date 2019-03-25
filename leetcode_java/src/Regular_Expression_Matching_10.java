import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javafx.util.Pair;

public class Regular_Expression_Matching_10 {

  static String point = ".";
  static char star = "*".toCharArray()[0];

  //hard  start at 2019-3-12 15:02:42
  public static boolean sim(Object a, Object b) {
    if("#".equals(a))return false;
    return Objects.equals(point, b) || Objects.equals(a, b);
  }
  public static boolean isMatch(String s, String p) {
// 无剪枝深搜
// if (s.isEmpty()) {
//      return p.isEmpty();
//    }
//    if (p.isEmpty()) {
//      return false;
//    }
    List<String> reg=new ArrayList<>();
    int n = s.length(), m = p.length();
    s=s+"#";
    int i = 0, j = 0;
    while(j<m){
      String temp= String.valueOf(p.charAt(j));
      char latter=0;
      if (j < m - 1) {
        latter = p.charAt(j + 1);
      }
      if (latter == star) {
        j++;
        temp+=star;
      }
      j++;
      reg.add(temp);
    };
    m=reg.size();
    boolean ret = false;
    Deque<int[]> stack = new LinkedList<>();
    int[] templist = new int[2];
    templist[0] = 0;
    templist[1] = 0;
    stack.add(templist);
    FOR:
    while (!stack.isEmpty()) {
      int[] pair = stack.pop();
      i = pair[0];
      j = pair[1];

      if (i == n && j == m) {
        ret = true;
        break ;
      }
      if(i>=n){
        if(j<m&&reg.get(j).length()>1){
          System.out.println("1");
        }else
        continue;
      }
      if(j>=m)continue;

      String si = String.valueOf(s.charAt(i));
      String pj = reg.get(j);
      if (sim(si, pj)) {
        pair = new int[2];
        pair[0] = i + 1;
        pair[1] = j + 1;
        stack.push(pair);
      }else if (pj.length()>1 ) {
        String pj0=pj.substring(0,1);
        if (sim(si, pj0)){
          int[] pair1 = new int[2];
          pair1[0] = i+1;
          pair1[1] = j;
          stack.push(pair1);
          int[] pair2 = new int[2];
          pair2[0] = i+1;
          pair2[1] = j+1 ;
          stack.push(pair2);

        }
        int[] pair3 = new int[2];
        pair3[0] = i;
        pair3[1] = j+1 ;
        stack.push(pair3);
      }

    }


    return ret;
  }
  public static boolean isMatch2(String s, String p) {
    if (s.isEmpty()) {
      return p.isEmpty();
    }
    if (p.isEmpty()) {
      return false;
    }
    int n = s.length(), m = p.length();
    boolean ret = false;
    int i = 0, j = 0;
    Deque<int[]> stack = new LinkedList<>();
    int[] templist = new int[2];
    templist[0] = i;
    templist[1] = j;
    stack.add(templist);
    FOR:
    while (!stack.isEmpty()) {
      int[] pair = stack.pop();
      i = pair[0];
      j = pair[1];
      if (i >= n || j == m) {
        if (i == n && j == m) {
          ret = true;
          break ;
        }
        continue ;
      }
      char si = s.charAt(i);
      char pj = p.charAt(j);
      char formal = 0;
      if (j > 0) {
        formal = p.charAt(j - 1);
      }
      char latter=0;
      if (j < m - 1) {
        latter = p.charAt(j + 1);
      }
      if (sim(si, pj)) {
          templist = new int[2];
          templist[0] = i + 1;
          templist[1] = j + 1;
          stack.push(templist);
          if(latter==star&&i+1==n){
            templist = new int[2];
            templist[0] = i + 1;
            templist[1] = j + 2;
            stack.push(templist);
          }
      }
      else if (pj == star) {
        if (j <= 0) {
          break;
        }
        templist = new int[2];
        templist[0] = i;
        if (j < m ) {
          templist[1] = j + 1;
          stack.push(templist);
        }
        int temp = i;
        char si1 = s.charAt(temp);
        while (temp < n && sim(si1, formal)) {
          if (temp == n - 1 && j == m - 1) {
            ret = true;
            break FOR;
          }

          templist = new int[2];
          templist[0] = temp;
          templist[1] = j ;
          stack.push(templist);

          temp++;
          templist = new int[2];
          if (j < m - 1 && temp < n) {
            templist[0] = temp;
            templist[1] = j + 1;
            stack.push(templist);
            si1 = s.charAt(temp);
          }
        }
      }
      if (latter == star) {
        if (j <= m - 2) {
          templist = new int[2];
          templist[0] = i;
          templist[1] = j + 2;
          stack.push(templist);
        }
//        if (j + 1 == m - 1) {
//          templist = new int[2];
//          templist[0] = i;
//          templist[1] = j + 1;
//          stack.push(templist);
//        }
      }
    }

    return ret;
  }

  public static void main(String[] args) {
    boolean ret;
    ret = isMatch("", "");
    System.out.println(ret);
    ret = isMatch("a", "");
    System.out.println(ret);
    ret = isMatch("", "a");
    System.out.println(ret);
    ret = isMatch("", ".*");
    System.out.println(ret);
    ret = isMatch("a", ".*c");
    System.out.println(ret);
     ret = isMatch("a", "ab*");
    System.out.println(ret);
    ret = isMatch("ac", "a*c*");
    System.out.println(ret);
     ret = isMatch("aa", "z*aa");
    System.out.println(ret);
    ret = isMatch("zzzzz", "z*");
    System.out.println(ret);
    ret = isMatch("issipp", "is*ip*");
    System.out.println(ret);

    ret = isMatch("mississippi", "mis*is*p*.");
    System.out.println(ret);
    ret = isMatch("mississippi", "mis*is*ip*.");
    System.out.println(ret);
    ret = isMatch("aaca","ab*a*c*a");
    System.out.println(ret);


  }
}
