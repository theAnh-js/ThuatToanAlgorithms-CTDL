import java.util.Arrays;

public class DoPhucTapBigO {

    // Làm thế nào để đánh giá 1 chương trình có tốt/hiệu quả hay ko?
    // --> Bộ nhớ(Space complexity) và Thời gian(Time complexity)

    // * Bộ nhớ (Space complexity)
    // Là bộ nhớ mà chương trình/ thuật toán cần sd khi thực thi/run chương trình
    // đó.
    // O(1): khi chỉ sử dụng 1 bộ nhớ cố định.
    // O(n), O(n^2): thay đổi theo input của bài toán.
    // ==> mục tiêu: tối ưu bộ nhớ: có 2 cách
    // - tối ưu cách làm/phương pháp
    // - nâng cấp bộ nhớ(update hardware)

    // * Thời gian (Time complexity)
    // Làm sao để biết 1 chương trình chạy nhanh hay chậm?
    // ====> Dùng định nghĩa Big O
    // Là độ phức tạp về thời gian, là tổng thời gian/số phép tính mà
    // chương trình cần để thực thi chương trình.
    // f(n) <= C.g(n)

    // CÁC độ phức tạp cơ bản:
    // O(n) độ phức tạp hằng số
    // O(log n) dpt logarit
    // O(n) dpt tuyến tính
    // O(n^k) dpt đa thức
    // O(k^n) dpt hàm mũ

    // Quy tắc cộng: O = O(k1) + O(k2) =O(n)
    // Quy tắc nhân: O = O(k1) * O(k2) = O(n^2)

    // Khi nói đến độ phức tạp, ta sẽ nói đến tình huống xấu nhất,
    // worst case

    // Độ phức tạp của một số thuật toán cơ bản:
    // Tìm kiếm nhị phân : O(log n)
    // Tìm kiếm tuần tự: O(n)
    // Sắp xếp nổi bọt, Duyệt ma trận 2 chiều: O(n^2)
    // Fibonaci: O(2^n)

    public static int findIndex(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
        // Đánh giá:
        // best case: tìm đk ngay x ở đầu mảng -> O(1)
        // Worst case: tìm thấy ở cuối mảng hoặc ko tìm thấy -> O(2n), vì phải lặp hết
        // mảng và thực hiện phép so sánh
        // mà O(2n) được coi bằng O(n) -> O(n)
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // Có 2 vòng for lồng nhau, áp dụng quy tắc nhân
                                      // nên ta cho nó đại khái là O(n^2)
            boolean isSwap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    isSwap = true;
                }
            }
            if (isSwap == false) {
                break;
            }

        }

    }

    // Đệ quy để tìm số fibonacy thứ n
    public static int fibo(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2); // Độ phức tạp: 2^n
    }

    // Tìm kiếm nhị phân KHÔNG dùng đệ quy : O(log n)
    public static int searchBinary(int[] arr, int x) {
        int n = arr.length;

        int iL = 0;
        int iR = n - 1;
        while (iL <= iR) {
            int iM = (iL + iR) / 2;
            if (arr[iM] == x) {
                return iM;
            } else if (arr[iM] > x) {
                iR = iM - 1;
            } else {
                iL = iM + 1;
            }
        }
        return -1; // neu ko tim thay
    }

    // Tìm kiếm nhị phân dùng đệ quy
    public static int bSearchRecursive(int[] arr, int x, int L, int R) {
        // thời gian tìm kiếm của thuật toán nhị phân phụ thuộc vào size/khoảng cách của
        // L và R
        // khoảng cách của L và R càng rộng thì càng tốn time.

        int iL = L;
        int iR = R;
        // dieu kien dung
        if (iL > iR)
            return -1;

        // bổ đôi
        int iM = (iL + iR) / 2;

        // nếu gặp thì return
        if (arr[iM] == x)
            return iM;

        // không thì lại tiếp tục đệ quy để bổ đôi.
        if (arr[iM] > x)
            return bSearchRecursive(arr, x, iL, iR - 1);
        return bSearchRecursive(arr, x, iL + 1, iR);

    }

    public static int bSearch(int[] arr, int x) {
        return bSearchRecursive(arr, x, 0, arr.length - 1);
    }

    // Thuật toán sắp xếp trộn - Merge sort: log2n*n
    public static int[] merge(int[] arr, int L, int R) {
        int iL = L;
        int iR = R;

        // dieu kien dung
        if (iL >= iR) {
            int[] newArr = { arr[iL] };
            return newArr;
        }

        // chia ra đến khi mỗi mảng là 1 phần tử
        int k = (iL + iR) / 2;
        int[] a1 = merge(arr, iL, k); // mang trai
        int[] a2 = merge(arr, k + 1, iR); // mang phai

        // chia xong rồi thì trộn vào 1 mảng chung
        int n = a1.length + a2.length;
        int[] a = new int[n];
        int i = 0; // index tro a
        int i1 = 0; // index trỏ mảng a1
        int i2 = 0; // index trỏ mảng a2
        while (i < n) {
            // nếu cả 2 mảng a1 và a2 chứa phần tử
            if (i1 < a1.length && i2 < a2.length) {
                if (a1[i1] < a2[i2]) {
                    a[i] = a1[i1];
                    i++;
                    i1++;
                } else {
                    a[i] = a2[i2];
                    i++;
                    i2++;
                }
            } else {
                if (i1 < a1.length) {
                    a[i] = a1[i1];
                    i++;
                    i1++;
                } else {
                    a[i] = a2[i2];
                    i++;
                    i2++;
                }
            }

        }

        return a;

    }

    public static int[] mySort(int[] arr) {
        return merge(arr, 0, arr.length - 1);
    }

    // Thuật toán Quick sort: worse case: n^2; best case: nlogn
    public static void quickSort(int[] arr, int L, int R) {
        // điều kiện dừng
        if (L >= R)
            return;

        // chọn pivot ban đầu
        int pivot = arr[((L + R) / 2)];

        // phân bổ/săp xếp lại mảng theo pivot -> Trị đã
        int k = partition(arr, pivot, L, R); // k trở thành pivot mới

        // Chia các mảng được phân bổ nhỏ ra -> Chia
        quickSort(arr, L, k - 1);
        quickSort(arr, k, R);
    }

    public static int partition(int[] arr, int pivot, int L, int R) {

        while (L <= R) {
            while (arr[L] < pivot) {
                L++;
            }
            while (arr[R] > pivot) {
                R--;
            }
            if (L <= R) {
                int temp = arr[L];
                arr[L] = arr[R];
                arr[R] = temp;
                L++;
                R--;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int x = 1;

        findIndex(arr, x);

        System.out.println("-----------");
        int[] arr1 = { 3, 6, 2, 1, 10, 5, 9, 2, 6 };
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        System.out.println("-----------");
        int[] arr2 = { 4, 67, 62, 1, 10, 5, 9, 2, 6 };
        System.out.println(searchBinary(arr2, 10));

        System.out.println("-----------");
        System.out.println(bSearch(arr2, 10));

        System.out.println("-----------");
        int[] arr3 = { 4, 2, 6, 2, 1, 10, 5, 9, 9, 3, 6 };
        System.out.println(Arrays.toString(mySort(arr3)));

        System.out.println("-----------");
        int[] arr4 = { 6, 3, 0, 1, 10, 5, 11 };
        quickSort(arr4, 0, arr4.length - 1);
        System.out.println(Arrays.toString(arr4));
    }

}
