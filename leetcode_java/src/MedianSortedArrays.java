class MedianSortedArrays {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      int[] temp = nums1;
      nums1 = nums2;
      nums2 = temp;
    }
    if (nums2.length <= 0) {
      return 0.0;
    }

    int l1 = 0;
    int r1 = nums1.length;
    int mid1;
    int mid2;
    int min_right;
    int max_left;

    while (l1 <= r1) {
      mid1 = (l1 + r1) / 2;
      mid2 = (nums1.length + nums2.length + 1) / 2 - mid1;
      System.out.println(mid1);
      System.out.println(mid2);
//      min_right = nums1[mid1-1] < nums2[mid2] ? nums1[mid1-1] : nums2[mid2];
//      max_left = nums1[mid1-1] > nums2[mid2-1] ? nums1[mid1-1] : nums2[mid2-1];

      if (mid1 > 0 && nums1[mid1 - 1] > nums2[mid2]) {
        r1 = mid1 - 1;
      } else if (mid1 < nums1.length && nums2[mid2 - 1] > nums1[mid1]) {
        l1 = mid1 + 1;
      } else {
        if (mid1 == 0) {
          max_left = nums2[mid2 - 1];
        } else if (mid2 == 0) {
          max_left = nums1[mid1 - 1];
        } else {
          max_left = nums1[mid1 - 1] > nums2[mid2 - 1] ? nums1[mid1 - 1] : nums2[mid2 - 1];
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
          return max_left;
        }
        if (mid1 == nums1.length) {
          min_right = nums2[mid2];
        } else if (mid2 == nums2.length) {
          min_right = nums1[mid1];
        } else {
          min_right = nums1[mid1] < nums2[mid2] ? nums1[mid1] : nums2[mid2];
        }

        return (double) (max_left + min_right) / 2;
      }


    }

    return 0.0;
  }

  public static void main(String[] args) {
    int[] a = {3};
    int[] b = {1, 2, 4};
    double s = findMedianSortedArrays(a, b);
    System.out.println(s);
  }
}