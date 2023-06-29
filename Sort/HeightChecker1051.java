package Sort;

public class HeightChecker1051 {
    public static int heightChecker(int[] heights) {
        int n = heights.length;
        int[] copy = new int[n];

        for (int i = 0; i < n; i++) {
            copy[i] = heights[i];
        }

        for (int j = 0; j < n; j++) {
            int minIndex = j;
            for (int k = j + 1; k < n; k++) {
                if (copy[minIndex] > copy[k]) {
                    minIndex = k;
                }
            }
            System.out.println(minIndex);
            if (minIndex != j) {
                int temp = copy[minIndex];
                copy[minIndex] = copy[j];
                copy[j] = temp;
            }
            // for (int i = j + 1; i < n; i++) {
            // if (copy[j] > copy[i]) {
            // int temp = copy[i];
            // copy[i] = copy[j];
            // copy[j] = temp;
            // }
            // }
        }

        for (int i : copy) {
            System.out.print(i + " ");
        }
        int count = 0;
        for (int m = 0; m < n; m++) {
            if (copy[m] != heights[m]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 4, 2, 1, 3 };
        heightChecker(arr);
    }
}
