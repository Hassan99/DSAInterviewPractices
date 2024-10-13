package searching;

public class FindElementInMountainArray {
    public static void main(String[] args) {
        int[] mountainArray = {1, 2, 5, 8, 9, 10,12, 9, 4, 3, 1};
        int ans = findMaxElementInMountainArray(mountainArray);
        System.out.println(ans);
    }

    static int findMaxElementInMountainArray(int[] array) {

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > array[mid + 1]) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return array[start];
    }
}
