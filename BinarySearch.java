public class BinarySearch {

    // Thuật toán tìm kiếm nhịn phân
    // - Kỹ thuật tìm kiếm trong một mảng Đã Được Sắp Xếp
    // - VD: tìm trang sách 127 -> bổ đôi ra -> lại bổ đôi ra để thu hẹp phạm vi tìm
    // Ý tưởng: Chia để trị

    // Cài đặt thuật toán: dùng vòng lặp và dùng đệ quy

    // Dùng vòng lặp:
    public static int binarySearch(int[] arr, int key) {

        int n = arr.length;
        int iLeft = 0;
        int iRight = n - 1;
        for (int i = 0; i < n; i++) {

            if (iLeft <= iRight) {
                int iMid = (iLeft + iRight) / 2;
                if (arr[iMid] == key) {
                    return iMid;
                } else if (arr[iMid] > key) {
                    iRight = iMid - 1;
                } else {
                    iLeft = iMid + 1;
                }
            }
        }
        return -1;
    }

    // Sử dụng đệ quy
    public static int bSearch(int[] arr, int key, int iLeft, int iRight) {
        while (iLeft <= iRight) {
            int iMid = (iLeft + iRight) / 2;
            if (arr[iMid] == key) {
                return iMid;
            } else if (arr[iMid] > key) {
                iRight = iMid - 1;
            } else {
                iLeft = iMid + 1;
            }
        }
        return -1;
    }

    public static int bSearch(int[] arr, int key) {
        int iLeft = 0;
        int iRight = arr.length - 1;
        return bSearch(arr, key, iLeft, iRight);
    }

    public static void main(String[] args) {
        int[] arr = { 22, 34, 53, 65, 67, 77, 78, 83, 85, 99 };
        // search index of 83
        System.out.println(binarySearch(arr, 83)); // output: 7
        System.out.println(binarySearch(arr, 22)); // output: 0
        System.out.println(binarySearch(arr, 65)); // output: 3

        System.out.println("---------------");
        System.out.println(bSearch(arr, 83)); // output: 7
        System.out.println(bSearch(arr, 22)); // output: 0
        System.out.println(bSearch(arr, 65)); // output: 3
    }
}
