package searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arrayofno = {2, 4, 6, 7, 8, 9, 22, 55, 66, 77, 88, 89, 100};
        int targetToFind = 98;
        int ans = getIndexOfTargetNumber(arrayofno, targetToFind);
        System.out.println(ans);
    }

    static int getIndexOfTargetNumber(int[] argNo, int target) {

        int start = 0;
        int end = argNo.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (argNo[mid] < target) {
                start = mid + 1;
            } else if (argNo[mid] > target) {
                end = mid - 1;
            } else if (argNo[mid] == target) {
                return mid;
            }

        }

        return -1;
    }


}
