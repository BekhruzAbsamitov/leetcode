package easy._1512;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs2(new int[]{1, 1, 1, 1}));
    }

    public static int numIdenticalPairs(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ans++;
                }
            }

        }
        return ans;
    }

    public static int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int friend : nums) {
            int friendCount = hm.getOrDefault(friend, 0);
            ans += friendCount;
            hm.put(friend, friendCount + 1);
        }
        return ans;
    }

}
