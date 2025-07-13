package searching.binarysearchinarray;

import java.util.Arrays;

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] array = {
                {10, 20, 30, 40},
                {12, 22, 33, 43},
                {15, 25, 35, 45},
                {18, 28, 38, 48}
        };
        System.out.println(Arrays.toString(implementedMatric(array, 35)));

    }

    static int[] matrixSearch(int[][] array, int target) {
        int r = 0;
        int c = array.length - 1;
        while (r < array.length && c >= 0) {

            if (array[r][c] == target) {
                return new int[]{r, c};
            }
            if (array[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[]{-1, -1};
    }


    /*
     * Below Code is implemented with understanding
     * */

    static int[] implementedMatric(int[][] array, int target) {
        int row = 0;
        int column = array.length - 1;

        while(row < array.length && column>=0){
            if(array[row][column]==target){
                return new int[]{row,column};
            }
            if(array[row][column]<target){
                row++;
            }else{
                column--;
            }
        }
        return new int[]{-1,-1};
    }
}
