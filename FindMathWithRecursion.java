public class FindMathWithRecursion {

    // Phân loại đệ quy:
    // - Not returns result:
    // Áp dụng cho hầu hết các bài toán(nếu có sd đệ quy)
    // Những bài toán hay lưu kết quả(DP - quy hoạch động, ad-hoc,...)

    // - Returns result:
    // Áp dụng cho những Cấu Trúc Dữ Liệu có tính đệ quy(linked list, tree,...)
    // Ngắn gọn, sạch sẽ, dễ hiểu(nếu đã hiểu đệ quy :)) )

    // find max with 2 ways

    // Không trả về kết quả (thì ta sẽ phải gán kết quả vào 1 biến nào đó)
    private static int maxNum = -1;

    public static void findMax(int[] arr, int i) {
        if (i < arr.length) {
            if (maxNum < arr[i]) {
                maxNum = arr[i];
                findMax(arr, i + 1);
            }
        }
    }

    // Trả về kết quả
    public static int findMaxV2(int[] arr, int i, int previousNum) {
        if (i < arr.length) {
            // if (previousNum < arr[i]) {
            // previousNum = arr[i];
            // }
            int curNum = Math.max(arr[i], previousNum);
            return findMaxV2(arr, i + 1, curNum);
        }
        return previousNum;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 300, 4, 5, 6, 75, 8, 9, 10, 11, 39 };
        findMax(arr, 0);
        System.out.println(maxNum);

        int previousNum = -1;
        System.out.println(findMaxV2(arr, 0, previousNum));

    }
}
