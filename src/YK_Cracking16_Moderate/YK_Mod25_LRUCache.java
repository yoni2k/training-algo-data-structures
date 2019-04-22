package YK_Cracking16_Moderate;

import java.util.HashMap;
import java.util.LinkedList;

/*
Source: Cracking 16.25
Implement a cache with limited space.
Actions: add, lookup, update.
Every time a space runs out, remove oldest not used (added/looked up/updated) item.

Initial implementation before improvements from the book
 */

public class YK_Mod25_LRUCache {
    private HashMap<Integer,Integer> map;
    private LinkedList<Integer> list;
    private int maxSize;

    public YK_Mod25_LRUCache(int maxSize) {
        map = new HashMap<>();
        list = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void insert(int key, int value) {
        if(map.size() == maxSize) {
            int keyToRemove = list.remove();//remove first
            map.remove(keyToRemove);
        }
        map.put(key, value);
        list.add(key);//add to the end
    }

    public int retrieve(int key) {
        return map.get(key);
    }

    public void update(int key, int value) {
        list.remove((Integer)key);
        insert(key, value);
    }
}
