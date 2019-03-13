public class Palindrome {

  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int n = (int) (Math.log10(x) + 1);
    if (n < 2) {
      return true;
    }
    int vx=x;
    for (int i = 0; i < n / 2; i++) {
      int j = n - 1 - i;
      int t = vx % 10;
      int pow = (int) Math.pow(10, j);
      int temp = x / pow;
      int q = temp % 10;
      vx = vx / 10;
      if (t != q) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    boolean i;
    i = isPalindrome(1211);
    System.out.println(i);
     i = isPalindrome(121);
    System.out.println(i);
    i = isPalindrome(-121);
    System.out.println(i);
    i = isPalindrome(10);
    System.out.println(i);
  }
}
