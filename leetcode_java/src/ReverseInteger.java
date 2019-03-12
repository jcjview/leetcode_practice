import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
public class ReverseInteger {
  public static int reverse(int x) {

    int carry=1;
    if(x<0){
      carry=-1;
      x=-x;
    }
    StringBuilder sb=new StringBuilder();
    List<Integer> arr=new ArrayList();
    while(x>0){
      arr.add(x%10);
      x=x/10;
    }
    int n=arr.size();
    long temp=0;
    for(int i=0;i<n;i++){
      temp*=10;
      temp+=arr.get(i);
    }
    if(temp>2147483647||temp<-2147483648)
      return 0;
    return (int)temp*carry;
  }

  public static void main(String[] args) {
    int y=reverse(1534236469);
    System.out.println(y);
    System.out.println(Math.pow(2,31));
  }
}
