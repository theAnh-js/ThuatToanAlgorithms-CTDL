public class SelectionSort {

    public static void SelectSort(int[] arr) {
        // nguyên lý của sắp xếp chọn:
        // Chạy từ đầu đến cuối mảng
        // Sau mỗi vòng lặp ngoài thì tìm ra phần tử nhỏ nhất từ
        // i + 1 đến n - 1, bằng cách so sánh với arr[i],
        // nếu arr[i] lớn hơn thì đối chỗ cho arr[i]
        // Sau mỗi vòng lặp ngoài ta tìm được phần tử nhỏ nhất cho lên đầu mảng,
        // nghĩa là đoạn [0, i] đã được sắp xếp.

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 6, 0, 3, 9 };
        SelectSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
