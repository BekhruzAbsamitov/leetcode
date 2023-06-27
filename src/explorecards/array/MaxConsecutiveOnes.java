package explorecards.array;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int maxCons = 0;

        for (int num : nums) {
            if (num == 1) {
                maxCons++;
                maxCount = Math.max(maxCons, maxCount);
            } else {
                maxCons = 0;
            }
        }
        return maxCount;
    }
}
