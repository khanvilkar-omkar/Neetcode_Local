package TwoPointer;

import java.util.Arrays;
import java.util.Locale;

public class TwoPointerSolution {

    /**
     * isPalindrome
     * 
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!(s.charAt(i) == s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Two Integer Sum II
     * 
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                ans[0] = l + 1;
                ans[1] = r + 1;
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // // isPalindrome
        // String s = "Was it a car or a cat I saw?";
        // System.out.println(isPalindrome(s));

        // // Two Integer Sum II
        int[] numbers = { 2, 3, 4 };
        System.out.println(Arrays.toString(twoSum(numbers, 6)));
    }

}
