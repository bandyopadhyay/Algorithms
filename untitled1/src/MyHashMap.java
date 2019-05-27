public class MyHashMap {

    Integer[] arr;

    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new Integer[1000000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key]=value;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        if(arr[key]!= null) return  arr[key];
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key]=null;
    }
}
