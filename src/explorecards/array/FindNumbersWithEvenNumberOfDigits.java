package explorecards.array;

public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{555, 901, 482, 1771}));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (containsEvenNumberOfDigits(num)) {
                ++count;
            }
        }
        return count;
    }

    public static boolean containsEvenNumberOfDigits(int num) {
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count % 2 == 0;
    }
}
