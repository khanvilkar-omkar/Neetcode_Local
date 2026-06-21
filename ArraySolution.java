import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArraySolution {
    /**
     * Contains Duplicate
     * 
     * @param nums
     * @return
     */
    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueNum = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniqueNum.contains(nums[i])) {
                return true;
            } else {
                uniqueNum.add(nums[i]);
            }
        }
        return false;
    }

    /**
     * Valid Anagram
     * 
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else {
            HashMap<Character, Integer> countS = new HashMap<>();
            HashMap<Character, Integer> countT = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
                countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
            }
            return countS.equals(countT);
        }
    }

    /**
     * Two Sum
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        // // Solution 1
        // HashMap<Integer, Integer> index = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        // index.put(nums[i], i);
        // }
        // for (int i = 0; i < nums.length; i++) {
        // int diff = target - nums[i];
        // if (index.get(diff) != i && index.containsKey(diff)) {
        // return new int[] { i, index.get(diff) };
        // }
        // }
        // return new int[0];

        // // Solution 2
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (index.containsKey(diff)) {
                return new int[] { index.get(diff), i };
            } else {
                index.put(nums[i], i);
            }
        }
        return new int[0];
    }

    /**
     * Group Anagrams
     * 
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            anagramGroups.putIfAbsent(key, new ArrayList<>());
            anagramGroups.get(key).add(s);
        }
        return new ArrayList<>(anagramGroups.values());
    }

    /**
     * Top K Frequent Elements
     * 
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // Map<Integer, Integer> mapping = new HashMap<>();
        // for (int n : nums) {
        //     if (mapping.containsKey(n)) {
        //         mapping.put(n, mapping.getOrDefault(mapping.get(n), 0) + 1);
        //     } else {
        //         mapping.put(n, 1);
        //     }
        // }
        // List<Integer>[] buckets = new List[nums.length + 1];
        // mapping.forEach((num, freq) -> {
        //     if (buckets[freq] == null) {
        //         buckets[freq] = new ArrayList<>();
        //     }
        //     buckets[freq].add(num);
        // });
        // List<Integer> result = new ArrayList<>();
        // for (int i = buckets.length - 1; i > 0 && result.size() < k; i--) {
        //     if (buckets[i] != null) {
        //         result.addAll(buckets[i]);
        //     }
        // }

        // return result.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        // // Contains Duplicate
        // int[] numbers = { 10, 20, 30, 40, 50 };
        // System.out.println(hasDuplicate(numbers));

        // // Valid Anagram
        // System.out.println(isAnagram("car", "rac"));

        // // Two Sum
        // int[] numbers = { 5, 5 };
        // System.out.println(Arrays.toString(twoSum(numbers, 10)));

        // // groupAnagrams
        // String[] strs = { "act", "pots", "tops", "cat", "stop", "hat" };
        // System.out.println(groupAnagrams(strs));

        int[] nums = { 1, 2, 2, 3, 3, 3, 4, 5, 5, 5 };
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));

    }

}
