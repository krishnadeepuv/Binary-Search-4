public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] bigarray = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                bigarray[count++] = nums1[p1];
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                bigarray[count++] = nums2[p2];
                p2++;
            } else {
                bigarray[count++] = nums2[p2];
                bigarray[count++] = nums1[p1];
                p2++;
                p1++;
            }
        }

        while (p1 < nums1.length) {
            bigarray[count++] = nums1[p1++];
        }
        while (p2 < nums2.length) {
            bigarray[count++] = nums2[p2++];
        }

        int index = bigarray.length;
        for (int i = 0; i < bigarray.length; i++) {
            System.out.println(bigarray[i]);
        }
        // return 1.0;

        if (index % 2 == 0) {
            return (float) (bigarray[(index / 2) - 1] + bigarray[(index / 2)]) / 2;
        } else {
            return (float) (bigarray[index / 2]);
        }
    }
}
