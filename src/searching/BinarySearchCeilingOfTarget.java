package searching;

public class BinarySearchCeilingOfTarget {
    public static void main(String[] args) {
        int[] arrayofno = {2, 4, 6, 7, 8, 9, 22, 55, 66, 77, 88, 89, 100};
        int targetToFind = 98;
        int ans = getFloorOfTheTargetNo(arrayofno, targetToFind);
        System.out.println(ans);
    }


    static int getCeilingOfTheTargetNo(int[] argNo, int target) {

        int start = 0;
        int end = argNo.length;

        if (argNo[argNo.length - 1] < target) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (argNo[mid] < target) {
                start = mid + 1;
            } else if (argNo[mid] > target) {
                end = mid - 1;
            } else if (argNo[mid] == target) {
                return argNo[mid];
            }
        }

        return argNo[start];
    }

    static int getFloorOfTheTargetNo(int[] argNo, int target) {

        int start = 0;
        int end = argNo.length;

        if (argNo[argNo.length - 1] < target) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (argNo[mid] < target) {
                start = mid + 1;
            } else if (argNo[mid] > target) {
                end = mid - 1;
            } else if (argNo[mid] == target) {
                return argNo[mid];
            }
        }

        return argNo[end];
    }
}
