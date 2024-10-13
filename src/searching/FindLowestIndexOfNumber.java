package searching;

public class FindLowestIndexOfNumber {
    public static void main(String[] args) {
        int[] arry = new int[]{1, 2, 3, 4,5,5,3, 1};
        MountainArray mountainArray = new MountainArrayImpl(arry);
        System.out.println(findInMountainArray(5, mountainArray));

    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeak(mountainArr);

        // Search in the ascending part
        int index = binarySearch(mountainArr, target, 0, peakIndex, true);
        if (index != -1) {
            return index;
        }

        // Search in the descending part
        return binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length() - 1, false);
    }

    // Function to find the peak element in the mountain array
    private static int findPeak(MountainArray mountainArr) {
        int start = 0, end = mountainArr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // Binary search function
    private static int binarySearch(MountainArray mountainArr, int target, int start, int end, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = mountainArr.get(mid);

            if (midValue == target) {
                return mid;
            }

            if (ascending) {
                if (midValue < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (midValue < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

interface MountainArray {
    public int get(int index);  // Fetches the element at the specified index

    public int length();        // Returns the length of the array
}

class MountainArrayImpl implements MountainArray {
    private int[] arr;

    public MountainArrayImpl(int[] array) {
        this.arr = array;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }
}