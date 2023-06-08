public class _27_remove_element {
    public static int removeElement(int[] nums, int val) {

        int n = nums.length;
        for (int i = 0; i < n;) {
            if (nums[i] == val) {

                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                n--;
            } else {
                i++;
            }
        }

        System.out.println(n);
        return n;
    }

    public static int removeElementV2(int[] nums, int val) {

        // sử dụng kĩ thuật 2 con trỏ
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4, 2, 8, 2, 8 };
        // removeElement(nums, 2);
        System.out.println(removeElementV2(nums, 2));
    }
}
