public class _283_move_zeroes {
    public static void moveZeroes(int[] nums) {

        int n = nums.length;
        int curentIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[curentIndex] = nums[i];
                curentIndex++;
            }
        }

        for (; curentIndex < n; curentIndex++) {
            nums[curentIndex] = 0;
        }

        for (int i : nums) {
            System.out.print(i);
        }
    }

    public static void main(String[] args) {

        int[] nums = { 0, 2, 4, 0, 0, 3 };
        moveZeroes(nums);
    }
}
