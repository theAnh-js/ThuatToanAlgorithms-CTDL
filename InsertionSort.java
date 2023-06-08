public class InsertionSort {

    // nguyên lý của thuật toán chèn là:
    // - Chạy từ vị trí 1 đến cuối mảng
    // - Tại mỗi vòng lặp, Nhúp phần tử arr[i] lên lưu vào 1 biến tạm,
    // so sánh với các số bên trái nó, và chèn nó vào vị trí thích hợp.
    // - Sau mỗi vòng lặp i, thì dãy từ [0, i] đã được sắp xếp.

    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {

            // nhúp 1 con bài lên, lưu nó vào 1 biến tạm
            int temp = arr[i];

            int j = i - 1;

            while (j >= 0 && temp < arr[j]) {
                // dịch chuyển thằng lớn hơn lên trước
                arr[j + 1] = arr[j];
                // giảm j xuống để tiếp tục so sánh và tìm vị trí để chèn temp vào,
                // vị trí đó là khi while sẽ dừng lại, nghĩa là khi j < 0,
                // hoặc khi temp > arr[j]
                j--;
            }

            // chèn con bài nhúp lên vào vị trị cần chèn.
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {

        // vòng 1 // 5 3 2 nhúp 3 lên -> 5 5 2
        // vòng 2 // 3 5 2 nhúp 2 lên -> 3 5 5 -> 3 3 5
        // vòng 3 // 2 3 5
        int[] arr = { 3, 5, 2, 6, 1, 0 };

        insertSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
