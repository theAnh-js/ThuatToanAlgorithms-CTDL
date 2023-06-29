package HashTable;

import java.util.ArrayList;

public class MyHashSet {

    private final int SIZE = 1000;
    private ArrayList<Integer> myBuckets[]; // 1 mảng các arrayList

    MyHashSet() {
        myBuckets = new ArrayList[SIZE];
        for (int i = 0; i < myBuckets.length; i++) {
            // trong mảng myBuckets chứa 1000 phần tử ArrayList<>() từ 0 -> 999
            myBuckets[i] = new ArrayList<>();
        }
    }

    public ArrayList<Integer>[] getBuckets() {
        return this.myBuckets;
    }

    // tạo 1 mảng băm - hashFuntion, trả về hashValue
    private int hashFunction(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int hashValueIndex = hashFunction(key); // Băm các key ra thành các hashValueIndex
        var bucket = myBuckets[hashValueIndex]; // dùng var để đơ phải ghi cả cụm Array...,
        // biến bucket trỏ vào vị trí hashValueIndex của mảng myBuckets, vị trí này cũng
        // là 1 mảng ArrayList
        // trước khi add kiểm tra tồn tại hay chưa
        int keyIndex = bucket.indexOf(key); // keyIndex này chính là vị trí của key trong mảng ArrayList(mảng này nằm
                                            // trong mảng lớn myBuckets)
        if (keyIndex < 0) { // nếu chưa có thì mới add
            bucket.add(key);
        }
    }

    public void remove(int key) {
        // Băm key ra thành index
        int hashValueIndex = hashFunction(key);
        // Tạo biến trỏ tham chiếu đến vị trí đó trên myBuckets
        var bucket = myBuckets[hashValueIndex]; // (đây là mảng nhỏ trong mảng lớn myBuckets)
        // Kiểm tra + lấy ra index của key trong mảng bucket
        int index = bucket.indexOf(key);
        if (index >= 0) {
            bucket.remove(index);
        }
    }

    public boolean contains(int key) {
        int hashValueIndex = hashFunction(key);
        var bucket = myBuckets[hashValueIndex];
        int index = bucket.indexOf(key);
        if (index >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet mySet = new MyHashSet();
        mySet.add(1);
        mySet.add(1);
        mySet.add(2);
        // ArrayList<Integer> buckets[] = mySet.getBuckets();
        System.out.println(mySet.contains(1));
        System.out.println(mySet.contains(2));
        mySet.remove(2);
        System.out.println(mySet.contains(2));
    }

}
