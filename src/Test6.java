import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Test6 {
    public static void main(String[] args) throws ParseException {

        int output = 0;

        System.err.println(">>> nums = [4,5,0,-2,-3,1], k = 5");
        output = subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        System.err.println(">>> output = " + output);
        System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        System.err.println(">>> nums = [5], k = 9");
        output = subarraysDivByK(new int[]{5}, 9);
        System.err.println(">>> output = " + output);
        System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    public static int subarraysDivByK(int[] nums, int k) {

        int ans = 0;
        int[] sum = new int[nums.length];
        Map<Integer, Integer> dup = new HashMap<>();

        sum[0] = (nums[0] % k + k) % k;
        for(int i = 1; i < nums.length; ++i) {

            sum[i] = sum[i - 1] + (nums[i] % k) + k;
            sum[i] %= k;

        }

        for(int i = 0; i < sum.length; ++i) {

            if (dup.containsKey(sum[i])) {
                ans += dup.get(sum[i]);
                dup.put(sum[i], dup.get(sum[i]) + 1);
            } else {
                dup.put(sum[i], 1);

                if (sum[i] == 0) {
                    ans++;
                    dup.put(sum[i], 2);
                }
            }
        }

        return ans;
    }
}
