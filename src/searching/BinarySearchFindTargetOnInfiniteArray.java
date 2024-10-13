package searching;

//In this code, we are not using array.length  variable.
public class BinarySearchFindTargetOnInfiniteArray {
    public static void main(String[] args) {
        int[] arrayofno = {5, 6, 8, 9, 10, 13, 14, 16, 27, 29, 32, 35, 40, 45, 60};
        char targetToFind = 13;
        int ans = searchRange(arrayofno, targetToFind);
        System.out.println(ans);
    }

    public static int searchRange(int[] nums, int target) {
        int start = 0;
        int end = 1;

        while (target > nums[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return findTargetInInfinitArray(nums, target, start, end);

    }


    static int findTargetInInfinitArray(int[] argChar, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (argChar[mid] < target) {
                start = mid + 1;
            } else if (argChar[mid] > target) {
                end = mid - 1;
            } else if (argChar[mid] == target) {
                return mid;
            }
        }

        return -1;
    }


}
