import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Definition for singly-linked list.

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


class Solution {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p = l1;
    ListNode r = l2;
//    do {
//
//      r.val = r.val + p.val;
//
//      if (r.val >= 10) {
//        int v0 = r.val % 10;
//        int v1 = r.val / 10;
//        if (r.next == null) {
//          r.next = new ListNode(0);
//        }
//        r.val = v0;
//        r.next.val += v1;
//      }
//
//      if (r.next == null && p.next != null) {
//        r.next = new ListNode(0);
//      }
//      r = r.next;
//      p = p.next;
//    } while (p != null);
//
//    while (r != null) {
//      if (r.val >= 10) {
//        int v0 = r.val % 10;
//        int v1 = r.val / 10;
//        if (r.next == null) {
//          r.next = new ListNode(0);
//        }
//        r.val = v0;
//        r.next.val += v1;
//      }
//      r = r.next;
//    }
    while (p!=null||r!=null){
      int x= p!=null? p.val:0;
      int y= r!=null? r.val:0;

    }
    return l2;


  }
}

class MainClass {

  public static int[] stringToIntegerArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return new int[0];
    }

    String[] parts = input.split(",");
    int[] output = new int[parts.length];
    for (int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();
      output[index] = Integer.parseInt(part);
    }
    return output;
  }

  public static ListNode stringToListNode(String input) {
    // Generate array from the input
    int[] nodeValues = stringToIntegerArray(input);

    // Now convert that list into linked list
    ListNode dummyRoot = new ListNode(0);
    ListNode ptr = dummyRoot;
    for (int item : nodeValues) {
      ptr.next = new ListNode(item);
      ptr = ptr.next;
    }
    return dummyRoot.next;
  }

  public static String listNodeToString(ListNode node) {
    if (node == null) {
      return "[]";
    }

    String result = "";
    while (node != null) {
      result += Integer.toString(node.val) + ", ";
      node = node.next;
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      ListNode l1 = stringToListNode(line);
      line = in.readLine();
      ListNode l2 = stringToListNode(line);

      ListNode ret = new Solution().addTwoNumbers(l1, l2);

      String out = listNodeToString(ret);

      System.out.print(out);
    }
  }
}

