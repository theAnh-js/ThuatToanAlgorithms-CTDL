package dp;

public class ClimbingStairs {

    // dung quy hoach dong - đệ quy có ghi nhớ.
    public int[] soBuoc = new int[46];

    public int tinhSoBuoc(int n) {
        if (soBuoc[n] == 0) { // nếu trong mảng chưa dk ghi nhớ vào thì mới tính
            soBuoc[n] = tinhSoBuoc(n - 1) + tinhSoBuoc(n - 2);
        }

        return soBuoc[n];
    }

    public int climbStairs(int n) {

        soBuoc[1] = 1;
        soBuoc[2] = 2;

        tinhSoBuoc(n);
        return soBuoc[n];
    }
}
