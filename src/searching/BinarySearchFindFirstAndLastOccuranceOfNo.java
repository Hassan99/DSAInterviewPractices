package searching;

import java.util.Arrays;

public class BinarySearchFindFirstAndLastOccuranceOfNo {
    public static void main(String[] args) {
        int[] arrayofno = {5,6,8,9,10,13,14,14,14,14,16,27,29,29,29,29,29,32,35,40,45,60};
        char targetToFind = 14;
        int[] ans = searchRange(arrayofno, targetToFind);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        ans[0] = findFirstAndLastOccuranceOfNo(nums, target, true);
        ans[1] = findFirstAndLastOccuranceOfNo(nums, target, false);

        return ans;
    }


     static int findFirstAndLastOccuranceOfNo(int[] argChar, int target, boolean isFirstIndex) {

        int ans = -1;
        int start = 0;
        int end = argChar.length - 1;


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (argChar[mid] < target) {
                start = mid + 1;
            } else if (argChar[mid] > target) {
                end = mid - 1;
            } else if (argChar[mid] == target) {
                ans = mid;
                if (!isFirstIndex) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return ans;
    }


}
