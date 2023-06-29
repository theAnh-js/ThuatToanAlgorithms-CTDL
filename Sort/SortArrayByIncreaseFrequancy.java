package Sort;

import java.util.HashMap;
import java.util.Map;

public class SortArrayByIncreaseFrequancy {

    public static void swap(int n1, int n2) {
        int temp = n1;
        n1 = n2;
        n2 = temp;
    }

    // public static int[] frequencySort(int[] nums) {

    // int n = nums.length;
    // // Map<Integer, Integer> map = new HashMap<>();
    // int[] freqs = new int[n];

    // for (int i = 0; i < n; i++) {
    // freqs[nums[i]]++; // KHÔNG ĐƯỢC VÌ NẾU MẢNG nums CHỨA PHẦN TỬ ÂM SẼ XẢY RA
    // EXCEPTION. --> NÊN DÙNG HASHMAP
    // }

    // for (int i = 0; i < n; i++) { // { 2, 3, 1, 3, 2, 5, 5, 5 }
    // for (int j = i + 1; j < n - 1; j++) {
    // if (freqs[nums[i]] > freqs[nums[j]]) {
    // int temp = nums[i];
    // nums[i] = nums[j];
    // nums[j] = temp;
    // }
    // if (freqs[nums[i]] == freqs[nums[j]]) {
    // if (nums[i] < nums[j]) {
    // int temp = nums[i];
    // nums[i] = nums[j];
    // nums[j] = temp;
    // }
    // }
    // }
    // }

    // return nums;
    // }
    public static int[] frequencySort(int[] nums) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        // int[] freqs = new int[n];

        for (int i = 0; i < n; i++) { // 1,1,2,2,2,3
            if (map.containsKey(nums[i]) == false) {
                map.put(nums[i], 1);
            } else {
                int soLanXuatHien = map.get(nums[i]);
                soLanXuatHien++;
                map.put(nums[i], soLanXuatHien);
            }
        }
        // for (Map.Entry entry : map.entrySet()) {
        // System.out.println(entry.getKey() + " xuat hien " + entry.getValue() + "
        // lan");
        // }
        for (int i = 0; i < n; i++) { // { 1,1,2,2,2,3 } -> [3,1,1,2,2,2]
            for (int j = i + 1; j < n; j++) {
                if (map.get(nums[i]) > map.get(nums[j])) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                if (map.get(nums[i]) == map.get(nums[j])) {
                    if (nums[i] < nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        // int[] nums = { 2, 3, 1, 3, 2, 5, 5, 5 };// [1,1,2,2,2,3]
        // int[] nums = { 2, 3, 1, 3, 2, 5, 5, 5, 6, 6, -7, 7, 7, 7, 7 };
        int[] nums = { 1, 1, 2, 2, 2, 3 };
        int[] newArr = frequencySort(nums); // 0 1 2 2 0 3 0 0
        for (int i : newArr) {
            System.out.print(i + " ");
        }
    }
}
