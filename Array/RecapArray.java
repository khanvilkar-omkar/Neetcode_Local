package Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecapArray {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keys = new HashMap<>();
        for (String s : strs) {
            int[] key = new int[26];
            for (char c : s.toCharArray()) {
                key[c - 'a']++;
            }
            keys.putIfAbsent(key.toString(), new ArrayList<String>());
            keys.get(key.toString()).add(s);
        }
        return new ArrayList<>(keys.values());
    }

    public static void main(String[] args) {
        String[] strs = { "act", "pots", "tops", "cat", "stop", "hat" };
        System.out.println(groupAnagrams(strs));

    }

}
