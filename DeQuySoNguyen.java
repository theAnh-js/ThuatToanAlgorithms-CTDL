public class DeQuySoNguyen {

    public static void printElement(int[] arr, int index) {

        if (index >= arr.length)
            return;

        System.out.print(arr[index] + " ");
        printElement(arr, index + 1);

    }

    public static void printElementV2(int[] arr, int index) {

        if (index < 0 || index >= arr.length)
            return;

        printElementV2(arr, index + 1);
        System.out.print(arr[index] + " ");
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        // printElement(arr, 0);
        // System.out.println("");
        printElementV2(arr, 0);
    }
}
