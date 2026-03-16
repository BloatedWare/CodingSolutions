import java.util.*;

public class SumThree {

    public boolean compareList(List<Integer> l1, List<Integer> l2) {
        HashMap<Integer, Integer> l2Map = new HashMap<>();
        int size2 = l2.size();
        // value -> occurence in l2 MAP
        for (int i = 0; i < size2; ++i) {
            int occ = 1;
            if (l2Map.containsKey(l2.get(i))) occ = l2Map.get(l2.get(i)) + 1; 
            l2Map.put(l2.get(i), occ);
        }

        for (var ele : l1) {
            if (l2Map.containsKey(ele) && l2Map.get(ele) > 0) {//if found and there is still more to find (occ > 0)
                l2Map.put(ele, l2Map.get(ele)-1);//decrement the occ count
            } else {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        /* List<Integer> numsList = new ArrayList<>();
        for (int x : nums) {
            numsList.add(x);
        } */

        //creates map of values -> occ
        for (int i = 0; i < nums.length; ++i) {
           int occ = 1; 
           if (numsMap.containsKey(nums[i])) occ = numsMap.get(nums[i]) + 1;
           numsMap.put(nums[i], occ);
        }

        int inverted = -1;
        for (int i = 0; i < nums.length; ++i) {
            inverted = -inverted;//flip it each time
            int value = -nums[i];
            int searchedValue;
            numsMap.put(nums[i], numsMap.get(nums[i]) - 1);
            for (int j = 0; j < nums.length; ++j) {
                if (j == i) continue;
                searchedValue = value - nums[j];
                if (numsMap.containsKey(searchedValue) && numsMap.get(searchedValue) > 0) {
                    if (searchedValue == nums[j] && numsMap.get(searchedValue) == 1) {
                        continue;// in this case nums[j] and searchedValue are the same so unless we have 2+ occ we can't use the same digit
                    }
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], searchedValue)));
                    numsMap.put(searchedValue, -numsMap.get(searchedValue));//setting occ to 0 because nums[j] and it's pair to form value are unique
                    numsMap.put(nums[j], -numsMap.get(nums[j]));
                }
            }
            numsMap.put(nums[i], numsMap.get(nums[i]) + 1);
           
            //reset hashMap negative occ back to positive
            for (int j = 0; j < nums.length; ++j) {
                if (numsMap.get(nums[j]) < 0) numsMap.put(nums[j], -numsMap.get(nums[j]));
            }
 
        }

        /* for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i+1; j < nums.length - 1; ++j) {
                for (int k = j+1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[k])));
                    }
                }
            }
        } */

        int rSize = result.size();
        for (int i = 0; i < rSize - 1; ++i) {
            for (int j = i+1; j < rSize; ++j) {
                if (compareList(result.get(i), result.get(j))) {
                    result.remove(i);
                    --i;
                    --rSize;
                    break;
                }
            }
        }


        return result;
    }
}