public class _1295_Find_Numbers_with_Even_Number_of_Digits {
    public static int findNumbers(int[] nums) {

        int count = 0;
        for (int x : nums) {
            if (tinhSoChuSo(x) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int tinhSoChuSo(int num) {

        int count = 0;
        int a = num; // 123
        while (a != 0) {
            a = a / 10;
            // a = num / 10;
            // num = a;
            count++;
        }
        return count;

    }

    public static void main(String[] args) {

        int[] nums = { 11, 2, 45, 2226, 44, 6666, 123, 33456 };

        // for (int x : nums) {
        // System.out.println(tinhSoChuSo(x));
        // }

        System.out.println(findNumbers(nums));

    }
}