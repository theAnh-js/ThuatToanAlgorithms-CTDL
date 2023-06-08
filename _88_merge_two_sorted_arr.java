public class _88_merge_two_sorted_arr {

    public static void merge(int[] n1, int m, int[] n2, int n) {

        for (int x : n2) {
            chenVaoN1(x, n1, m);
            m++;
        }

        for (int x : n1) {
            System.out.println(x);
        }
    }

    public static void chenVaoN1(int x, int[] n1, int m) {
        boolean timDuocK = false;
        for (int k = 0; k < m; k++) {
            if (x < n1[k]) {
                timDuocK = true;

                for (int i = m - 1; i >= k; i--) {
                    n1[i + 1] = n1[i];
                }

                n1[k] = x;
                break;

            }
        }
        if (timDuocK == false) {
            n1[m] = x;
        }

    }

    public static void mergeV2(int[] n1, int m, int[] n2, int n) {
        // Sử dụng kĩ thuật 2 con trỏ
        int i = m - 1;
        int j = n - 1;
        int k = (m + n) - 1;

        while (k >= 0) {
            if (i < 0) {
                n1[k] = n2[j];
                j--;
            } else if (j < 0) {
                n1[k] = n1[i];
                i--;
            } else if (n1[i] > n2[j]) {
                n1[k] = n1[i];
                i--;
            } else {
                n1[k] = n2[j];
                j--;
            }
            k--;
        }

        for (int x : n1) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        int[] n1 = { 2, 4, 5, 7, 0, 0, 0 };
        int m = 4;
        int[] n2 = { 1, 3, 5 };
        int n = 3;

        // merge(n1, m, n2, n);
        System.out.println("------------------");
        mergeV2(n1, m, n2, n);

    }
}
