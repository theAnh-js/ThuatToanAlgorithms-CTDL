public class MergeSort {

    public static int[] mergeSort(int[] arr, int L, int R) {

        // điều kiện dừng
        if (L >= R) {
            int[] newArr = { arr[L] };
            return newArr;
        }

        // chia nhỏ mảng lớn ra, cho đến khi nào mỗi phần tử là 1 mảng
        int k = (L + R) / 2;
        int[] a1 = mergeSort(arr, L, k);
        int[] a2 = mergeSort(arr, k + 1, R);

        // trộn(merger) các mảng được chia nhỏ vào thành 1
        int n = a1.length + a2.length;
        int[] a = new int[n];
        int i = 0; // index của mảng a
        int i1 = 0; // index trỏ đến mảng a1;
        int i2 = 0; // index trỏ đến mảng a2;

        while (i < n) { // khi mảng a chưa đầy
            if (i1 < a1.length && i2 < a2.length) { // khi cả a1 và a2 đều có phần tử ở trong
                if (a1[i1] < a2[i2]) {
                    a[i] = a1[i1];
                    i++;
                    i1++;
                } else { // khi a1[i1] > a2[i2]
                    a[i] = a2[i2];
                    i++;
                    i2++;
                }
            } else { // khi 1 trong 2 mảng con rỗng
                if (i1 < a1.length) { // khi mảng con a1 chứa phần tử, a2 rỗng
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

    public static int[] arrSort(int[] arr) {

        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {

        int[] arr1 = { 2, 5, 6, 9 };
        int[] arr2 = { 1, 3, 4, 7, 8, 10 };

        int[] arr = { 4, 36, 6, 3, 2, 7, 2, 1, 0 };
        int[] sortedArr = arrSort(arr);
        for (int i : sortedArr) {
            System.out.print(i + " ");
        }
    }

}
