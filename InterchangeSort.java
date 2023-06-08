import java.util.Arrays;

public class InterchangeSort {

    public static void interChangeSort(int[] arr) {
        if (arr.length == 0)
            return;
        for (int i = 0; i < arr.length - 1; i++) { // cho i chạy từ đầu đến phần tử sát cuối
            for (int j = i + 1; j < arr.length; j++) { // cho j chạy trước i 1 step đến phần tử cuối cùng
                if (arr[i] > arr[j]) { // nếu phần tử trước lớn hơn pt sau thì swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 6, 2, 1, 0, 9, 8, 4, 3 };
        interChangeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
