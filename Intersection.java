
/**
 * Intersection
 */

import java.util.*;

public class Intersection {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hs = new HashMap<>();

        if (nums2.length > nums1.length)
            return intersect(nums2, nums1);

        for (int i = 0; i < nums1.length; i++) {
            if (hs.containsKey(nums1[i]))
                hs.put(nums1[i], hs.get(nums1[i]) + 1);
            else
                hs.put(nums1[i], 1);
        }

        ArrayList<Integer> al = new ArrayList<Integer>();

        for (int num : nums2) {
            if (hs.get(num) != null && hs.get(num) > 0) {
                al.add(num);
                hs.put(num, hs.get(num) - 1);
            }
        }
        int[] arr = al.stream().mapToInt(i -> i).toArray();
        return arr;

    }
}