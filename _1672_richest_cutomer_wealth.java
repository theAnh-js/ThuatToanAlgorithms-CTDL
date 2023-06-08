public class _1672_richest_cutomer_wealth {
    public static int maximumWealth(int[][] accounts) {

        int soKhachHang = accounts.length;
        int soNganHang = accounts[0].length;
        // int[] tongTien = new int[soKhachHang];
        int max = 0;
        for (int i = 0; i < soKhachHang; i++) {
            int tienMoiKH = 0;
            for (int j = 0; j < soNganHang; j++) {
                tienMoiKH += accounts[i][j];
            }
            if (max < tienMoiKH) {
                max = tienMoiKH;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] accounts = { { 1, 2, 4 }, { 2, 3, 1 } };
        int[][] accounts2 = { { 1, 2, 4, 3, 5 }, { 2, 3, 1, 7, 4 }, { 2, 9, 1, 7, 4 } };

        System.out.println(maximumWealth(accounts2));

    }
}
