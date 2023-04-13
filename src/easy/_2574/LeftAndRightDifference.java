package easy._2574;

import java.util.Arrays;

public class LeftAndRightDifference {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftRightDifference2(new int[]{10,4,8,3})));
    }

    public static int[] leftRightDifference(int[] nums) {
        int length = nums.length;
        int[] leftSum = new int[length];
        int[] rightSum = new int[length];
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int lSum = 0, rSum = 0;
            for (int j = 0; j < i; j++) {
                lSum += nums[j];
            }
            leftSum[i] = lSum;

            for (int j = length - 1; j >= length - i; j--) {
                rSum += nums[j];
            }
            rightSum[length - 1 - i] = rSum;

        }

        for (int i = 0; i < length; i++) {
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return result;
    }

    static int[] leftRightDifference2(int[] nums) {
        int rSum = 0;
        int[] result = new int[nums.length];
        for (int num : nums) {
            rSum += num;
        }
        int lSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rSum -= nums[i];
            result[i] = Math.abs(rSum - lSum);
            lSum += nums[i];
        }
        return result;
    }
}
