package easy._1672;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        System.out.println(richestCustomerWealth(new int[3][3]));
    }

    public static int richestCustomerWealth(int[][] accounts) {
        int ans = 0;
        int m = accounts.length;
        for(int i = 0; i < m; i++) {
            int max = 0;
            for(int j = 0; j < accounts[i].length; j++) {
                max += accounts[i][j];
            }
            if (ans < max) {
                ans = max;
            }
        }
        return ans;
    }
}
