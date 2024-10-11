package searching;

public class BinarySearchSmallestNoGrtThnTrgt {
    public static void main(String[] args) {
        char[] arrayofno = {'c','f','g','i','k','m','q','t'};
        char targetToFind = 'z';
        char ans = nextGreatestLetter(arrayofno, targetToFind);
        System.out.println(ans);
    }


    static char getSmallestChrGrtThnTrgt(char[] argChar, int target) {

        int start = 0;
        int end = argChar.length-1;


        while (start <=end) {
            int mid = start + (end - start) / 2;
            if (argChar[mid] < target) {
                start = mid + 1;
            } else if (argChar[mid] > target) {
                end = mid - 1;
            }else if(argChar[mid]==target){
                return argChar[mid+1];
            }
        }

        return argChar[start % argChar.length];
    }
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        while (start <=end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] < target) {
                start = mid + 1;
            } else if (letters[mid] > target) {
                end = mid - 1;
            }
        }

        return letters[start % letters.length];
    }

}
