package HashTable;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> mySet = new HashSet<>();

        for (int num : nums) {
            if (mySet.contains(num)) {
                return true;
            } else {
                mySet.add(num);
            }
        }

        return false;
    }

    public static boolean containsDuplicateV2(int[] nums) {

        // sort -> check
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5 };
        System.out.println(containsDuplicate(nums));
        int[] nums2 = { 1, 2, 3, 5, 5 };
        System.out.println(containsDuplicate(nums2));

        int[] nums3 = { 5, 5, 2, 3, 6, 1, 4, 7 };
        containsDuplicateV2(nums3);
        for (int i : nums3) {
            System.out.print(i);
        }
        System.out.println(containsDuplicate(nums3));
    }
}