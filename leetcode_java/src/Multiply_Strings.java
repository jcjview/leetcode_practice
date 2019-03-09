import java.util.ArrayList;
import java.util.List;

public class Multiply_Strings {


  public static String multiply(String num1, String num2) {

//    class ListNode {
//
//      Integer val;
//      ListNode next;
//
//      ListNode(int x) {
//        val = x;
//      }
//    }
    if("0".equals(num1)||"0".equals(num2)){
      return "0";
    }
    int bit = 0;
    int bit2 = 0;

    List<Integer> mul = new ArrayList<>();
    char[] num1c = num1.toCharArray();
    char[] num2c = num2.toCharArray();

    for (int i = 0; i < num1c.length + num2c.length-1; i++) {
      mul.add(0);
    }
    for (bit = num1c.length-1; bit >=0; bit--) {
      char c = num1c[bit];
      int pos=num1c.length-bit-1;
      int i = Integer.valueOf(String.valueOf(c));

      for (bit2 = num2c.length-1; bit2 >=0; bit2--) {
        char d = num2c[bit2];
        int pos2=num2c.length-bit2-1;
        int j = Integer.valueOf(String.valueOf(d));
        int temp = i * j + mul.get(pos2 + pos);
        mul.set(pos2 + pos, temp);
      }
    }
    int carry = 0;
    for (bit2 = 0; bit2 < mul.size(); bit2++) {
      int v0 = mul.get(bit2)+carry;
      carry = 0;
      if (v0 >= 10) {
        mul.set(bit2, v0 % 10);
        carry = v0 / 10;
      }else
        mul.set(bit2, v0 );
    }

    if (carry > 0) {
      mul.add(carry);
      if (carry > 10) {
        System.out.println("error");
      }

    }

    StringBuilder ret = new StringBuilder();
    for (bit2 = 0; bit2 < mul.size(); bit2++) {

      Integer v0 = mul.get(bit2);
      if(v0==0&&bit2==mul.size()-1&&ret.length()>0){
        break;
      }
      ret.insert(0,v0.toString());
//      System.out.println(v0);
    }
    return ret.toString();

  }




  public static void main(String[] args) {
    String result = multiply("123", "456");
    System.out.println(result);
    System.out.println(123 * 456);
  }
}
