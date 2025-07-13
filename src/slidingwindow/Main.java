package slidingwindow;

public class Main {
    public static void main(String[] args) {
      Main main = new Main();
      int[] array = new int[]{5,3,6,5,9,8,6,5,8,4,8,};
        System.out.println(main.findMaximumTotalInArray(array,3));
    }
    int findMaximumTotalInArray(int[] array, int windowSize){
        int windowStart = 0;
        int end = 0;
        int maxSum = 0;
        int windowSum = 0;

        for(int windowEnd = 0; windowEnd<array.length;windowEnd++){
            windowSum+=array[windowEnd];
            if(windowEnd>=windowSize-1){
                maxSum = Math.max(windowSum,maxSum);
                windowSum-=array[windowStart];
                windowStart++;
            }
            end = windowEnd;
        }

        return maxSum;
    }
}