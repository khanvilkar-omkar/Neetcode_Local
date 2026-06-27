package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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

    /**
     * 3Sum
     * https://www.youtube.com/watch?v=cRBSOz49fQk
     * 
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return new ArrayList<>(result);
    }

    /**
     * Container With Most Water
     * 
     * @param heights
     * @return
     */
    public static int maxArea(int[] heights) {
        // int ans = 0;
        // for (int left = 0; left < heights.length; left++) {
        // int right = heights.length - 1;
        // while (left < right) {
        // int area = Math.min(heights[left], heights[right]) * (right - left);
        // // System.out.println(area);
        // ans = Math.max(ans, area);
        // right--;
        // }

        // }
        // return ans;

        int ans = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            ans = Math.max(area, ans);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // // isPalindrome
        // String s = "Was it a car or a cat I saw?";
        // System.out.println(isPalindrome(s));

        // // Two Integer Sum II
        // int[] numbers = { 2, 3, 4 };
        // System.out.println(Arrays.toString(twoSum(numbers, 6)));

        // // 3Sum
        // int[] nums = { -1, 0, 1, 2, -1, -4 };
        // System.out.println(threeSum(nums));

        // // Container With Most Water
        int[] height = { 1, 7, 2, 5, 4, 7, 3, 6 };
        System.out.println(maxArea(height));

    }

}
