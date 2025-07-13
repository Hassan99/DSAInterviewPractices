import Interviewquestions.HashMap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/two-sum/


public class TwoSums {
    public static void main(String[] args) {

        int[] array = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumChat(array,target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> db  = IntStream.range(0, nums.length)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> nums[i]));

        int[]  foundIndex = {-1,-1};
        for(int i=0;i<nums.length;i++){
            int value = nums[i];
            int balanceValue = target - value;
            if(db.containsValue(balanceValue)){
                foundIndex[0] = i;
                for (int key : db.keySet()) {
                    if (db.get(key) == balanceValue) {
                        foundIndex[1] = key;
                        return foundIndex;
                    }
                }
            }
        }
        return foundIndex;
    }

    public static int[] twoSumChat(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}
