package HashTable;

import java.util.HashMap;
import java.util.Map;

public class HashMapJava {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 3, 3, 3, 3 };
        Map<Integer, Integer> myMap = new HashMap<>();
        // key: gia tri cua phan tu trong mang
        // value: so lan xuat hien cua phan tu trong mang
        for (int i : arr) {
            if (myMap.containsKey(i) == false) { // i chua xua hien
                myMap.put(i, 1);
            } else {
                int soLanXuatHien = myMap.get(i); // lay ra value chinh la so lan xh
                soLanXuatHien++;
                myMap.put(i, soLanXuatHien); // update lai co lan xuat hien
            }
        }

        for (Map.Entry entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " xuat hien " + entry.getValue() + " lan");
        }

    }

}
