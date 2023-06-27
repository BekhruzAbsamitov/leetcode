package explorecards.array;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int valid_size = 0;
        if (nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[valid_size] = nums[i];
                valid_size++;
            }
        }
        return valid_size;
    }
}
