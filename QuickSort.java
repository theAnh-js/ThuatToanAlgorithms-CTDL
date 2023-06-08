import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int L, int R) {

        // Dieu kien dung
        if (L >= R)
            return;

        // chọn khóa/ pivot
        int key = arr[((L + R) / 2)];

        // phân bổ lại mảng theo khóa -> Trị trước
        int k = partition(arr, L, R, key);
        System.out.println("L= " + L + " R= " + R + " key=" + k);
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, L, R + 1)));

        System.out.println("-----------------");
        // chia đôi mảng, chia-> lặp lại nên dùng đệ quy -> Rồi chia
        quickSort(arr, L, k - 1); // đệ quy để sắp xếp mảng bên trái của pivot, mảng này chứa những phần tử nhỏ
                                  // hơn pivot
        quickSort(arr, k, R); // đẹ quy để sắp xếp mảng bên phải của pivot, bao gồm cả pivot, mảng này chứa
                              // những phần tử lớn hơn pivot

    }

    public static int partition(int[] arr, int L, int R, int key) {

        int iL = L;
        int iR = R;

        while (iL <= iR) {
            while (arr[iL] < key) { // chạy cho đến khi nào đk này sai, khi đó ta iL sẽ trỏ đến phần tử > key.
                iL++;
            }
            while (arr[iR] > key) { // chạy cho đến khi nào đk này sai, khi đó ta iR sẽ trỏ đến phần tử < key.
                iR--;
            }

            // Khi 2 vòng while trên kết thúc -> ta tìm được 2 số cần phải hoán đổi vị trí
            // cho nhau.
            if (iL <= iR) {
                int temp = arr[iL];
                arr[iL] = arr[iR];
                arr[iR] = temp;
                iL++;
                iR--;
            }
        }
        return iL;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 0, 5, 6, 7, 8, 9, 11, 4, 10, 1 };
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

}
