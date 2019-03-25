public class Longest_Common_Prefix {

  public static String longestCommonPrefix(String[] strs) {
    if(strs.length==0)return "";
    if(strs.length==1)return strs[0];
    if(strs[0].isEmpty())return strs[0];
    StringBuilder sb = new StringBuilder();
    int i = 0;
    boolean flag = true;
    while (i<strs[0].length() && flag) {
      char temp = strs[0].charAt(i);
      flag = false;
      for (int i1 = 1, strsLength = strs.length; i1 < strsLength; i1++) {
        String str = strs[i1];
        if (i < str.length() && str.charAt(i) == temp) {
          flag = true;
        } else {
          flag = false;
          break;
        }
      }
      if (flag) {
        sb.append(temp);
        i++;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String[] strs = {"a", "a", "a"};
    System.out.println(longestCommonPrefix(strs));
    String[] strs1 = {"dog", "racecar", "car"};
    System.out.println(longestCommonPrefix(strs1));

    String[] strs2 = {"dog"};

    System.out.println(longestCommonPrefix(strs2));

  }
}
