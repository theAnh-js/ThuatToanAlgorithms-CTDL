package dp;

import java.lang.reflect.Array;

public class MaximunSubarray {
    public static int maxSubArray(int[] nums) {
        int result = nums[0];

        // Cách 1: sử for loop -> phải dùng 3 vòng for -> tốn thời gian
        // Nên nếu làm trên leetcode sẽ xảy ra Time Limit Exceeded
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i; j < nums.length; j++) {
        // int sum_i_j = 0;
        // for (int k = i; k <= j; k++) {
        // sum_i_j += nums[k];
        // }
        // result = Math.max(result, sum_i_j);
        // }
        // }

        // Cách2: dùng quy hoạch động -> tận dụng kết quả của các phép tính trước
        // để tính phép tính tiếp theo.

        // int[] sum = new int[nums.length];

        // // Sử dụng kỹ thuật cộng dồn
        // // bai toan co so
        // sum[0] = nums[0];
        // // cong thuc truy hoi, cộng dồn lại lưu vào mảng sum
        // for (int i = 1; i < sum.length; i++) {
        // sum[i] = sum[i - 1] + nums[i];
        // }

        // // for (int i : sum) {
        // // System.out.print(i + " ");
        // // }

        // // tong i -> j
        // for (int i = 0; i < sum.length; i++) {
        // for (int j = i; j < sum.length; j++) {
        // int sum_i_j = sum[j] - sum[i] + nums[i];
        // result = Math.max(result, sum_i_j);
        // }
        // }

        // Cách 3 sẽ tối ưu nhất, không cần phải dùng các for loop lồng nhau
        int[] max = new int[nums.length];
        max[0] = nums[0];

        for (int i = 1; i < max.length; i++) {
            max[i] = Math.max(nums[i], nums[i] + max[i - 1]);
            result = Math.max(result, max[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(" -> " + maxSubArray(nums));

        int[] nums2 = { 5, 4, -1, 7, 8 };
        System.out.println(" -> " + maxSubArray(nums2));

    }
}
