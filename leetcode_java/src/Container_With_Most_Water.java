public class Container_With_Most_Water {

  private static int min(int i, int j) {
    return i < j ? i : j;
  }

  public static int maxArea(int[] height) {
    int n = height.length;
    int aera = 0;
    int i = 0;
    int j = n - 1;
    while (j - i > 0) {
      int hgh = min(height[i], height[j]);
      int w = j - i;
      int temp = hgh * w;
      aera = temp > aera ? temp : aera;
      if (height[i] > height[j]) {
        j--;
      } else {
        i++;
      }
    }
    return aera;

  }


  public static int maxArea2(int[] height) {
    int n = height.length;
    int aera = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int hgh = min(height[i], height[j]);
        int w = j - i;
        int temp = hgh * w;
        aera = temp > aera ? temp : aera;
      }
    }
    return aera;
  }

  public static void main(String[] args) {
    int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int temp = maxArea(input);
    System.out.println(temp);
  }
}
