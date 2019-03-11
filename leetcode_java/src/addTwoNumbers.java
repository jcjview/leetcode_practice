

public class addTwoNumbers {

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p = l1;
    ListNode r = l2;
    do {

      r.val = r.val + p.val;

      if (r.val >= 10) {
        int v0 = r.val % 10;
        int v1 = r.val / 10;
        if (r.next == null) {
          r.next = new ListNode(0);
        }
        r.val = v0;
        r.next.val += v1;
      }

      if (r.next == null && p.next != null) {
        r.next = new ListNode(0);
      }
      r = r.next;
      p = p.next;
    } while (p != null);

    while (r != null) {
      if (r.val >= 10) {
        int v0 = r.val % 10;
        int v1 = r.val / 10;
        if (r.next == null) {
          r.next = new ListNode(0);
        }
        r.val = v0;
        r.next.val += v1;
      }
      r = r.next;
    }
    return l2;


  }

  public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode p = l1;
    ListNode q = l2;
    ListNode ret = null;
    ListNode l = null;
    int carry = 0;
    while (p != null || q != null||carry>0) {
      int a = (p != null) ? p.val : 0;
      int b = (q != null) ? q.val : 0;
      a = a + b + carry;
      carry = a / 10;
      a = a % 10;
      ListNode temp = new ListNode(a);
      if (ret == null) {
        ret = l = temp;
      } else {
        l.next = temp;
        l = l.next;
      }
      if (p != null) {
        p = p.next;
      }
      if (q != null) {
        q = q.next;
      }
    }
//    if (carry > 0) {
//      ListNode temp = new ListNode(a);
//      if (ret == null) {
//        ret = l = temp;
//      } else {
//        l.next = temp;
////      l=l.next;
//      }
//    }
    return ret;
  }


  public static void main(String[] args) {
    int[] l1 = {};
    int[] l2 = {};
    ListNode temp;
    ListNode p = new ListNode(5);
    temp = p;
    for (int i : l1) {
      temp.next = new ListNode(i);
      temp = temp.next;
    }
    ListNode q = new ListNode(5);
    temp = q;
    for (int i : l2) {
      temp.next = new ListNode(i);
      temp = temp.next;
    }

    temp = addTwoNumbers2(p, q);

    while (temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }

}



