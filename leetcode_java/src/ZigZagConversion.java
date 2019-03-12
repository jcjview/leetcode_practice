public class ZigZagConversion {
  public static String convert(String s, int numRows) {
    if(numRows==1)return s;
    int n=s.length();
    int[] cache=new int[n];
    int q=numRows+numRows-2;
    for(int i=0;i<n;i++){
      int pos=i%q;
      if(pos<numRows){
        cache[i]=pos;
      }else{
        pos=pos-numRows+1;
        cache[i]=numRows-1-pos;
      }
    }
    String[] relist=new String[numRows];

    for(int i=0;i<numRows;i++){
      relist[i]="";
    }
    for(int i=0;i<n;i++){
      int pos=cache[i];
      relist[pos]=relist[pos]+s.charAt(i);
    }
    return String.join("",relist);
  }

  public static void main(String[] args) {
    String ret=convert("A",1);
    System.out.println(ret);
  }
}
