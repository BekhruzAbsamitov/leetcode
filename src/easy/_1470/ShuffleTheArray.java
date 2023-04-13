package easy._1470;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{1,2,3,4,4,3,2,1}, 4)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0, j = 0, k=0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[k];
                k++;
            } else {
                res[i] = nums[n + j];
                j += 1;
            }
        }
        return res;
    }
}
