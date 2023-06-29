package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicographicalNumbers386 {

    // Lexicographical: theo thứ tự từ điển

    public static List<Integer> lexicalOrder(int n) {

        List<Integer> result = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        // Input: n = 13
        // Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
        for (int i = 1; i <= n; i++) {
            strings.add(String.valueOf(i));
        }
        Collections.sort(strings);

        for (int i = 0; i < strings.size(); i++) {
            int num = Integer.valueOf(strings.get(i));
            result.add(num);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = lexicalOrder(13);

        for (Integer x : result) {
            System.out.print(x + " ");
        }
    }

}
