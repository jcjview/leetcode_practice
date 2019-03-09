public class LongestSubstringWithoutRepeatingCharacters {
  private static int repeat(char[] c, int n, int j){
  long dup=0;
    for(int i=n;i<j;i++) {
      int ch = c[i] -30;
      if ((dup & (1l << ch)) > 0)
        return 1;
      dup = dup|(1<<ch); //将dup的ch位置1
    }
    return 0;
  }
  private static void print(char[] c, int n, int j){
    for(int i=n;i<j;i++) {
     System.out.print(c[i]);
    }
    System.out.println();
  }
  public int lengthOfLongestSubstring(String s) {
    if(s.isEmpty())return 0;
    char[] c=s.toCharArray();

    int current=1;
    for(int i=0;i<c.length;i++){
      for(int j=i+1;j<c.length+1;j++){
        if(j-i<=current)
          continue;
        if(repeat(c,i,j)==0){
          current=j-i;
          print(c,i,j);
          repeat(c,i,j);
        }
      }
    }
    return current;
  }

  public static void main(String[] args) {
    int s1=new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(
        "aabaab!bb");
    System.out.println(s1);

  }

}
