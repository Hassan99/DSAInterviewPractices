
//https://leetcode.com/problems/jump-game/description/

public class JumpGame {
    public static void main(String[] args) {
        int[] array = {2,3,1,1,4};
//        int[] array = {0,1};
        System.out.println(canJumpChat(array));
    }
    public static boolean canJump(int[] nums) {
        int start = 1;
        boolean isReached = false; // declare by default false value
        while(nums.length >= 1 && start <= nums.length-1){ //check the start is greater than one and start is less than or equal to nums.length -1
            int value = nums[start];//Receives the value of an array
            if(value<=0){
                break;
            }
            start = start+value;
            if(start == nums.length -1){
                return true;
            }
            //updating the value with Start
        }
        return nums.length <= 1;
    }
    public static boolean canJumpChat(int[] nums) {
        int maxReach = 0;  // Track the furthest index we can reach

        for (int i = 0; i < nums.length; i++) {
            // If we can't reach this index, return false
            if (i > maxReach) {
                return false;
            }
            // Update the furthest we can reach from this index
            maxReach = Math.max(maxReach, i + nums[i]);

            // If we can reach or pass the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
