package arrayMe;

import java.util.ArrayList;
import java.util.List;

public class FindNumbersDisapped448 {
    // public static List<Integer> findDisappearedNumbers(int[] nums) {
    // List<Integer> result = new ArrayList<>();

    // for (int i = 1; i <= nums.length; i++) {
    // boolean isDisappeared = true;
    // for (int j = 0; j < nums.length; j++) {
    // if (i == nums[j]) {
    // isDisappeared = false;
    // }
    // }
    // if (isDisappeared) {
    // result.add(i);
    // }
    // }

    // return result;

    // }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        // int[] newArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (!result.contains(nums[i])) {
                result.add(nums[i]);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!result.contains(i)) {
                result2.add(i);
            }
        }

        return result2;

    }

    public static void main(String[] args) {
        // int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        int[] arr = { 1, 1 };
        List<Integer> numbers = findDisappearedNumbers(arr);
        for (Integer integer : numbers) {
            System.out.print(integer);
        }
    }
}
