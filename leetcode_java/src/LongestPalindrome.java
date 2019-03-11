public class LongestPalindrome {

  public static String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }
    int[] cache = new int[s.length()];
    int[] cache2 = new int[s.length()];
    int j = 2;
    for (int i = 0; i < s.length() - j + 1; i++) {
      int end = i + j - 1;
      if (s.charAt(i) == s.charAt(end)) {
        cache[i] = j;
      }
    }
    j = 3;
    for (int i = 0; i < s.length() - j + 1; i++) {
      int end = i + j - 1;
      if (s.charAt(i) == s.charAt(end)) {
        cache2[i] = j;
      }
    }
    for (j = 4; j <= s.length(); j++) {
      for (int i = 0; i < s.length() - j + 1; i++) {
        int start = i + 1;
        int end = i + j - 1 - 1;
        int f_j = end - start + 1;
        char c1 = s.charAt(i);
        char c2 = s.charAt(i + j - 1);
        int[] p = cache2;
        if (j % 2 == 0) {
          p = cache;
        }
        if (c1 == c2 && p[start] == f_j) {
          p[i] = j;
        }
      }
    }
    int max = 0;
    String ret = "";
    for (int i = 0; i < cache.length; i++) {
      j = cache[i];
      int j2 = cache2[i];
      j = j > j2 ? j : j2;
      if (j > max) {
        max = j;
        ret = s.substring(i, i + j);
      }
    }
    if (ret.isEmpty()) {
      return String.valueOf(s.charAt(0));
    }
    return ret;
  }

  public static void main(String[] args) {
    String temp = longestPalindrome("ababababa");
    System.out.println(temp);
  }
}
