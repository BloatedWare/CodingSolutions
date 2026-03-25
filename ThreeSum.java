import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class ThreeSum{

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int i, j ,k, sum;
        Arrays.sort(nums);
        for (i = 0;i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) break;
            j = i+1;
            k = nums.length-1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    k--;
                    while (k > j && nums[k] == nums[k+1]) k--;
                    j++;
                    while (j < k && nums[j] == nums[j-1]) j++;
                }
            }
        }

        return res;

    }
}