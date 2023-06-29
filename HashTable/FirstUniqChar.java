package HashTable;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public static int firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        Map<Character, Integer> myMap = new HashMap<>();

        for (char c : chars) {
            if (myMap.containsKey(c) == false) {
                myMap.put(c, 1);
            } else {
                int soLanXuatHien = myMap.get(c);
                soLanXuatHien++;
                myMap.put(c, soLanXuatHien);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (myMap.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("aabbcdde"));
        System.out.println(firstUniqChar("theem"));
    }
}
