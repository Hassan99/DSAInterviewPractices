package Interviewquestions;

import java.util.HashSet;

class ContainsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4};
       /* numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 1;*/


        ContainsDuplicateSolution containsDuplicateSolution = new ContainsDuplicateSolution();
        if (containsDuplicateSolution.containsDuplicate(numbers)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}