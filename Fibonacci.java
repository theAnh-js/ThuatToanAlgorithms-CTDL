public class Fibonacci {

    public static int fib(int n) {
        if (n == 0 || n == 1)
            return n;

        return fib(n - 1) + fib(n - 2);

    }

    // Đệ quy có nhớ. Sử dụng hàm F để lưu các kết quả của FibV2[] vào
    static int[] F = new int[1000];

    public static int FibV2(int n) {
        if (F[n] != 0) {
            return F[n];
        }
        if (n == 1 || n == 2) {
            // F[0] = 0;
            F[1] = 1;
            F[2] = 1;
            return 1;
        }
        if (n == 0) {
            F[0] = 0;
            return 0;
        }
        F[n] = FibV2(n - 1) + FibV2(n - 2);

        return F[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(10));

        System.out.println("-------------------");
        // khi dùng hàm tối ưu đệ quy
        System.out.println(FibV2(0));
        System.out.println(FibV2(1));
        System.out.println(FibV2(2));
        System.out.println(FibV2(3));
        System.out.println(FibV2(10));

        System.out.println("-------------------");
        // Cách khử để quy (Không dùng đệ quy)
        int[] FiboArr = new int[11];
        FiboArr[1] = 1;
        FiboArr[2] = 1;
        for (int i = 3; i < FiboArr.length; i++) {
            FiboArr[i] = FiboArr[i - 1] + FiboArr[i - 2];
        }

        for (int i : FiboArr) {
            System.out.print(i + " ");
        }
        System.out.println("Gia tri so fibonacy o index so 10 la: " + FiboArr[10]);
    }
}
