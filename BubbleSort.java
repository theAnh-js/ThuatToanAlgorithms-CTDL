public class BubbleSort {

    // Tại sao lại gọi là Sắp xếp nổi bọt, nguyên lý:
    // giả sử ta sắp xếp tăng dần, bé -> lớn
    // - Chạy từ đầu đến cuối mảng.
    // - Nếu phần tử đứng trước(arr[j]) lớn hơn phần tử đứng sau(arr[j + 1])
    // thì ta đổi chỗ 2 phần tử đó cho nhau.
    // - Như vậy sau mỗi vòng lặp lớn ở ngoài, phần tử lớn nhất sẽ
    // được trôi xuông dưới -> nổi bọt
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // lặp từ đầu đến phần tử cuối cùng của mảng
        for (int i = 0; i < n; i++) {
            // lặp từ đầu đến phần tử gần cuối, và sau mỗi vòng lặp lớp
            // thì vòng lặp nhỏ sẽ giảm đi i vòng, vì lúc này những phần
            // tử lớn nhất đã được trôi xuống dưới theo thứ tự rồi,
            // nên ko cần lặp đến nữa.
            for (int j = 0; j + 1 < n - i; j++) {
                // viết lại là: j < n - 1 - i
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 6, 6, 9, 4, 0 };

        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}