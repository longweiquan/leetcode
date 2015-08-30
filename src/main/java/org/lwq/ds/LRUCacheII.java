package org.lwq.ds;

import org.assertj.core.api.Assertions;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by longweiquan on 15/8/30.
 */
public class LRUCacheII {

    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCacheII(int capacity){
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > LRUCacheII.this.capacity;
            }
        };
    }

    public int get(int key){
        Integer value =  map.get(key);
        return value != null ? value : -1;
    }

    public void set(int key, int value){
        map.put(key, value);
    }


    public static void main(String[] args) {
        LRUCacheII cache = new LRUCacheII(2);
        cache.set(1, 1);
        cache.set(2,1);
        cache.set(2,2);
        Assertions.assertThat(cache.get(2)).isEqualTo(2);
        cache.set(3, 3);
        Assertions.assertThat(cache.get(1)).isEqualTo(-1);
    }
}
