package Sort;

public class ThirdMaximumNumber414 {

    public void insert(long maxArr[], int val) {
        int i = 0;
        while (i < maxArr.length) {
            if (val == maxArr[i]) {
                return;
            } else if (val > maxArr[i]) {
                // insert vao vi tri maxArr[i]
                break;
            } else { // val < maxArr[i]
                i++;
            }
        }
        if (i < maxArr.length) {
            for (int j = maxArr.length - 2; j >= i; j--) {
                maxArr[j + 1] = maxArr[j];
            }
            maxArr[i] = val;
        }
    }

    public int thirdMax(int[] nums) {
        long[] maxArr = { Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE };

        for (int i = 0; i < nums.length; i++) {
            insert(maxArr, nums[i]);
        }

        if (maxArr[2] == Long.MIN_VALUE) {
            return (int) maxArr[0];
        }
        return (int) maxArr[2];
    }

    public static void main(String[] args) {

    }
}
