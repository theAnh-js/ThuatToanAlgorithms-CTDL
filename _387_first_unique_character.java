public class _387_first_unique_character {
    public static int firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        int[] count = new int[123]; // 123 phần tử này hiện đều có value default = 0

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = (int) c;
            count[index]++; // đếm, value default 0 sẽ tăng; ví dụ index = 108 thì count[108]++
                            // nghĩa là, giá trị 0 ở ví trị 108 sẽ được tăng thêm 1.
        }

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = (int) c;
            if (count[index] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
        System.out.println("abc".equals("acb"));
    }
}
